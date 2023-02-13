package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class NewUserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idUser;
	private String email;
	private String password;
	private String role;
	
	public NewUserInfo() {}
	
	public NewUserInfo(int id, String email, String password, String role) {
		super();
		this.idUser = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	
	public int getIdUser() {
		return idUser;
	}

	public void setId(int id) {
		this.idUser = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idUser, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserInfo other = (NewUserInfo) obj;
		return Objects.equals(email, other.email) && idUser == other.idUser
				&& Objects.equals(password, other.password)
				&& Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "NewUserInfo [id=" + idUser + ", email=" + email + ", password="
				+ password + ", role=" + role + "]";
	}
	
	
}
