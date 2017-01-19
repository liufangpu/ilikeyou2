package site.jjilikeyou.www.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.jjilikeyou.www.model.Message;
import site.jjilikeyou.www.pojo.User;
public interface UserDao {

	User checkName(@Param("username")String username);

	int addUser(User user);

	User login(User user);

	User checkEmail(String email);

	List<Message> getMessageList(@Param("email")String email);

	String getPasswordByEmail(@Param("email")String email);

}
