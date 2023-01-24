package JSONSerializer;

public class Data {
	private String id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;

	public String getUserId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.first_name;
	}

	public String getLastName() {
		return this.last_name;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setId(String id) {
		this.id = id;

	}

	public void setEmail(String email) {
		this.email = email;

	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;

	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;

	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;

	}
}
