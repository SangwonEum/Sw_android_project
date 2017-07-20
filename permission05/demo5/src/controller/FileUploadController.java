package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.FileModel;

@Controller
public class FileUploadController {
	
   @Autowired
   ServletContext context; 

   @RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
   public ModelAndView fileUploadPage(HttpServletResponse response)  {
      FileModel file = new FileModel();
      ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
      System.out.println("file upload page");
     
      
      String filepath = new File("").getAbsolutePath();
      System.out.println("filepath = "+ filepath);
      
      
      try{
      
      URL url = getClass().getResource("submit.jpg");
      //System.out.println("url getpath="+ url.getPath());
    	  File f = new File(filepath+"\\ic_launcher.jpg");
    	  System.out.println("file2= "+ f.getAbsolutePath());
    	  OutputStream os = new FileOutputStream(filepath+"\\example.jpg");
    	  InputStream is = new FileInputStream(f);
    	  System.out.println(f.getAbsolutePath());
    	  System.out.println("is read = ");
    	  byte[] buf = new byte[8192];
    	  
    	  
    	  int c = 0;
    	  while((c = is.read()) >= 0){
    		  System.out.println(c);
    		  os.write(c);
    		 // System.out.println("num= "+ c);
    	  }
//    	  while((c= is.read(buf,0,buf.length))> 0){
//    		  os.write(buf, 0, c);
//    		  System.out.println(c);
//    		  os.flush();
//    	  }
    	  os.close();
    	  System.out.println("stop");
    	  is.close();
    	  
      }catch(Exception e){
    	  e.printStackTrace();
      }
      return modelAndView;
   }

  // @RequestMapping(value="/fileUploadPage", method = RequestMethod.POST)
//   @RequestMapping(value="/fileUploadPage")
//   public String fileUpload(@Validated FileModel file
//		   , BindingResult result, ModelMap model,HttpServletRequest req) throws IOException {
//	   System.out.println("fileUploadPage2");
//	   
//   @RequestMapping(value="/fileUploadPage")
//   public String fileUpload(@Validated FileModel file) throws IOException {
//	   System.out.println("fileUploadPage2");
   
//@RequestMapping(value="/fileUploadPage")
//public String fileUpload(@Validated FileModel file) throws IOException {
//   System.out.println("fileUploadPage2");
	  
   @RequestMapping(value="/fileUploadPage")
   public String fileUpload(@RequestParam("uploaded_file") MultipartFile file) throws IOException {
	   
	  System.out.println("multipartfile");
	  System.out.println(file.getName());
	  System.out.println(file.getSize());
	   
	   //      
//	   BufferedInputStream in = null;	
//	   FileOutputStream fout = null;
//	   ServletInputStream sis = null;
//	   String filepath = new File("").getAbsolutePath();
//	   if (result.hasErrors()) {
//         System.out.println("validation errors");
//         return "fileUploadPage";
//      } else {  
//    
//         System.out.println("Fetching file");
//         try {
//        	 
//        	
//			System.out.println(req.getRequestURL());
//			System.out.println(req.getMethod());
			
			
//			
//			URL url = new URL(req.getRequestURI());
//			in  = new BufferedInputStream(url.openStream());
//			
//			//in = req.getInputStream();
//			fout = new FileOutputStream("please");
//			
//			byte data[] = new byte[1024];
//			int count;
//			while((count = in.read(data,0,1024))!= -1){
//				fout.write(data,0,count);
//				System.out.println(count);
//			}
			
//			  	sis = req.getInputStream();
//			    // maybe I should be using a BufferedInputStream 
//			    // instead of the InputStream directly?
//			    int available = sis.available();
//			    byte[] input = new byte[available];
//			    int readBytes = sis.read(input,0,available);
//			    if(readBytes!=available) {
//			      throw new ServletException("Oops! readBytes!=availableBytes");
//			    }

			    // I ONLY GET 1 BYTE OF DATA !!! 
			    // It's the first byte of the client message, a '<'.
//			    String msg = "Read "+readBytes+" bytes of "
//			                 +available+" available from request InputStream.";
//			    System.err.println("Server.process(HttpServletRequest,HttpServletResponse): "+msg);
//			    String xmlReply = "<Reply><Message>"+msg+"</Message></Reply>";
//			    byte[] data = xmlReply.getBytes("UTF-8");
			    //ServletOutputStream sos = response.getOutputStream();
			    //sos.write(data, 0,data.length);
			    //sos.flush();
			    //sos.close();
			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(in != null)
//				in.close();
//			if(fout != null){
//				fout.close();
//			}
//			System.out.println("Done");
//		}
        
         //MultipartFile multipartFile = file.getFile();
         //String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
         //System.out.println(multipartFile.toString());
         //Now do something with file...
         //FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
         //String fileName = multipartFile.getOriginalFilename();
         //model.addAttribute("fileName", fileName);
         return "success";
         
    	
      }
   }
//}