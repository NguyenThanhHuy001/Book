package vn.nhasach.services.Impl;

import vn.nhasach.daos.UserDao;
import vn.nhasach.daos.Impl.UserDaoImpl;
import vn.nhasach.models.UserModel;
import vn.nhasach.services.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String Username, String Password)
	{
		UserModel user = this.FindUserService(Username);
		if (user != null && Password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	@Override
	public UserModel FindUserService(String Username)
	{
		return userDao.FindUserDao(Username);
	}

}
