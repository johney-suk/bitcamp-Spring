package org.comstudy21.myweb.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		userListTest(null);
	}
	public static void insertUserTest(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO("HONG","1234","홍길동","User");
		userService.insertUser(vo);
		
		System.out.println("사용자 정보 등록 완료!");
		container.close();
		userListTest(args);
	}

	public static void userListTest(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");

		List<UserVO> userList = userService.getUserList(null);
		for (UserVO user : userList) {
			System.out.println(user);
		}
		container.close();

	}

}
