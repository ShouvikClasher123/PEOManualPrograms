package com.cisco.peo.controller;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.peo.bean.User;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;
import com.cisco.peo.service.UserService;

@RestController
@RequestMapping("/request")
@Api(value = "User Resource")
public class UserController {
	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private SILogger logException;
	@Autowired
	private PEOException siException;

	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchUserDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> fetchUserDetails(
			@RequestParam("userId") String userId) {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: [{}]", userId);
			}
			return ResponseEntity.ok(this.userService.fetchUserDetails(userId));
		} catch (Exception e) {
			this.siException.initialize("amigaura", "order-error",
					(" " + e).trim(), e);
			this.logException.logException(this.siException);
			return (ResponseEntity<User>) ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
