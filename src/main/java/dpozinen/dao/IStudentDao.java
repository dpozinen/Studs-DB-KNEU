package dpozinen.dao;

import dpozinen.entity.Student;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface IStudentDao {
	void 	addStudent(String LastName, String FirstName, String Faculty, String Spec, String cardID);
	void 	addStudent(Student student);
	void 	deleteStudent(int id);
	void 	deleteStudent(String cardID);
	Student getStudent(int id);
	Student getStudent(String cardID);
	@Transactional
	public void 	deleteAllStudents();
	boolean	studentExists(Student student);
	// List<Student> listAllStudents();
}