package com.placement.portal.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.placement.portal.dto.UserRequestDto;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(final PasswordMatches constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
		final UserRequestDto user = (UserRequestDto) obj;
		if(user.getPassword() != null && user.getPasswordConfirm() != null) {
			return user.getPassword().equals(user.getPasswordConfirm());
		} else {
			return false;
		}		
	}

}
