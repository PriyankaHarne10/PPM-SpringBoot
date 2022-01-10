package com.example.ppm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      String password = "Admin@123";
      String encodedPassword=encoder.encode(password);
      System.out.print(encodedPassword);
	}

}
