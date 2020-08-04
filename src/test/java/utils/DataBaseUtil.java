package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class DataBaseUtil {
	
	private static String user = Config.getProperty("dbUser_name");
	private static String pwd = Config.getProperty("dbPwd");
	private static String url = Config.getProperty("dbUrl");

	 public DataBaseUtil(){
		
	 }
	
	public static void main(String[] args){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("select * from RMAS where rma_number = '1234' and rma_ret_id = '42595'");
		    
		    while(rs.next()){
		    	//System.out.println(rs.getInt(1));
		    	System.out.println(rs.getString("RMA_created_time"));
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}		
	}	
	
	public static boolean isRecordExisting (String query){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean isExisting = false;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	isExisting = true;
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return isExisting;
	}
	
	public static String getFirstRowDataWithColumnName(String query, String columnName){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnData = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	columnData = rs.getString(columnName);
		    	
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return columnData;
	}
	public static Map<String, String> getFirstRowDataWithColumnNames(String query, String... columnNames){
		//var-args
		Map<String, String> rowData = new HashMap<String, String>();
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	for(String columnLabel: columnNames){
		    		rowData.put(columnLabel, rs.getString(columnLabel));
		    	}
		    	break;
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return rowData;
	}
}
