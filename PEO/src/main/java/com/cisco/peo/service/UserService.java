package com.cisco.peo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.bean.User;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;

@Service
public class UserService {

	@Autowired
	private SILogger logException;
	@Autowired
	private PEOException siException;

	String status = "Pending";
	String type = "Add";

	public User fetchUserDetails(String userId) {
		User user1 = new User();
		user1.setUserId("suhani");
		user1.setName("Suhani Kshatriya");
		user1.setEmailId("suhanik94@gmail.com@");
		user1.setStatus(status);
		user1.setType(type);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String today = dateFormat.format(new Date());
		user1.setDate(today);

		User user2 = new User();
		user2.setUserId("sowmil");
		user2.setName("Sowmil Nooji");
		user2.setEmailId("sowmil@cisco.com");
		user2.setStatus(status);
		user2.setType(type);
		user2.setDate(today);

		User user3 = new User();
		user3.setUserId("amit");
		user3.setName("Amit Gaurav");
		user3.setEmailId("amit@cisco.com");
		user3.setStatus(status);
		user3.setType(type);
		user3.setDate(today);

		User user4 = new User();
		user4.setUserId("shankar");
		user4.setName("Shankar Selvaraj");
		user4.setEmailId("shankar@cisco.com");
		user4.setStatus(status);
		user4.setType(type);
		user4.setDate(today);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<User> userList = new ArrayList();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		for (User user : userList) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

}
