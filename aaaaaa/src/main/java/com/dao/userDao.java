package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Employee;

public class userDao {

	
	public static Connection getConnection() throws ClassNotFoundException {
		String derbyUrl = "org.apache.derby.jdbc.EmbeddedDriver";

		String dbUrl = "jdbc:derby:C:\\Users\\sbi\\MyDB;create=true";
		
		Connection con = null;
		
		try {
			Class.forName(derbyUrl);
			System.out.println("Connected to Derby");

			con = DriverManager.getConnection(dbUrl, "", "");
			System.out.println("Connected to Derby Database");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("connection zallllll nahi!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static boolean createUser(Employee object) {
		System.out.println("Now you are in the dao create user function file");
		Connection con = null;
		
		try {
			con = getConnection();
			String addUnderiterQuery = "insert into Employee(name,email,moNumber) values(?,?,?)";
			
			if (con != null) {
				try {
					PreparedStatement stmt = con.prepareStatement(addUnderiterQuery);

					//stmt.setInt(1, object.getId());
					stmt.setString(1, object.getName());
					stmt.setString(2, object.getEmailId());
					stmt.setString(3, object.getMoNumber());
					
					int rs = stmt.executeUpdate();
					if (rs > 0) {
						return true;
					} else {
						return false;
					}
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static ArrayList<Employee> getUserList() {
		System.out.println("Now you are in the dao user list function");
		
		ArrayList<Employee> arr = new ArrayList<Employee>();
		Connection con = null;
		
		try {
			con = getConnection();
			String allUserList = "Select * from Employee";
			
			if (con != null) {
				try {
					PreparedStatement stmt = con.prepareStatement(allUserList);
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){
						Employee obj = new Employee();
						
						int Eid = rs.getInt(1);
						String name = rs.getString(2);
						String emailId = rs.getString(3);
						String mobileNo = rs.getString(4);
						System.out.println(Eid + " " + name + " "+ emailId + " " + mobileNo);
						obj.setId(Eid); 
						obj.setName(name);					
						obj.setEmailId(emailId);
						obj.setMoNumber(mobileNo);
						
						arr.add(obj);
					}
					
					
					if(arr.size() != 0){
						return arr;
					}else{
						return null;
					}
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	public static boolean deleteUser(int id) {
		System.out.println("Now you are in the dao delete user function");
		Connection con = null;
		
		try {
			con = getConnection();
			String addUnderiterQuery = "Delete from Employee where id = ?";
			
			if (con != null) {
				try {
					PreparedStatement stmt = con.prepareStatement(addUnderiterQuery);

					stmt.setInt(1, id);
					
					int rs = stmt.executeUpdate();
					
					if (rs > 0) {
						return true;
					} else {
						return false;
					}
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public static boolean updateUser(Employee object) {
		System.out.println("You are in the update user dao function");
		Connection con = null;
		
		try {
			con = getConnection();
			
			String addUnderiterQuery = "UPDATE Employee SET name = ?, email= ?, moNumber=? WHERE id = ?";
			
			if (con != null) {
				try {
					PreparedStatement stmt = con.prepareStatement(addUnderiterQuery);

					stmt.setString(1, object.getName());
					stmt.setString(2, object.getEmailId());
					stmt.setString(3, object.getMoNumber());
					stmt.setInt(4, object.getId());
					
					int rs = stmt.executeUpdate();
					
					if (rs > 0) {
						return true;
					} else {
						return false;
					}
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
