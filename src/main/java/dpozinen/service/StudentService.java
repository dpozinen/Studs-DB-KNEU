package dpozinen.service;

import dpozinen.model.Student;
import java.util.List;

public interface StudentService {
	void 	addStudent(String LastName, String FirstName, String Faculty, float avgGrade, String cardID);
	void 	addStudent(Student student);
	void 	deleteStudent(Long id);
	Student getStudent(Long id);
	void 	deleteAllStudents();
	boolean	studentExists(Student student);
	List<Student> getAllStudents();
	void fillDefaultValues();
}