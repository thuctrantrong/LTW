package vn.iostar.service;

import vn.iostar.model.Usermodel;

public interface UserService {

	Usermodel login(String username, String password);
	Usermodel findbyusername (String username);
	Usermodel registeruser(String username, String password, String fullname, String email,
			String phone, int roleid, String createDate) throws Exception;
	boolean forget(String username, String password);
	void update (String username, String imagines);
}
