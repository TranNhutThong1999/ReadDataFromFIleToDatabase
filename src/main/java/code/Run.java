package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Run {

	public Connection getConnection(String nameDatabase, String name, String password) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/" + nameDatabase;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("ok");
			return DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated catch block
		return null;
	}

	public void readConfig(String status) throws ClassNotFoundException, IOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet r = null;
		try {
//Truy van database warehouse_control			
			connection = getConnection("warehouse_control", "root", "0985153812");
			String sql = "select config.* from config inner join logs_db where config.ID = logs_db.ID_config and logs_db.Status=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			r = statement.executeQuery();
			Config config = null;
			resetDB("warehouse_extra_db", "root", "0985153812");
			while (r.next()) {
				boolean check;
				try {
					config = new Config(r.getInt("id"), r.getString("Source"), r.getString("Destination"),
							r.getString("U_source"), r.getString("U_des"), r.getString("PW_source"),
							r.getString("PW_des"), r.getString("Delimeter"), r.getString("Data_name"),
							r.getString("Data_gender"), r.getString("Data_Age"), r.getString("Data_Address"));
					// doc file và them vao database
					
					//addDataToExtraDB("warehouse_extra_db", "root", "0985153812");
					check = readFileToControlDB(config);
					// thay doi trang thai data tren logs_db
				} catch (Exception e) {
					System.out.println("failure");
					return;
				}
				if(check) {
					statement = connection.prepareStatement("update logs_db set Status = ? where ID_config = ?");
					statement.setString(1, "DB");
					statement.setInt(2, config.getId());
					statement.executeUpdate();
					System.out.println("set status");
					}
			}
		} catch (SQLException e1) {
			if (connection != null) {
				System.out.println("khong thanh cong");
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

//	public void addDataToExtraDB(String nameDatabase, String name, String password, Data data)
//			throws ClassNotFoundException {
//		Connection connection = null;
//		PreparedStatement statement = null;
//		try {
//			connection = getConnection(nameDatabase, name, password);
//			connection.setAutoCommit(false);
//			String sql = "insert into data(A,B,C,D) values(?,?,?,?)";
//			statement = connection.prepareStatement(sql);
//			statement.setString(1, data.getName());
//			statement.setString(2, data.getGender());
//			statement.setString(3, data.getAge()+"");
//			statement.setString(4, data.getAddress());
//			statement.executeUpdate();
//			connection.commit();
//		} catch (SQLException e1) {
//			if (connection != null) {
//				try {
//					connection.rollback();
//					System.out.println("khong thanh cong");
//				} catch (SQLException e11) {
//					e11.printStackTrace();
//				}
//			}
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//
//	}
	public void resetDB(String nameDatabase, String name, String password) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection(nameDatabase, name, password);
			connection.setAutoCommit(false);
			String sql = "delete from data";
			statement = connection.prepareStatement(sql);
			
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e1) {
			if (connection != null) {
				try {
					connection.rollback();
					System.out.println("khong thanh cong");
				} catch (SQLException e11) {
					e11.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	public void addDataToExtraDB(String nameDatabase, String name, String password, Data data)
			throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection(nameDatabase, name, password);
			connection.setAutoCommit(false);
			String sql = "insert into data(name,gender,Age,Address) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, data.getName());
			statement.setString(2, data.getGender());
			statement.setInt(3, data.getAge());
			statement.setString(4, data.getAddress());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e1) {
			if (connection != null) {
				try {
					connection.rollback();
					System.out.println("khong thanh cong");
				} catch (SQLException e11) {
					e11.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	public boolean readFileToControlDB(Config config) throws ClassNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(config.getSource())));
//xac dinh vi tri index 		
		String tile = br.readLine();
		String[] list_tile = tile.split(config.getDelimeter());
		int index_1 = 0;
		int index_2 = 0;
		int index_3 = 0;
		int index_4 = 0;

		for (int i = 0; i < list_tile.length; i++) {
			if (config.getData_name().equals(list_tile[i])) {
				index_1 = i;
			} else if (config.getData_gender().equalsIgnoreCase(list_tile[i])) {
				index_2 = i;
			} else if (config.getData_Age().equals(list_tile[i])) {
				index_3 = i;
			} else if (config.getData_Address().equals(list_tile[i])) {
				index_4 = i;
			}
		}
//duyet tung dong lay gia trị theo index
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				System.out.println("ss " + line);
				String[] list = line.split(config.getDelimeter());
				Data data = new Data(list[index_1], list[index_2], Integer.valueOf(list[index_3]), list[index_4]);
				System.out.println(data.toString());
				addDataToExtraDB(config.getDestination(), config.getU_des(), config.getpW_des(), data);
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

//	public void readFileExcelToControlDB(Config config)
//			throws EncryptedDocumentException, IOException, ClassNotFoundException {
//		InputStream inputStream = new FileInputStream(new File(config.getSource()));
//		Workbook workbook = new XSSFWorkbook(inputStream);
//		Sheet sheet = workbook.getSheetAt(0);
//		System.out.println();
//		Iterator<Row> rowIterator = sheet.iterator();
//		Row row_1 = rowIterator.next();
//		Iterator<Cell> cellIterator_1 = row_1.cellIterator();
////Xac dinh vi tri index
//		title: while (cellIterator_1.hasNext()) {
//			Cell cell = cellIterator_1.next();
//			if (cell.getStringCellValue().equals(config.getData_name())) {
//				index_1 = cell.getColumnIndex();
//			} else if (cell.getStringCellValue().equals(config.getData_gender())) {
//				index_2 = cell.getColumnIndex();
//			} else if (cell.getStringCellValue().equals(config.getData_Age())) {
//				index_3 = cell.getColumnIndex();
//			} else if (cell.getStringCellValue().equals(config.getData_Address())) {
//				index_4 = cell.getColumnIndex();
//			}
//		}
////duyet tung dong và lay gia tri column theo index
//		Row: while (rowIterator.hasNext()) {
//			Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
//			String name = "";
//			int age = 0;
//			String gender = "";
//			String address = "";
//			column: while (cellIterator.hasNext()) {
//				Cell cell = cellIterator.next();
//				if (cell.getColumnIndex() == index_1) {
//					name = cell.getStringCellValue();
//				} else if (cell.getColumnIndex() == index_2) {
//					gender = cell.getStringCellValue();
//				} else if (cell.getColumnIndex() == index_3) {
//					age = (int) cell.getNumericCellValue();
//				} else if (cell.getColumnIndex() == index_4) {
//					address = cell.getStringCellValue();
//				}
//			}
//			Data data = new Data(name, gender, age, address);
//			System.out.println(data.toString());
//			addDataToExtraDB(config.getDestination(), config.getU_des(), config.getpW_des(), data);
//		}
//	}
//	public void createTable(String nameDatabase, String name, String password) throws ClassNotFoundException {
//
//		Connection connection = null;
//		PreparedStatement statement = null;
//		try {
//			connection = getConnection(nameDatabase, name, password);
//			statement = connection.prepareStatement("drop table  if exists data");
//			statement.executeUpdate();
//
//			String query = "create table data (" + "ID int primary key auto_increment," + "A nvarchar(100),"
//					+ "B nvarchar(100)," + "C nvarchar(100)," + "D nvarchar(100))";
//			statement = connection.prepareStatement(query);
//			// connection.setAutoCommit(false);
//			statement.executeUpdate();
//		} catch (SQLException e1) {
//			if (connection != null) {
//				System.out.println("khong thanh cong");
//			}
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Run r = new Run();
		r.readConfig("RD");
		// r.createTable("warehouse_extra_db", "root", "0985153812");
	}
}
