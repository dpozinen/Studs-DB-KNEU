package dpozinen.app;

import dpozinen.dao.HibernateActions;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring.xml");

			HibernateActions actions = context.getBean(HibernateActions.class);
			System.out.println(actions.getStudentById(5).toString());
			context.close();
			System.out.println("actions.getStudentById(5).toString()");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}