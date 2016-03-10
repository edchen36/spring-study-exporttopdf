package study.spring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String>{

	@Override
	public void initialize(Phone arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null) {
			return false;
		}
        //validate phone numbers of format "91234567" or "81234567"
		 
	 	//checking length of phone number should be 8
		
		if(value.matches("\\d{8}")) {
			return true;
		} else if(value.matches("\\[9][8]d{7}")) {
			return true;
		} else {
			return false;
		}
				
	}

}
