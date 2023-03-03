package CustomValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/* @Constraint is for mapping the annotation to the class that contain its logics. @Constraint will require the passing
 class to implement the ConstraintValidator interface */
// @Target is for telling where we can use this annotation on. In this case, it can be used on methods and fields
/* @Retention is for telling how long this annotation will be able to retained or hold. In this case, it will still
  be kept on the bytecode for later use at runtime */
@Constraint(validatedBy=PrefixConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface StringPrefix {
	
	// If the user don't provide any data, the default value will be used instead
	public String value() default "VOUCHER";
	
	public String message() default "\"VOUCHER\" Must be at the Beginning";
	
	/* This groups() method will be required to avoid the exception
	 "ConstraintDefinitionException: HV000074: CustomValidator.StringPrefix contains Constraint annotation, but does not contain a groups parameter" */
	public Class<?>[] groups() default {};
	
	// The payload() method is for providing custom details about validation failure such as error code, severity level,...
	public Class<? extends Payload>[] payload() default {};

}

