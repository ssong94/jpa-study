package com.spring.boot.jpastudy.jpa06;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "addr1")
	private String address1;
	@Column(name = "addr2")
	private String address2;
	@Column(name = "zipcode")
	private String zipcode;

	protected Address() {
	}

	public Address(String address1, String address2, String zipcode) {
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
	}
}
