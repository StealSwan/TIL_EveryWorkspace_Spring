package spring.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //id가 logic이 된다
public class LogicController {

	@Autowired	//dao값을 자동주입 시켜줄때
	//@Resource(name="myDao") //정확한 빈의 아이디로 주입 - 모호성이 있을때
	DaoInter daoInter;
	
	public LogicController(MyDao dao) {
		
		this.daoInter=dao;
	}
	
	
	//insert
	public void insert(String str) {
		
		daoInter.insertData(str);
	}
	
	
	//delete
	public void delete(String num) {
		
		daoInter.deleteData(num);
	}
	
}
