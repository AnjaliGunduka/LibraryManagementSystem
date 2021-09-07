package LibraryMangementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainClassLibraryManagement {
	public static void main(String[] args) {
		System.out.println("enter 1 to add bookdetails");
		System.out.println("enter 2 to search bookbytitle");
		System.out.println("enter 3 to update bookdetails");
		System.out.println("enter 4 to remove book");

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your choice");
		int choice = scanner.nextInt();
		if (choice > 4 || choice < 1) {
			System.out.println("choice must be from 1 to 4");
		} else {
			switch (choice) {
			case 1: {
				LibraryManagementSystem.addBook();
				break;
			}
			case 2: {
				LibraryManagementSystem.addBook();
				break;
			}
			case 3: {
				LibraryManagementSystem.addBook();
				break;
			}
			case 4: {
				LibraryManagementSystem.addBook();
				break;
			}
			}
		}
	}
}

class LibraryManagementSystem {
	public static void addBook() {
		String url = "jdbc:mysql://localhost:3306?user=root&password=Tiger";
		String query = "insert into demo.bookdata1  values(?,?,?,?,?)";
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step1");

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			System.out.println("step2");

			Scanner scanner = new Scanner(System.in);
			System.out.println("enter booktitle");
			String title = scanner.next();

			System.out.println("enter bookauthor");
			String author = scanner.next();

			System.out.println("enter bookedition");
			int edition = scanner.nextInt();

			System.out.println("enter bookprice");
			double price = scanner.nextDouble();

			System.out.println("enter booktype");
			String type = scanner.next();

			preparedStatement.setString(1, title);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, edition);
			preparedStatement.setDouble(4, price);
			preparedStatement.setString(5, type);

			preparedStatement.executeUpdate();

			System.out.println("step3");

			connection.close();
			System.out.println("step5");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void searchBook() {
		String url = "jdbc:mysql://localhost:3306?user=root&password=Tiger";
		String query = "select * from demo.bookdata1  where booktitle=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step1");

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			System.out.println("step2");

			Scanner scanner = new Scanner(System.in);
			System.out.println("enter booktitle");
			String title = scanner.next();
			preparedStatement.setString(1, title);
			ResultSet resultset = preparedStatement.executeQuery();
			resultset.next();

			String title1 = resultset.getString("booktitle");
			String author = resultset.getString("bookauthor");
			String edition = resultset.getString("bookedition");
			String price = resultset.getString("bookprice");
			String type = resultset.getString("booktype");

			System.out.println(title1);
			System.out.println(author);
			System.out.println(edition);
			System.out.println(price);
			System.out.println(type);
			System.out.println("step3");

			connection.close();
			System.out.println("step5");

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateBook() {
		String url = "jdbc:mysql://localhost:3306?user=root&password=Tiger";
		String query = "update demo.bookdata1 set bookedition=? where booktitle=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step1");

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			System.out.println("step2");

			Scanner scanner = new Scanner(System.in);
			System.out.println("enter bookedition");
			String edition = scanner.next();

			System.out.println("enter booktitle");
			String title = scanner.next();

			preparedStatement.setString(1, edition);
			preparedStatement.setString(2, title);
			preparedStatement.executeUpdate();

			System.out.println("step3");

			connection.close();
			System.out.println("step5");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void removeBook() {
		String url = "jdbc:mysql://localhost:3306?user=root&password=Tiger";
		String query = "delete from demo.bookdata1  where booktitle=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step1");

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			System.out.println("step2");

			Scanner scanner = new Scanner(System.in);
			System.out.println("enter booktitle");
			String title1 = scanner.next();

			preparedStatement.setString(1, title1);
			preparedStatement.executeUpdate();

			System.out.println("step3");

			connection.close();
			System.out.println("step5");
			System.out.println("removed succesfully");

		}

		catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
