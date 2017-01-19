package site.jjilikeyou.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.jjilikeyou.www.dao.UserDao;
import site.jjilikeyou.www.model.Message;
import site.jjilikeyou.www.pojo.User;
import site.jjilikeyou.www.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User checkName(String username) {
		User user=userDao.checkName(username);
		return user;
	}
	@Override
	public int addUser(User user) {
		int i=userDao.addUser(user);
		return i;
	}
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}
	@Override
	public User checkEmail(String email) {
		return userDao.checkEmail(email);
	}
	@Override
	public List<Message> getMessageList(String email) {
		
		return userDao.getMessageList(email);
	}
	@Override
	public String getPasswordByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getPasswordByEmail(email);
	}

}
