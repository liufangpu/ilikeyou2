package site.jjilikeyou.www.service;

import java.util.List;

import site.jjilikeyou.www.model.Message;
import site.jjilikeyou.www.pojo.User;

public interface UserService {

	User checkName(String username);

	int addUser(User user);

	User login(User user);

	User checkEmail(String email);

	List<Message> getMessageList(String email);
  
}
