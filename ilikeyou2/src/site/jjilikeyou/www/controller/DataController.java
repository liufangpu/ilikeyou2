package site.jjilikeyou.www.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.jjilikeyou.www.model.Message;
import site.jjilikeyou.www.model.Result;
import site.jjilikeyou.www.pojo.User;
import site.jjilikeyou.www.service.DataService;
import site.jjilikeyou.www.service.UserService;
import site.jjilikeyou.www.util.IPUtil;

@Controller
@RequestMapping("/data")
public class DataController {
	@Autowired
	private DataService dataService;
	@Autowired
	private UserService userSerivce;
	
	@RequestMapping(value="/msg",method=RequestMethod.POST)
	@ResponseBody
	public Result data(HttpServletRequest request,HttpSession session,@RequestParam("fullname")String fullname,@RequestParam("message") String messageStr){
		User user = (User) session.getAttribute("user");
		String email= user.getEmail();
		Message message=new Message();
		message.setEmail(email);
		message.setFullname(fullname);
		message.setMessage(messageStr);
		Result result=new Result();
		String ipAddr = IPUtil.getIpAddr(request);
		//String remoteAddr = request.getRemoteAddr();
		IPUtil ipUtil=new IPUtil();
		String addresses="";
		try {
			 addresses = ipUtil.getAddresses("ip="+ipAddr, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		message.setIp(ipAddr);
		message.setIpName(addresses);
		try {
			dataService.sendMsg(message);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/getEmailList")
	public void getEmailList( HttpServletRequest request){
		String email = request.getParameter("emailId");
		List<Message> messages=userSerivce.getMessageList(email);
		System.out.println(messages);
		System.out.println("进来了。。。。。。");
	}
	
}
