package firstPackage;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// Mark this class as the controller
// The parent URL mapping is /student
@Controller
@RequestMapping("/student")
public class StudentConctroller {
	
	// This method don't include validation rules
	/* This method utilizes form tags from Spring MVC that will provide HTML code generation, 
	and the main benefit-data binding */
	// We will need a empty object to store as the model attribute (the attribute of the model)
	/* Spring MVC behind the scenes will automatically call getter and setter methods for corresponding 
	 data binding (when the form is loaded and submitted)*/
	@RequestMapping("/inputFormTags")
	public String inputFormWithTags(Model model) {
		// Add model attribute
		model.addAttribute("student", new Student());
		return "inputFormTags";
	}
	
	// This method will be for the JSP file included validation rules
	@RequestMapping("/inputFormTagsValidation")
	public String inputFormWithTagsValidation(Model model) {
		// Add model attribute
		model.addAttribute("student", new Student());
		return "inputFormTagsValidation";
	}
	
	@RequestMapping("/processFormWithModelTags")
	// Retrieve the Student object from the model attribute by @ModelAttribute
	/* Note that if we don't have the model as the method parameter, we won't be able to access 
	 its attributes on the view files (using ${attributeName.fieldName). */
	public String processFormWithModelTags(@ModelAttribute("student") Student student,Model model) {
		model.addAttribute("student", student);
		return "processFormWithModelTags";
	}
	
	@RequestMapping("/processFormWithModelTagsValidation")
	/* The method will also include validation for the form data by using @Valid annotation and 
	 the BindingResult class */
	/* When Spring MV detect @Valid, it will start validation process on the object using 
	 defined validators. Results of the validation will then be put to the BindingResult object, and 
	 the BindingResult object will also be added to the view model (because we will need the model so that
	 data can be read from the JSP file). 
	 */
	public String processFormWithModelTagsValidation(@Valid @ModelAttribute("student") Student student, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "inputFormTagsValidation";
		} else {
			return "processFormWithModelTags";
		}
	}
	
	/* @InitBinder annotation works as the pre-processor that will pre-process all requests that 
	 come into the controller. In this case, it can be used to trim whitespaces in the text fields. 
	 If there are only whitespaces, the pre-processor will trim it all to null. */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		/* StringTrimmerEditor is the Spring API for trimming leading and trailing whitespaces.
		 if we pass the boolean value as true, in the case there are only whitespaces in the text field, 
		 the pre-processor will trim it all to null. */
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmerEditor);
	}
	
}
