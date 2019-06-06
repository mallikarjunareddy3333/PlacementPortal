package ecms.placement.portal.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ecms.placement.portal.dto.UserRequestDto;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(final PasswordMatches constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
		final UserRequestDto user = (UserRequestDto) obj;
		return user.getPassword().equals(user.getPasswordConfirm());
	}

}
