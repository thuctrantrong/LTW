package vn.iostar.service;

import vn.iostar.model.Usermodel;

public interface UserService {

	Usermodel login(String username, String password);
	Usermodel findbyusername (String username);
	Usermodel registeruser(String username, String password, String imagines, String fullname, String email,
			String phone, int roleid, String createDate) throws Exception;
}
