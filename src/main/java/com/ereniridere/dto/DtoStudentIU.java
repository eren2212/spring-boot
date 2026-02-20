package com.ereniridere.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DtoStudentIU {

	@NotEmpty(message = "FirstName alanı boş bırakılamaz")
	private String firstName;

	@Size(max = 10, min = 3, message = "Lütfen 3 ile 10 karakter arası giriniz.")
	private String lastName;

	private Date birthOfDate;

}
