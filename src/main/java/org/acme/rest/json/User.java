package org.acme.rest.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class User {
    private String username;
    private String name;
    private String surname;
    private String birth;
    private String id;

    public User() {
    }

    public User(String username, String name, String surname, String birth) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }    

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }

        User other = (User) obj;

        return Objects.equals(other.username, this.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }

	public void setId(String id) {
        this.id = id;
	}

	public String getId() {
		return id;
	}
}