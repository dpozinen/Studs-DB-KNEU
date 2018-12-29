package dpozinen.service;

import dpozinen.model.Student;
import dpozinen.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void addStudent(String lastName, String firstName, String faculty, float avgGrade, String cardID) {
		Student student = new Student(lastName, firstName, faculty, cardID, avgGrade);		
		studentRepo.save(student);
	}

	@Override
	public void addStudent(Student student) {
		studentRepo.save(student);		
	}

	@Override
	public Student getStudent(Long id) {
		return studentRepo.findOne(id);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepo.delete(getStudent(id));
	}

	@Override
	public void deleteAllStudents() {
		studentRepo.deleteAll();
	}

	@Override
	public boolean studentExists(Student student) {
		return studentRepo.exists(student.getId());
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>)studentRepo.findAll();
	}

	@Override
	public void fillDefaultValues() {
		addStudent("First", "Second", "RY", 11.1f, "798400");
		addStudent("Second", "Third", "RY", 11.2f, "079780");
		addStudent("Third", "Fourth", "RY", 11.4f, "008400");
	}
}