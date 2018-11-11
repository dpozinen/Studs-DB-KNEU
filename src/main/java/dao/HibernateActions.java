package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

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
	public void addStudent(String LastName, String FirstName, String Faculty, String Spec) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			Student student = new Student(FirstName, LastName, Faculty, Spec);
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
	public Student getStudentById(int id)
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

	public void fillDefaultValues() throws HibernateException {
		addStudent("First", "Second", "RY", "WHJE");
		addStudent("Second", "Third", "RY", "WHJE");
		addStudent("Third", "Fourth", "RY", "WHJE");
	}

	public void stop() throws Exception {
		factory.close();
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}