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

	@Column(name = "cardID")
	private	String cardID;

	@Column(name = "avgGrade")
	private float avgGrade;

	public Student() {
	}

	public Student(String firstName, String lastName, String faculty, String cardID, float avgGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.faculty = faculty;
		this.cardID = cardID;
		this.avgGrade = avgGrade;
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

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getCardID() {
		return this.cardID;
	}

	public void setavgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}

	public float getavgGrade() {
		return this.avgGrade;
	}

	public String toString() {
		return "Id: " + id + " Name: " + firstName + " Surname: " + lastName + "CardID: " + cardID;
	}
}