package dpozinen.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "faculty")
	private String faculty;

	@Column(name = "spec")
	private String speciality;

	@Column(name = "cardID")
	private	String cardID;

	public Student() {
	}

	public Student(String firstName, String lastName, String faculty, String speciality, String cardID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.faculty = faculty;
		this.speciality = speciality;
		this.cardID = cardID;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getCardID() {
		return this.cardID;
	}

	public String toString() {
		return "Id: " + id + " Name: " + firstName + " Surname: " + lastName + "CardID: " + cardID;
	}
}