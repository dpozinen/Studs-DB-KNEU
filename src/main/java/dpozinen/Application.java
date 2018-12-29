package dpozinen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dpozinen.model.Student;
import dpozinen.service.StudentService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		studentService.fillDefaultValues();
		System.out.println("----------------------------------------------------------");
		
		studentService.deleteAllStudents();
		System.out.println("----------------------------------------------------------");
		List<Student> students = studentService.getAllStudents();
		for(Student student : students)
			System.out.println("Students => " + student);
		System.out.println("----------------------------------------------------------");
		studentService.fillDefaultValues();
		students = studentService.getAllStudents();
		for(Student student : students)
			System.out.println("Students => " + student);
		System.out.println("----------------------------------------------------------");		
		studentService.deleteAllStudents();
		students = studentService.getAllStudents();
		for(Student student : students)
			System.out.println("Students => " + student);
		System.out.println("----------------------------------------------------------");

		studentService.addStudent("null", "null", "null", 0, "null");
	}
}