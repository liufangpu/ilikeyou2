package site.jjilikeyou.www.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
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
}