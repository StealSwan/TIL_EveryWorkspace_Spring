package spring.anno4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@ImportResource("classpath:annoContext.xml")
@Component
public class ApplicationConfig {

	@Bean //등록된 id는 메서드명
	public Student student1() {

		Student stu = new Student();
		stu.setName("강호동");
		stu.setAge(30);
	
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("게임");
		hobby.add("네플릭스");
		hobby.add("여행");
		
		stu.setHobby(hobby);
		
		return stu;
	}
	
	@Bean
	public Student student2() {

		Student stu = new Student();
		stu.setName("이영자");
		stu.setAge(20);
	
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("자바공부");
		hobby.add("스프링공부");
		hobby.add("DB공부");
		
		stu.setHobby(hobby);
		
		return stu;
	}
}
