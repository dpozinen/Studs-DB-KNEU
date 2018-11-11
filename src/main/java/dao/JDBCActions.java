package dao;

import java.sql.*;

@Deprecated
public class JDBCActions {

	private Connection	c;
	private String		tableName;
	private PreparedStatement stmnt = null;

	JDBCActions(Connection c, String tableName) {
		this.c = c;
		this.tableName = tableName;
	}

	boolean tableExists() {
		boolean exists = false;

		try {
			DatabaseMetaData dbmeta = c.getMetaData();
			ResultSet rs = dbmeta.getTables(null, null, tableName, new String[] { "TABLE" });

			if (rs.next())
				exists = true;
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}

	void createTable() {
		try {
			if (!tableExists())
			{
				stmnt = c
					.prepareStatement("CREATE TABLE " + tableName
										+ "(ID serial,"
										+ "LastName varchar(255),"
										+ "FirstName varchar(255),"
										+ "Faculty varchar(255),"
										+ "Spec varchar(255));");
				stmnt.execute();
				System.out.println("Created table successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStmnt();
		}
	}

	void fillTable() {
		try {
			c.setAutoCommit(false);

			String SQL = "INSERT INTO " + tableName +
								"(LastName, FirstName, Faculty, Spec)"+
								" VALUES (?, ?, ?, ?)";
			stmnt = c.prepareStatement(SQL);
			addRow("Позиненко", "Дарий", "Ф�?С�?Т", "Комп Науки", false);
			addRow("Блоха", "Виктория", "Ф�?С�?Т", "Комп Науки", false);
			addRow("Левченков", "Олександр", "Ф�?С�?Т", "Комп Науки", false);
			stmnt.executeBatch();
			c.commit();
			c.setAutoCommit(true);
			System.out.println("Filled table successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmnt();
		}
	}

	void dropTable()
	{
		try {
			stmnt = c.prepareStatement("DROP TABLE " + tableName);
			stmnt.execute();
			System.out.println("Dropped table successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmnt();
		}
	}

	void addRow(String LastName, String FirstName, String Faculty, String Spec, boolean execute)
	{
		try {
			if (execute)
			{
				String SQL = "INSERT INTO " + tableName +
									"(LastName, FirstName, Faculty, Spec)"+
									" VALUES (?, ?, ?, ?)";
				stmnt = c.prepareStatement(SQL);
			}
			stmnt.setString(1, LastName);
			stmnt.setString(2, FirstName);
			stmnt.setString(3, Faculty);
			stmnt.setString(4, Spec);
			if (execute)
				stmnt.executeUpdate();
			else
				stmnt.addBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (execute)
				closeStmnt();
		}
	}

	void removeRow(int id)
	{
		try {
			String SQL = "DELETE FROM " + tableName +
								" WHERE ID = ?;";
			stmnt = c.prepareStatement(SQL);
			stmnt.setInt(1, id);
			stmnt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStmnt();
		}
	}

	private void closeStmnt() {
		try {
			if (stmnt != null)
				stmnt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}