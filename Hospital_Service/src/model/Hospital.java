package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hospital {
	
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf", "root", "");

			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public String insertHospital(String hosName, String hosAddress, String hosPhoneNo, String hosEmail, String hosNoOfRooms) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = "insert into hospitals (`hosID`,`hosName`,`hosAddress`,`hosPhoneNo`,`hosEmail`,`hosNoOfRooms`)"+ "values(?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, hosName);
			preparedStmt.setString(3, hosAddress);
			preparedStmt.setString(4, hosPhoneNo);
			preparedStmt.setString(5, hosEmail);
			preparedStmt.setString(6, hosNoOfRooms);
			// execute the statement
			preparedStmt.execute();
			con.close();

			String newHospitals = readHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newHospitals + "\"}";

		} catch (Exception e) {
			output ="{\"status\":\"error\", \"data\": \"Error while inserting the hospital.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}
		
	
	public String readHospitals() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1' width= '100%'><tr><th>Hospital Name</th> <th>Hospital Address</th> <th>Hospital Phone No</th> <th>Hospital Email</th> <th>No Of Rooms</th> <th>Update</th> <th>Remove</th></tr>";

			String query = "select * from hospitals";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String hosID = Integer.toString(rs.getInt("hosID"));
				String hosName = rs.getString("hosName");
				String hosAddress = rs.getString("hosAddress");
				String hosPhoneNo = rs.getString("hosPhoneNo");
				String hosEmail = rs.getString("hosEmail");
				String hosNoOfRooms = rs.getString("hosNoOfRooms");
				// Add into the html table
				output += "<tr><td><input id='hidhosIDUpdate' name='hidhosIDUpdate' type='hidden' value='"
						+ hosID + "'>" + hosName + "</td>";
				output += "<td>" + hosAddress + "</td>";
				output += "<td>" + hosPhoneNo + "</td>";
				output += "<td>" + hosEmail + "</td>";
				output += "<td>" + hosNoOfRooms + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td> <td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-hospitalid='" + hosID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		}

		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updateHospital(String hosID, String hosName, String hosAddress, String hosPhoneNo, String hosEmail, String hosNoOfRooms) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement

			String query = "UPDATE hospitals SET hosName=?,hosAddress=?,hosPhoneNo=?,hosEmail=?,hosNoOfRooms=? WHERE hosID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, hosName);
			preparedStmt.setString(2, hosAddress);
			preparedStmt.setString(3, hosPhoneNo);
			preparedStmt.setString(4, hosEmail);
			preparedStmt.setString(5, hosNoOfRooms);
			preparedStmt.setInt(6, Integer.parseInt(hosID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newHospitals = readHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newHospitals + "\"}";
			
			
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String deleteHospital(String hosID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from hospitals where hosID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(hosID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newHospitals = readHospitals();
			output = "{\"status\":\"success\", \"data\" \"" + newHospitals + "\"}";
				
		} 
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			System.err.println(e.getMessage());
		}

		return output;

	}

}
