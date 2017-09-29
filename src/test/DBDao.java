package test;
import java.sql.*;
public class DBDao {
/**
 * ����JDBC�������ݿ�
 */

    // JDBC �����������ݿ� URL
   
    // ���ݿ���û��������룬��Ҫ�����Լ�������
   
    
    @SuppressWarnings("unused")
	public static Connection getConnection(String sql) throws SQLException, ClassNotFoundException{
    	 
       
            //1. ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");
        	final String DB_URL = "jdbc:mysql://127.0.0.1:3306/myfirst?useSSL=false";  
        	final String USER = "root";
    	    final String PASS = "1234";
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    	    Connection conn =DriverManager.getConnection(DB_URL,USER,PASS);
    	    if(conn != null){
    	    	return conn;
    	    }else {
				System.out.println("��������ʧ�ܣ�");
				return null;
			}
        }
    public boolean isExistUsername(String username) {
   	    Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet userSet = null;
        try{
            
       	   // 2. ִ��SQL��䣬����ִ�н����ResultSet
       	 String sql = "select * from login where username=?";
       	//1. �������ݿ�
            conn = DBDao.getConnection(sql);
              
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, username);
            userSet = preStmt.executeQuery();
            //3. ����ִ�н����ResultSet
            if(userSet.next()){
                return true;
            }
            return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return true;
        }finally{
            //4. ��Ҫ�Ĺر�ResultSet��Statement
            if(userSet != null&& preStmt!=null){
                try {
                    userSet.close();
                    preStmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
   	}
}
    
