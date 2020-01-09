package com.eb.test.servicesDao;

import org.springframework.stereotype.Service;

import com.eb.test.model.TestMd;










@Service
public class TestServices {
	public TestMd Hellow() {
		TestMd user=new TestMd();
		user.setName("aaa");
		user.setPsw("eeee");
		System.out.println(user.toString());
		return user;
	}

}
