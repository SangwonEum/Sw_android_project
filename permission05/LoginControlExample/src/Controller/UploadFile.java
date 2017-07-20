package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
public class UploadFile extends HttpServlet {
	
	
	public UploadFile(){
		super();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String fileurl = "http://pad3.whstatic.com/images/thumb/9/9b/Get-the-URL-for-Pictures-Step-2-Version-4.jpg/aid597183-v4-728px-Get-the-URL-for-Pictures-Step-2-Version-4.jpg.webp";
		URL url = new URL(fileurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int responseCode = con.getResponseCode();
		System.out.println("response code: "+ responseCode);
		int BUFFERED_SIZE = 10;
		if(responseCode == HttpURLConnection.HTTP_OK){
			String fileName="";
			String disposition = con.getHeaderField("Content-Disposition");
			String contentType = con.getContentType();
			int contentLength = con.getContentLength();
			if(disposition != null){
				int index = disposition.indexOf("filename");
				if(index > 0){
					fileName = disposition.substring(index+10, disposition.length()-1);
				}
			}else{
				fileName = fileurl.substring(fileurl.lastIndexOf("/")+1,fileurl.length());
			}
			System.out.println("content-type:"+ contentType);
			System.out.println("content-disposition:"+ disposition);
			System.out.println("conenction length:"+ contentLength);
			System.out.println("file name: "+ fileName);
			
			String relativeWebPath = "/WebContent/";
			String absolutePath = getServletContext().getRealPath(relativeWebPath);
			absolutePath = absolutePath.substring(0,absolutePath.length()-1);
			System.out.println("absolutepath: "+ absolutePath);
			System.out.println("last index ="+ absolutePath.lastIndexOf("\\"));
			
			String newPath = absolutePath.substring(0,absolutePath.lastIndexOf("\\"));
			System.out.println("newPath =>"+ newPath);
			
			System.out.println("absolute path: "+ absolutePath);
			
			String imagePath = newPath + "\\img\\";
			InputStream inputStream = con.getInputStream();
			String saveFilePath = imagePath + fileName;
			System.out.println("saveFilePath::"+ saveFilePath);
			
			
			File file = new File(saveFilePath);
			file.getParentFile().mkdirs();
			FileWriter writer = new FileWriter(file);
			FileOutputStream outputStream = new FileOutputStream(saveFilePath);
			
			int bytesRead = -1;
			byte[] buffer = new byte[BUFFERED_SIZE];
			
			while((bytesRead = inputStream.read(buffer))!= -1){
				outputStream.write(buffer,0,bytesRead);
			}
			outputStream.close();
			inputStream.close();
//			
//			int bytesRead  = -1;
//			byte[] buffer = new byte[100];
//			while((bytesRead= inputStream.read(buffer))!= -1){
//				outputStream.write(buffer,0,bytesRead);
//			}
//			outputStream.close();
//			inputStream.close();
//			System.out.println("file downloaded");
		}else{
			System.out.println("No file to download");
		}
		con.disconnect();
		
		
		
	}

}
