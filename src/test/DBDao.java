package test;
import java.sql.*;
public class DBDao {
/**
 * 创建JDBC连接数据库
 */

    // JDBC 驱动名及数据库 URL
   
    // 数据库的用户名与密码，需要根据自己的设置
   
    
    @SuppressWarnings("unused")
	public static Connection getConnection(String sql) throws SQLException, ClassNotFoundException{
    	 
       
            //1. 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        	final String DB_URL = "jdbc:mysql://127.0.0.1:3306/myfirst?useSSL=false";  
        	final String USER = "root";
    	    final String PASS = "1234";
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    	    Connection conn =DriverManager.getConnection(DB_URL,USER,PASS);
    	    if(conn != null){
    	    	return conn;
    	    }else {
				System.out.println("数据连接失败！");
				return null;
			}
        }
    public boolean isExistUsername(String username) {
   	    Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet userSet = null;
        try{
            
       	   // 2. 执行SQL语句，接收执行结果集ResultSet
       	 String sql = "select * from login where username=?";
       	//1. 连接数据库
            conn = DBDao.getConnection(sql);
              
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, username);
            userSet = preStmt.executeQuery();
            //3. 处理执行结果集ResultSet
            if(userSet.next()){
                return true;
            }
            return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return true;
        }finally{
            //4. 必要的关闭ResultSet、Statement
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
    
