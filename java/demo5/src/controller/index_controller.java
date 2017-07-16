package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;

@Controller
@RequestMapping("/")
public class index_controller {
	
	@RequestMapping("")
	public ModelAndView index_show(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		System.out.println("index controller");
		return mav;
		
	}
	
	@RequestMapping("/submit_page")
	public ModelAndView submit_page(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("submit");
		//System.out.println("submit"+ map.to);
		
//		if(file.isEmpty()){
//			System.out.println("empty");
//		}else{
//			System.out.println("not empty");
//		}
		return mav;
		
	}
	
	@RequestMapping(value = "/example", method = RequestMethod.POST)
	public void example(@RequestParam(name = "file") File file){
	

		System.out.println("file");
		
	}


}
