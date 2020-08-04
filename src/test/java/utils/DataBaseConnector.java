package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class DataBaseConnector {



	private static String dbusername = Config.getProperty("dbUser_name");
	private static String dbpassword = Config.getProperty("dbPwd");
	private static String url = Config.getProperty("dbUrl");

	private static File file = new File("C://Users//KO398762//Desktop//sqlnew.sql");



	//Should be defined as jdbc:mysql://host:port/database name
	private static String databaseURLQA= "jdbc:mysql://qahost:22020/easy";
	private static String databaseURLSTAGE= "jdbc:mysql://stagehost:2020/easyDB";
	private static String databaseURLPRODUCTION= "jdbc:mysql://prodhost:2020/easyDB";


	public static String executeSQLQuery(File  sqlQuery) throws FileNotFoundException {
		String connectionUrl="";
		Connection connection;
		String resultValue = "";
		ResultSet rs;
		// File file = new File("C://Users//KO398762//Desktop//sqlnew.sql");


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
			if(connection!=null) {
				System.out.println("Connected to the database...");
			}else {
				System.out.println("Database connection failed");
			}
			Statement stmt = connection.createStatement();
			rs=stmt.executeQuery(DataBaseConnector.sqlquery(file));

			try {
				while(rs.next()){
					resultValue = rs.getString(1).toString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (NullPointerException err) {
				System.out.println("No Records obtained for this specific query");
				err.printStackTrace();
			}
			connection.close();

		}catch(SQLException sqlEx) {
			System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
		}
		return resultValue;
	}


	public static Object executeSQLQuery_List() throws FileNotFoundException {
		String connectionUrl="";
		Connection connection;
		ArrayList<String> resultValue = new ArrayList<String>();
		//  ArrayList<ArrayList<String>> resultValue = new ArrayList<ArrayList<String>>();
		//   ArrayList<String> colData = new ArrayList<String>();
		ResultSet resultSet;
		// String sqlQuery = "select * from RMAS where rma_number = '1234' and rma_ret_id = '42595'";



		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url,dbusername,dbpassword);
			if(connection!=null) {
				System.out.println("Connected to the database");
			}else {
				System.out.println("Failed to connect to ");
			}
			Statement statement = connection.createStatement();
			resultSet=statement.executeQuery(DataBaseConnector.sqlquery(file));

			try {

				while(resultSet.next()){				
					int columnCount = resultSet.getMetaData().getColumnCount();					
					StringBuffer s1=new StringBuffer();					
					//	System.out.println(s.append(resultSet.getString("Created_Time").trim()+"").append(resultSet.getString("RMA_Number").trim()+"").append(resultSet.getString("Retailer_ID").trim()+"").append(resultSet.getString("Retailer_Name").trim()+"").append(resultSet.getString("RMA_status").trim()+"").append(resultSet.getString("Return_Address_ID").trim()+"").append(resultSet.getString("Address_Name").trim()+"").append(resultSet.getString("Ship_to_address_line_1").trim()+"").append(resultSet.getString("City").trim()+"").append(resultSet.getString("State0").trim()+"").append(resultSet.getString("From_Name").trim()+"").append(resultSet.getString("From_City").trim()+"").append(resultSet.getString("From_State").trim()+"").append(resultSet.getString("ship_to_postal_code").trim()+"").append(resultSet.getString("From_Email").trim()+"").append(resultSet.getString("Tracking_Number").trim()+"").append(resultSet.getString("Item_Sku").trim()+"").append(resultSet.getString("Item_Description").trim()+"").append(resultSet.getString("Ship_Id__order___").trim()+""));
					String[] coloumns = new String[]{"Created_Time","RMA_Number","Retailer_ID","Retailer_Name","RMA_status","Receipt_date","Return_Address_ID","Address_Name","Ship_to_address_line_1","City","State0","From_Name","From_City","From_State","ship_to_postal_code","From_Email","Tracking_Number","Item_Sku","Item_Description","Ship_Id__order___","Vendor_RA_Number","Final_Sale_Flag","RMA_Credit_Type","Ship_Node","Return_Reason","Label_create_date","Expected_Qty","Actual_Qty","Department__","Reference__","PO__","Invoice__","Notes"};
					int y=0;
					while(y<coloumns.length){
						if(resultSet.getString(coloumns[y])!=null){
							if(coloumns[y]=="Created_Time" || coloumns[y]=="Label_create_date"){
								String actual = resultSet.getString(coloumns[y]).trim().substring(0, 10);								
								String month = actual.substring(5, 7);								
								String date = actual.substring(8, 10);							
								String year = actual.substring(0, 4);
								String resultdate = month+"/"+date+"/"+year;

								s1.append(resultdate+" ");

							}else{								
								s1.append(resultSet.getString(coloumns[y]).trim()+" ");

							}
						}
						y++;
					}
					//added trimming code if doesn't work lets use substring
					//resultValue.add(s1.toString().trim());
					resultValue.add(s1.substring(0,s1.length()-1));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (NullPointerException ex) {
				System.out.println("No Records found for this specific query" +ex.getStackTrace());
			}
			finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException ex) {
						System.out.println( "SQL Exception:" +ex.getStackTrace());
					}
				}
			}

		}catch(SQLException sqlEx) {
			System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
		}
		System.out.println("result value is "+resultValue);
		return resultValue;		
	}

	
	public static String sqlquery(File inputFile) throws FileNotFoundException {

		// Delimiter
		String delimiter = ";";
		ResultSet rs1 = null;

		// Create scanner
		Scanner scanner = null;
		try {
			scanner = new Scanner(inputFile).useDelimiter(delimiter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		}

		// Loop through the SQL file statements 
		Statement currentStatement = null;
		//while(scanner.hasNext()) {

		// Get statement 
		String rawStatement = scanner.next();//+ delimiter;

		scanner.close();
		//	System.out.println("raw statement is "+rawStatement);

		return rawStatement;

	}
	
	public static Object executeSQLQuery_List_new() throws FileNotFoundException {
		String connectionUrl="";
		Connection connection;
		ArrayList<String[]> resultValue = new ArrayList<String[]>();
		//  ArrayList<ArrayList<String>> resultValue = new ArrayList<ArrayList<String>>();
		//   ArrayList<String> colData = new ArrayList<String>();
		ResultSet resultSet;
		// String sqlQuery = "select * from RMAS where rma_number = '1234' and rma_ret_id = '42595'";



		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url,dbusername,dbpassword);
			if(connection!=null) {
				System.out.println("Connected to the database");
			}else {
				System.out.println("Failed to connect to ");
			}
			Statement statement = connection.createStatement();
			resultSet=statement.executeQuery(DataBaseConnector.sqlquery(file));

			try {

				while(resultSet.next()){	
					int columnCount = resultSet.getMetaData().getColumnCount();					
					StringBuffer s1=new StringBuffer();					
					//	System.out.println(s.append(resultSet.getString("Created_Time").trim()+"").append(resultSet.getString("RMA_Number").trim()+"").append(resultSet.getString("Retailer_ID").trim()+"").append(resultSet.getString("Retailer_Name").trim()+"").append(resultSet.getString("RMA_status").trim()+"").append(resultSet.getString("Return_Address_ID").trim()+"").append(resultSet.getString("Address_Name").trim()+"").append(resultSet.getString("Ship_to_address_line_1").trim()+"").append(resultSet.getString("City").trim()+"").append(resultSet.getString("State0").trim()+"").append(resultSet.getString("From_Name").trim()+"").append(resultSet.getString("From_City").trim()+"").append(resultSet.getString("From_State").trim()+"").append(resultSet.getString("ship_to_postal_code").trim()+"").append(resultSet.getString("From_Email").trim()+"").append(resultSet.getString("Tracking_Number").trim()+"").append(resultSet.getString("Item_Sku").trim()+"").append(resultSet.getString("Item_Description").trim()+"").append(resultSet.getString("Ship_Id__order___").trim()+""));
					String[] coloumns = new String[]{"Created_Time","RMA_Number","Retailer_ID","Retailer_Name","RMA_status","Receipt_date","Return_Address_ID","Address_Name","Ship_to_address_line_1","City","State0","From_Name","From_City","From_State","ship_to_postal_code","From_Email","Tracking_Number","Item_Sku","Item_Description","Ship_Id__order___","Vendor_RA_Number","Final_Sale_Flag","RMA_Credit_Type","Ship_Node","Return_Reason","Label_create_date","Expected_Qty","Actual_Qty","Department__","Reference__","PO__","Invoice__","Notes"};
					String[] row = new String[coloumns.length];
					int y=0;
					while(y<coloumns.length){
						
						if(resultSet.getString(coloumns[y])!=null){
							if(coloumns[y]=="Created_Time" || coloumns[y]=="Label_create_date"){
								String actual = resultSet.getString(coloumns[y]).trim().substring(0, 10);								
								String month = actual.substring(5, 7);								
								String date = actual.substring(8, 10);							
								String year = actual.substring(0, 4);
								String resultdate = month+"/"+date+"/"+year;

							//	s1.append(resultdate+" ");
								row[y]=resultdate;

							}else{								
								//s1.append(resultSet.getString(coloumns[y]).trim()+" ");
								row[y]=resultSet.getString(coloumns[y]).trim();

							}
						}
						y++;
					}
					//added trimming code if doesn't work lets use substring
					//resultValue.add(s1.toString().trim());
					resultValue.add(row);
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (NullPointerException ex) {
				System.out.println("No Records found for this specific query" +ex.getStackTrace());
			}
			finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException ex) {
						System.out.println( "SQL Exception:" +ex.getStackTrace());
					}
				}
			}

		}catch(SQLException sqlEx) {
			System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
		}
		System.out.println("result value is "+resultValue);
		return resultValue;		
	}
	public static void main(String[] args) throws FileNotFoundException{

		File file = new File("C://Users//KO398762//Desktop//sqlnew.sql");


		DataBaseConnector.executeSQLQuery_List_new();
		
	}
	
	
	
}