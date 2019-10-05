package com.placement.portal.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placement.portal.dto.ApiResponse;
import com.placement.portal.dto.LoginUserDto;
import com.placement.portal.model.AuthToken;
import com.placement.portal.model.User;
import com.placement.portal.service.UserService;
import com.placement.portal.utils.JwtTokenUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public ApiResponse<AuthToken> generateToken(@Valid @RequestBody LoginUserDto loginUser)
			throws AuthenticationException {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		final User user = userService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return new ApiResponse<>(200, "success", new AuthToken(token, loginUser.getUsername(), user.getRoles()));

	}

}
