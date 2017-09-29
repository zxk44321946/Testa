package test;

//写一个接口，这样会让代码更规范，执行效率更高。
public interface Dao {
	//UserDao 类用来实现接口类
	public User login(String username ,String password);
	public void register(String username, String password);
	
}
