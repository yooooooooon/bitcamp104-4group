package kr.or.spring;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import dao.NoticeDao;

public class LogProcessor {
	int count=0;
	
	@Autowired
	private SqlSession sqlsession;
	
	@Scheduled(fixedRate=15000)
	public void start() throws ClassNotFoundException, SQLException {
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		int result = noticedao.selectNotice();
		
		if(result>0) {
			System.out.println("총 검색된 게시물 수는 " + result + "입니다.");
		}else {
			System.out.println("검색된 게시물이 없습니다.");
		}
	}
	
	@Scheduled(cron= "*/20 * * * * *" )
	public void time() {
        Calendar nowTime = Calendar.getInstance();
        SimpleDateFormat sd = new SimpleDateFormat("[ yyyy-MM-dd hh:mm:ss ]");
        String strNowTime = sd.format(nowTime.getTime());
        
		System.out.println("현재시각은 " + strNowTime + " 입니다.");
	}
	
	@Scheduled(fixedDelay=10000)
	public void time1() {
		System.out.println("페이지 방문한 시간 : " + (++count)*10 + "초 지났습니다.");
	}
	
}



/*
System.out.println("하이 :)");

System.out.println("ssefsdfsdfsd      ="+sqlsession);
System.out.println("읭의의으리ㅡ능ㄹ=" + async);*/