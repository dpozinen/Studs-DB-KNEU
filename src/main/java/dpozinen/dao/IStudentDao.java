package dpozinen.dao;

import dpozinen.entity.Student;
import java.util.List;

public interface IStudentDao {
	void 	addStudent(String LastName, String FirstName, String Faculty, float avgGrade, String cardID);
	void 	addStudent(Student student);
	void 	deleteStudent(int id);
	void 	deleteStudent(String cardID);
	Student getStudent(int id);
	Student getStudent(String cardID);
	void 	deleteAllStudents();
	boolean	studentExists(Student student);
	List<Student> getAllStudents();
}