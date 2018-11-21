package dpozinen.dao;

import dpozinen.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;


@Transactional
@Service("IStudentDao")
public class HibernateActions implements IStudentDao
{
	private SessionFactory factory;

	public HibernateActions() {
		try {
			factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void addStudent(String lastName, String firstName, String faculty, String spec, String cardID) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			Student student = new Student(firstName, lastName, faculty, spec, cardID);
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addStudent(Student student) {
		addStudent(student.getLastName(), student.getFirstName(), student.getFaculty(),
					student.getSpeciality(), student.getCardID());
	}


	@Override
	public Student getStudent(int id)
	{
		Student student = null;
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public Student getStudent(String cardID) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Student student = null;

		try {
			transaction = session.beginTransaction();
			student = session.get(Student.class, cardID);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Student delStudent = session.get(Student.class, id);
			session.delete(delStudent);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteStudent(String cardID) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, cardID);
			session.delete(student);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	// TODO: fix weird transcation required Exception
	// @Transactional
	@Override
	public void deleteAllStudents() {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Student");
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public boolean studentExists(Student student) {
		Session session = factory.openSession();

		try {
			if (session.get(Student.class, student.getId()) != null)
				return true;
			return false;
		} finally {
			session.close();
		}
	}

	public void fillDefaultValues() throws HibernateException {
		addStudent("First", "Second", "RY", "WHJE", "798400");
		addStudent("Second", "Third", "RY", "WHJE", "079780");
		addStudent("Third", "Fourth", "RY", "WHJE", "008400");
	}

	public void stop() throws Exception {
		factory.close();
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}