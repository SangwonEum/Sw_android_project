package com.example.codeback.permission;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.codeback.permission.R.id.webView;

public class MainActivity extends AppCompatActivity {


    private WebView web;
    private String url = "url";
    private ValueCallback<Uri> mUploadMessage;
    private final static int FILECHOOSER_RESULTCODE=1;
    private static String TAG = "PermissionDemo";
    private final static int   MY_PERMISSIONS_REQUEST_READ_CONTACTS =  010;
    LinearLayout ln1;
    ProgressBar progressBar;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



     // Here, thisActivity is the current activity
     if (ContextCompat.checkSelfPermission(this,
             Manifest.permission.READ_EXTERNAL_STORAGE)
             != PackageManager.PERMISSION_GRANTED) {

         // Should we show an explanation?
         if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                 Manifest.permission.READ_EXTERNAL_STORAGE)) {

             // Show an expanation to the user *asynchronously* -- don't block
             // this thread waiting for the user's response! After the user
             // sees the explanation, try again to request the permission.

         } else {

             // No explanation needed, we can request the permission.

             ActivityCompat.requestPermissions(this,
                     new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                     MY_PERMISSIONS_REQUEST_READ_CONTACTS);



             // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
             // app-defined int constant. The callback method gets the
             // result of the request.
         }
     }





        web  = (WebView)findViewById(webView);

        WebSettings settings =  web.getSettings();
        web.addJavascriptInterface(new MyJavascriptInterface(this), "Android");


        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        web.loadUrl("http://github.tkddnjsdja.tk/");
        web.setWebViewClient(new myWebClient());
        web.setWebChromeClient(new WebChromeClient(){

            //For android < 3.0
            public void openFileChooser(ValueCallback<Uri> uploadMsg) {

                mUploadMessage = uploadMsg;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("image/*");
                MainActivity.this.startActivityForResult(Intent.createChooser(i,"File Chooser"), FILECHOOSER_RESULTCODE);

            }

            // For Android 3.0+
            public void openFileChooser( ValueCallback uploadMsg, String acceptType ) {
                mUploadMessage = uploadMsg;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("*/*");
                MainActivity.this.startActivityForResult(
                        Intent.createChooser(i, "File Browser"),
                        FILECHOOSER_RESULTCODE);
            }
            //For android 3.0+
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                mUploadMessage = uploadMsg;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("image/*");
                MainActivity.this.startActivityForResult(Intent.createChooser(i, "File Chooser"), MainActivity.FILECHOOSER_RESULTCODE);
                // startActivityForResult(i,MainActivity.FILECHOOSER_RESULTCODE);
            }

        });


    }

    class MyJavascriptInterface
    {

        Context mContext;

        /** Instantiate the interface and set the context */
        MyJavascriptInterface(Context c)
        {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast)
        {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public String choosePhoto()
        {
            // TODO Auto-generated method stub
            String file = "test";
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, FILECHOOSER_RESULTCODE);
            return file;
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode==FILECHOOSER_RESULTCODE){
            if(null == mUploadMessage)return;
            Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }
    }



    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            //  progressBar.setVisibility(View.GONE);
        }
    }

    //flipscreen not loading again
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }


}









