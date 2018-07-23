package com.nathangiusti.gmbackend;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class GmBackendController implements CommandLineRunner {

	private static final Integer COLUMN_COUNT = 19;

	private Connection conn;

	@Override
	public void run(String... args) throws Exception {

		ClassLoader classLoader = getClass().getClassLoader();
		
		InputStream stream = classLoader.getResourceAsStream("Source.csv");
		
		Reader reader = new InputStreamReader(stream);
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		initDatabase(csvParser);

		csvParser.close();

	}

	private void initDatabase(CSVParser csvParser) {
		conn = connectToDatabase();

		for (CSVRecord csvRecord : csvParser) {

			String sql = "INSERT INTO TimeRecords VALUES (";
			Iterator<String> iter = csvRecord.iterator();

			DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern("M/d/yy");
			LocalDate localDate = LocalDate.parse(iter.next(), oldFormatter);

			DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			sql += "'" + localDate.format(newFormatter) + "',";

			while (iter.hasNext()) {
				String str = iter.next().trim();
				if (str.equals("TRUE") || str.equals("FALSE"))
					sql += str + ",";
				else
					sql += "'" + str + "', ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += ");";

			runInsert(sql);
		}

	}

	private Connection connectToDatabase() {

		Connection conn = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	@RequestMapping(value = "/{field}/{value}")
	public String getVal(@PathVariable String field, @PathVariable String value) throws SQLException {
		String sql = "SELECT * FROM TimeRecords WHERE " + field + " = '" + value + "';";
		return runSql(sql);
	}
	
	@RequestMapping(value = "/all")
	public String getVal() {

		String sql = "SELECT * FROM TimeRecords";
		return runSql(sql);
		
	}

	private String runSql(String sql) {
		ResultSet rs = null;
		String ret = getHeaders();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				for (int i = 1; i <= COLUMN_COUNT; i++) {
					ret += rs.getString(i) + ",";
				}
				ret = ret.substring(0, ret.length() - 2) + "\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ret;
	}

	private String getHeaders() {
		return "Date, Client, Project, Project Code, Task, "
				+ "Hours, Hours Rounded, Billable, Invoiced, "
				+ "Approved, First Name, Last Name, Department, "
				+ "Employee, Billable Rate, Cost Rate, Cost Ammount, "
				+ "Currency, Url" + "\n";

	}

	private int runInsert(String sql) {
		int ret = -1;
		try {
			Statement stmt = conn.createStatement();
			ret = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}
