package site.jjilikeyou.www.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.jjilikeyou.www.model.Message;
import site.jjilikeyou.www.model.Result;
import site.jjilikeyou.www.pojo.User;
import site.jjilikeyou.www.service.UserService;
import site.jjilikeyou.www.util.IPUtil;
import site.jjilikeyou.www.util.JsonUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userSerivce;
	
	@RequestMapping("/checkName")
	public void checkUsername(@RequestParam("username")String username,HttpServletResponse response){
		System.out.println(username);
		User user=userSerivce.checkName(username);
		System.out.println(user);
		if (user==null) {
			doResponse(response, "true");
		}else {
			doResponse(response, "false");
		}
	}
	@RequestMapping("/checkEmail")
	public void checkEmail(@RequestParam("email")String email,HttpServletResponse response){
		User user=userSerivce.checkEmail(email);
		System.out.println(user);
		if (user==null) {
			doResponse(response, "true");
		}else {
			doResponse(response, "false");
		}
	}
	@RequestMapping("/addUser")
	public void addUser(HttpServletResponse response,@RequestParam("name") String name,@RequestParam("password")String password,@RequestParam("email")String email){
		System.out.println(name);
		User user=new User(name, password, email);
		int i=userSerivce.addUser(user);
		System.out.println("cha"+i);
		if (i>0) {
			doResponse(response, "true");
		}else {
			doResponse(response, "false");
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(Model model,HttpServletRequest request,Map<String, Object>map,HttpSession session,HttpServletResponse response,@RequestParam("username")String email,@RequestParam("password")String password){
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		User user2=userSerivce.login(user);
		List<Message> messages=userSerivce.getMessageList(email);
		System.out.println(messages);
		session.setAttribute("messages", messages);
		Result result =new Result();
		if (user2!=null) {
			session.setAttribute("user", user2);
			result.setSuccess(true);
		}else {
			result.setSuccess(false);
		}
		return result;
	}
	public static void doResponse(HttpServletResponse response,Object object){
		response.setCharacterEncoding("utf-8");
		
		try {
			PrintWriter writer = response.getWriter();
			writer.print(object);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
}
