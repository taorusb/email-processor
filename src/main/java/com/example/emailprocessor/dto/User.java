package com.example.emailprocessor.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User {
	private String email;
	private String firstName;
	private String lastName;
}
