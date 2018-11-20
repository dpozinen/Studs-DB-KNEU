package dpozinen.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import dpozinen.entity.Student;
import dpozinen.dao.HibernateActions;

@RestController
public class StudentController {

	HibernateActions actions;

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		Student student = actions.getStudent(id);

		if (student == null)
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
		Student student = actions.getStudent(id);

		if (student == null)
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		actions.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/student/", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudents() {
		actions.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/student/", method = RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student, UriComponentsBuilder ucb) {
		if (actions.studentExists(student))
			return new ResponseEntity<Student>(HttpStatus.CONFLICT);
		actions.addStudent(student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/student/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
}