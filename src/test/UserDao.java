package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * 操作登录注册类，实现Dao接口类
 */

public class UserDao implements Dao {

		/**
		 * 获取数据库的值
		 *
		 */
	User user=null;
	private String SQL="";
	private Connection connection = null;
	public User login(String username ,String password){//登录
		/**
		 * 获取数据库的值
		 */
		 SQL = "select * from login where username = ? and password = ?";
	        
	        PreparedStatement pstmt = null;
	        try{
	        	connection=DBDao.getConnection(SQL);
	             pstmt = connection.prepareStatement(SQL);
	             pstmt.setString(1, username);
	             pstmt.setString(2, password);
	             ResultSet rSet = (ResultSet) pstmt.executeQuery();//得到数据库的查询结果
	 	       if (rSet.next()) {
	 			user =new User();
	 			user.setUsername(rSet.getString("username"));
	 			user.setPassword(rSet.getString("password"));
	        }
	 	      connection.close();
	            pstmt.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
			return user; 
	        }

		@SuppressWarnings("unused")
		public void register(String username, String password) {//注册
			DBDao dao=new DBDao();
			Boolean a=dao.isExistUsername(username);
	    	if (!a) {
			SQL = "insert into login(username,password) values(?,?)";
	    	//连接数据库
			try {
				connection=DBDao.getConnection(SQL);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    try{
               // 创建PreparedStatement对象   
	    	PreparedStatement	pstmt = connection.prepareStatement(SQL);
               // 对SQL语句中的参数动态赋值  
	    	pstmt.setString(1, username);
	    	pstmt.setString(2, password);
	    	pstmt.executeUpdate();
	    	//executeUpdate()插入时更新到数据库，  executeQuery()查询时保存
	    	ResultSet rs =null;
//	    	Statement st=null;
//	    	rs=st.executeQuery("select *from login");
	        //int row=pstmt.executeUpdate();
	        //executeUpdate();表示执行sql语句，如果成功返回1，否之返回0
//              if (row>0) {
//				System.out.println("成功注册！");
//			} 
             pstmt.close();
             connection.close();
	       } catch (SQLException e) {    e.printStackTrace();   }
	            System.out.println("注册成功");
			}else {
			    System.out.println("请重新注册，用户名已经存在!");
			}
		
	    
		}
	}


