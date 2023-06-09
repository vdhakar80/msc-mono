package mu.vi.mscmono.user;

import java.time.LocalDate;

public class UserBean {
	private  int id;
	private String name;
	private LocalDate dob;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
}
