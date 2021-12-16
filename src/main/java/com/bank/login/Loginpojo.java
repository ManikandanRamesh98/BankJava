package com.bank.login;

import java.util.Objects;

public class Loginpojo {
private int Id;
private String username;
private String logged_at;
private String Role;


public Loginpojo(int id, String username, String logged_at, String role) {
	
	Id = id;
	this.username = username;
	this.logged_at = logged_at;
	Role = role;
}

public Loginpojo(String username) {
	
}





public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}


public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}


public String getLogged_at() {
	return logged_at;
}


public void setLogged_at(String logged_at) {
	this.logged_at = logged_at;
}


public String getRole() {
	return Role;
}


public void setRole(String role) {
	Role = role;
}

@Override
public String toString() {
	return "Loginpojo [Id=" + Id + ", username=" + username + ", logged_at=" + logged_at + ", Role=" + Role + "]";
}







@Override
public int hashCode() {
	return Objects.hash(Id, Role, logged_at, username);
}







@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Loginpojo other = (Loginpojo) obj;
	return Id == other.Id && Objects.equals(Role, other.Role) && Objects.equals(logged_at, other.logged_at)
			&& Objects.equals(username, other.username);
}


}
