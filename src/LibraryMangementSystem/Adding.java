package LibraryMangementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Adding {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/librarysystem";
		Connection conn = null;

		String BookCode = "123456";
		String BookName = "J2ee";
		String Author = "James Keogh";
		String Publication = "McGraw-Hill/Osborne, 2002";
		String Subject = "Advanced java";
		String NoOfCopies = "5";

		String sql = "insert into keep_track_of_new_bookss(BookCode, BookName, Author, Publication, Subject, NoOfCopies)"
				+ " values ('" + BookCode + "','" + BookName + "','" + Author + "','" + Publication + "','" + Subject
				+ "','" + NoOfCopies + "'" + ")";

		try {
			conn = DriverManager.getConnection(url, "root", "Tiger");

			Statement st = conn.createStatement();
			int m = st.executeUpdate(sql);
			if (m == 1)
				System.out.println("Inserted Succesfull" + sql);
			else
				System.out.println("Inserted failed");
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			conn.close();
		}

	}
}
