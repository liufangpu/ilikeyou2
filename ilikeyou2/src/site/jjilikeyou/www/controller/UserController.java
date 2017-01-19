package site.jjilikeyou.www.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import site.jjilikeyou.www.util.MailUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userSerivce;
	private static Logger logger = Logger.getLogger(UserController.class);
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
	@ResponseBody
	public Result checkEmail(@RequestParam("email")String email){
		User user=userSerivce.checkEmail(email);
		Result result=new Result();
		if (user==null) {
			result.setSuccess(true);
		}else {
			result.setSuccess(false);
		}
		return result;
	}
	@RequestMapping("/addUser")
	public void addUser(HttpServletResponse response,@RequestParam("name") String name,@RequestParam("password")String password,@RequestParam("email")String email){
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
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/sign-in.jsp";
		
	}
	
	@RequestMapping("/forgotPsw")
	public String forgotPsw(@RequestParam("email")String email){
		MailUtil mailUtil=new MailUtil();
		logger.info("申请密码的邮箱："+email);
		String password=userSerivce.getPasswordByEmail(email);
		logger.info("查询到的密码:"+password);
		mailUtil.setAddress("wyyxlfp@163.com", email, "来自liufangpu的官方邮件--忘记密码申请");
		String content="您的密码为"+password+"请牢记！您看到这封邮件是来自liufangpu忘记密码官方邮件，如果本人未作任何操作，请忽略！";
		try {
			mailUtil.setConent(content);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		Multipart multipart = mailUtil.getMultipart();
		
		mailUtil.send("smtp.163.com", "wyyxlfp@163.com", "lfpzhi21",multipart);
		return "redirect:/sign-in.jsp";
	}
	
}
