package test;

//дһ���ӿڣ��������ô�����淶��ִ��Ч�ʸ��ߡ�
public interface Dao {
	//UserDao ������ʵ�ֽӿ���
	public User login(String username ,String password);
	public void register(String username, String password);
	
}
