package dao;

import entity.Student;

public interface IStudentDao {
	public void addStudent(String LastName, String FirstName, String Faculty, String Spec);
	public void deleteStudent(int id);
	public Student getStudentById(int id);
}