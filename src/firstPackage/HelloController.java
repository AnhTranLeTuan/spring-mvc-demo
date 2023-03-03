package firstPackage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// The annotation inherited from @Component
@Controller
@RequestMapping("/root")
public class HelloController {
	
	// Map URL to the method
	// The controller method to show the initial HTMl form
	@RequestMapping("/inputForm")
	public String inputForm() {
		return "inputForm";
	}
	
	@RequestMapping("/inputFormWithFormTags")
	public String inputFormWithFormTags() {
		return "inputFormWithFormTags";
	}
	
	// The controller method to process the HTMl form
	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}
	
	/* Using the HttpServletRequest class for obtain the object that contain the HTML form data.
	We can retrieve the data of the desired parameter from it */
	@RequestMapping("/processFormWithModel")
	public String processFormWithModel(HttpServletRequest request, Model model) {
		String information = request.getParameter("information");
		model.addAttribute("info", information.toUpperCase());
		return "processFormWithModel";
	}
	
	/* This method utilize @RequestParam that put right at the method's parameter for faster 
	retrieving the data of the HTML form */
	@RequestMapping("/processFormWithModelAnnotation")
	public String processFormWithModelAnnotation(@RequestParam("information") String information, Model model) {
		model.addAttribute("info", information.toUpperCase());
		return "processFormWithModel";
	}

}
