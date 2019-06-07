package com.placement.portal.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placement.portal.dto.ApiResponse;
import com.placement.portal.dto.UserRequestDto;
import com.placement.portal.dto.UserResponseDto;
import com.placement.portal.model.User;
import com.placement.portal.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ApiResponse<UserResponseDto> saveUser(@Valid @RequestBody UserRequestDto userDto) {
		User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getPasswordConfirm(),
				userDto.getEmail(), userDto.getPhone(), userDto.getRole_name());
		userService.save(user);
		UserResponseDto userResObj = new UserResponseDto(userService.findByUsername(user.getUsername()));
		logger.info("user registered successfully.");
		return new ApiResponse<>(HttpStatus.CREATED.value(), "User registered successfully", userResObj);
	}

	@GetMapping("/{id}")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public ApiResponse<UserResponseDto> getOne(@PathVariable Long id) {
		UserResponseDto userResObj = new UserResponseDto(userService.findById(id));
		return new ApiResponse<>(HttpStatus.OK.value(), "success", userResObj);
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

}
