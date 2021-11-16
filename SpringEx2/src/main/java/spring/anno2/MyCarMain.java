package spring.anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyCarMain {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("annoContext.xml");
		
		//Tire tire = (KoreaTire)app.getBean("ktire");
		//tire.writeTireName();
		
		MyCar mycar = (MyCar)app.getBean("myCar");
		mycar.writeTire();
	}
}
