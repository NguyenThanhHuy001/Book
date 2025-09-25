package vn.nhasach.daos;

import vn.nhasach.models.UserModel;

public interface UserDao 
{
	//Login check tk mk
	UserModel FindUserDao(String Username);
	//Register
	//register
		public void insert(UserModel User);
		boolean checkExistEmail(String Mail);
		boolean checkExistUsername(String Username);
		boolean checkExistPhone(String Phone);
}
