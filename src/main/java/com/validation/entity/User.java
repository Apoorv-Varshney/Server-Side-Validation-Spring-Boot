package com.validation.entity;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
public class User {
	
	@NotBlank(message = "Name should not be blank")
	@Size(min=4,max=10)
	private String userName;
	@AssertTrue(message="Must agree to Terms and Conditions")
	private boolean agreed;
	
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
			message="Minimum eight characters, at least one letter and one number.")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", agreed=" + agreed + ", password=" + password + "]";
	}

	
}
