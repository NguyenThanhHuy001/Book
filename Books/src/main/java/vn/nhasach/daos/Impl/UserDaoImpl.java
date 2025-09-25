package vn.nhasach.daos.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vn.nhasach.configs.ConnectSQL;
import vn.nhasach.daos.UserDao;
import vn.nhasach.models.UserModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel FindUserDao(String Username) {
		String sql = "SELECT * FROM [Users] WHERE Username = ? ";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("Id"));
				user.setMail(rs.getString("Mail"));
				user.setUsername(rs.getString("Username"));
				user.setFullname(rs.getString("Fullname"));
				user.setPassword(rs.getString("Password"));
				user.setAvatar(rs.getString("Avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("Roleid")));
				user.setPhone(rs.getString("Phone"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel User) {
		String sql = "INSERT INTO [Users](Username,Password,Mail,Roleid,Fullname,Phone,) VALUES (?,?,?,?,?,?,?)";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, User.getUsername());
			ps.setString(2, User.getPassword());
			ps.setString(3, User.getMail());
			ps.setInt(4, User.getRoleid());
			ps.setString(5, User.getAvatar());
			ps.setString(6, User.getFullname());
			ps.setString(7, User.getPhone());	
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkExistEmail(String Mail) {
		boolean check = false;
		String query = "select * from [users] where Mail = ?";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Mail);
			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return check;
	}

	@Override
	public boolean checkExistUsername(String Username) {
		boolean check = false;
		String query = "select * from [Users] where Username = ?";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Username);
			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return check;
	}

	@Override
	public boolean checkExistPhone(String Phone) {
		boolean check = false;
		String query = "select * from [Users] where Username = ?";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return check;

	}

}
