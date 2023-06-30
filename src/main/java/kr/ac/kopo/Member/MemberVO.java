package kr.ac.kopo.Member;

public class MemberVO { 
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String usercode;
	private String phone;
	private String postcode;
	private String address;
	private String user_type;
	
	
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the usercode
	 */
	public String getUsercode() {
		return usercode;
	}
	/**
	 * @param usercode the usercode to set
	 */
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}
	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public MemberVO(String id, String password, String name, String email, String usercode, String phone,
			String postcode, String address, String user_type) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.usercode = usercode;
		this.phone = phone;
		this.postcode = postcode;
		this.address = address;
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", usercode="
				+ usercode + ", phone=" + phone + ", postcode=" + postcode + ", address=" + address + ", user_type="
				+ user_type + "]";
	}
	

	
	
	
	
}

