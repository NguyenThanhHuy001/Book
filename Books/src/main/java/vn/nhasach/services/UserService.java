package vn.nhasach.services;

import vn.nhasach.models.UserModel;
public interface UserService 
{
	UserModel login(String Username, String Password);
	UserModel FindUserService(String Username);
}
