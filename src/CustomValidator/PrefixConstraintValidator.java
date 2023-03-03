package CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrefixConstraintValidator implements ConstraintValidator<StringPrefix, String>{

	private String textPrefix;
	
	// Methods that need override from ConstraintValidator interface
	/* Spring MVC will automatically call these methods for obtaining the desired string prefix  
	 from the StringPrefix annotation, then validate and return the boolean value */
	@Override
	public void initialize(StringPrefix constraintAnnotation) {
		textPrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String textFromUser, ConstraintValidatorContext context) {
		boolean result;
		 
		if(textFromUser == null) {
			 return true;
		 } else {
			 result = textFromUser.startsWith(textPrefix);
		 }
		return result;
	}

	
}
