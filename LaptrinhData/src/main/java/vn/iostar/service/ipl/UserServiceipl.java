package vn.iostar.service.ipl;

import vn.iostar.model.Usermodel;
import vn.iostar.service.UserService;
import vn.iostar.dao.iuserdao;
import vn.iostar.dao.ipl.USerDaoImpl;

public class UserServiceipl implements UserService {

	iuserdao userDao = new USerDaoImpl();

	@Override
	public Usermodel login(String username, String password) {
		Usermodel user = this.findbyusername(username);

		//password.toString().trim() == user.getPassword().toString().trim()
		  if (user != null && user.getPassword().trim().equals(password) ) { 
				  return user; 		  
		  }	  
		  return null;
		 
	}
	
	
	@Override
	public Usermodel findbyusername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}
	@Override
	public void update(String username, String imagines)
	{
		userDao.update(username, imagines);
	}

	public static void main(String[] args) {
	 	
		UserServiceipl userDao = new UserServiceipl();
        System.out.println(userDao.login("a","a"));
        //List<UserModel> list = userDao.findAll();
       // for (UserModel user : list) {
       //     System.out.println(user);
       // }
    }


	@Override
	public Usermodel registeruser(String username, String password, String fullname,
			String email, String phone, int roleid, String createDate) throws Exception {
			if(userDao.findByUserName(username) != null) {
				throw new Exception("Username existed");
			}
			Usermodel user = new  Usermodel(username,password,fullname,email,phone,roleid,createDate);
			  if (userDao.insert(user) ) { 
					  return user; 		  
			  }
			  return null;
			
	}


	@Override
	public boolean forget(String username, String password) {
		if(userDao.forgetdao(username,password) == true) {
			return true ;
		}  
		  return false;
	}




}
