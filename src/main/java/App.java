import dao.HibernateActions;

public class App {
	public static void main(String args[])
	{
		HibernateActions ha = null;

		try {
			ha = new HibernateActions();
			ha.fillDefaultValues();
			System.out.println(ha.getStudentById(5).toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ha != null)
					ha.stop();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}