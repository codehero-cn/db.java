package cn.codehero.mybatis.test1;

public class User {
	private int id;
	private String username;
	private int age;
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.username = name;
		this.age = age;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", age=" + age + "]";
	}
	
	
}
