package spring.anno4;

import java.util.Iterator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Anno4Main {

	public static void writeStudent(Student s) {
		System.out.println("Student 데이타 출력");
		System.out.println(s.getName() + ":" + s.getAge());
		
		for(String h:s.getHobby())
			System.out.println(h);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student s1 = (Student)context.getBean("student1");
		writeStudent(s1);
		
		Student s2 = (Student)context.getBean("student2");
		writeStudent(s2);
	}
}
