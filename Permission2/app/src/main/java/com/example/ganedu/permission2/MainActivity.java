package com.example.ganedu.permission2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.ganedu.permission2.R.id.webView;

//import static com.example.ganedu.permission2.R.id.image01;

public class MainActivity extends AppCompatActivity {




    private WebView web;
    private  ImageView Iview01;
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
        //Iview01 = (ImageView)findViewById(image01);
        web.addJavascriptInterface(new MyJavascriptInterface(this), "Android");

        web.clearCache(true);
        web.clearHistory();




        WebSettings settings =  web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        web.loadUrl("http://github.tkddnjsdja.tk/");
       // web.setWebViewClient(new myWebClient());
        // web.setWebChromeClient(new WebChromeClient(){});


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
           if(resultCode == RESULT_OK && null != intent){
               Uri selectedImage = intent.getData();
               web.loadUrl("javascript:setFileUri('" + selectedImage.toString() + "')");
               String path = getRealPathFromURI(this, selectedImage);
               web.loadUrl("javascript:setFilePath('" + path + "')");


               BitmapFactory.Options options = new BitmapFactory.Options();
               options.inPreferredConfig = Bitmap.Config.ARGB_8888;
               Bitmap bitmap = BitmapFactory.decodeFile(path,options);


               ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
               bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
               byte[] byteArray = byteArrayOutputStream.toByteArray();
               String imageBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
               String image = "data:image/png;base64," + imageBase64;
               String temp = "./img/logo.png";
               web.loadUrl("javascript:setImage('"+ image  +"')");
               //Iview01.setImageBitmap(bitmap);
               //saveBitmaptoJpeg(bitmap,"img","temp",web,path);


           }
        }
    }

    public String getRealPathFromURI(Context context, Uri contentUri)
    {
        Cursor cursor = null;
        try
        {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        finally
        {
            if (cursor != null)
            {
                cursor.close();
            }
        }
    }

    public static void saveBitmaptoJpeg(Bitmap bitmap , String folder,String name,WebView web,String path){
        String ex_storage  = Environment.getExternalStorageDirectory().getAbsolutePath();
        String folder_name = "/"+ folder +"/";
        String file_name = name + ".jpg";
        String string_path = ex_storage+folder_name;

        File file_path;
        try{
            file_path = new File(string_path);
            if(!file_path.isDirectory()){
                file_path.mkdir();
            }
            web.loadUrl("javascript:setRealPath('" + string_path + file_name + "')");
            FileOutputStream out = new FileOutputStream(string_path + file_name);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.close();

        }catch(FileNotFoundException e){
            Log.e("FileNotFoundException",e.getMessage());
        }catch(IOException e){
            Log.e("IOException", e.getMessage());
        }


    }




}
