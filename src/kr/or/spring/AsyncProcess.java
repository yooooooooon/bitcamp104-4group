package kr.or.spring;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Async;

public class AsyncProcess {
	
	@Async
	public void sampleAsync(HttpServletResponse response, HttpSession session) throws IOException{
		
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("로그아웃");
		response.getWriter().println("<script>alert('15초 후!!!!!!.');</script>");
		session.invalidate();
		
	}
}







//이건 login.htm 실행했을때 한번만 실행 (실행횟수만큼)

/*System.out.println("실행되었고 넌 아웃");
 * 
 * System.out.println("15초지남?");*/

/*response.setContentType("text/html; charset=UTF-8");

PrintWriter out = response.getWriter();
out.println("<script>alert('15초가 지나 자동로그아웃 되었습니다.');</script>");
out.flush();

return new AsyncResult(out);*/