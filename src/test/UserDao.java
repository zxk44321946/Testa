package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * ������¼ע���࣬ʵ��Dao�ӿ���
 */

public class UserDao implements Dao {

		/**
		 * ��ȡ���ݿ��ֵ
		 *
		 */
	User user=null;
	private String SQL="";
	private Connection connection = null;
	public User login(String username ,String password){//��¼
		/**
		 * ��ȡ���ݿ��ֵ
		 */
		 SQL = "select * from login where username = ? and password = ?";
	        
	        PreparedStatement pstmt = null;
	        try{
	        	connection=DBDao.getConnection(SQL);
	             pstmt = connection.prepareStatement(SQL);
	             pstmt.setString(1, username);
	             pstmt.setString(2, password);
	             ResultSet rSet = (ResultSet) pstmt.executeQuery();//�õ����ݿ�Ĳ�ѯ���
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
		public void register(String username, String password) {//ע��
			DBDao dao=new DBDao();
			Boolean a=dao.isExistUsername(username);
	    	if (!a) {
			SQL = "insert into login(username,password) values(?,?)";
	    	//�������ݿ�
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
               // ����PreparedStatement����   
	    	PreparedStatement	pstmt = connection.prepareStatement(SQL);
               // ��SQL����еĲ�����̬��ֵ  
	    	pstmt.setString(1, username);
	    	pstmt.setString(2, password);
	    	pstmt.executeUpdate();
	    	//executeUpdate()����ʱ���µ����ݿ⣬  executeQuery()��ѯʱ����
	    	ResultSet rs =null;
//	    	Statement st=null;
//	    	rs=st.executeQuery("select *from login");
	        //int row=pstmt.executeUpdate();
	        //executeUpdate();��ʾִ��sql��䣬����ɹ�����1����֮����0
//              if (row>0) {
//				System.out.println("�ɹ�ע�ᣡ");
//			} 
             pstmt.close();
             connection.close();
	       } catch (SQLException e) {    e.printStackTrace();   }
	            System.out.println("ע��ɹ�");
			}else {
			    System.out.println("������ע�ᣬ�û����Ѿ�����!");
			}
		
	    
		}
	}


