package com.spring.boot.jpastudy.jpa06;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
	@Id
	private String id;

	@Embedded
	private RabbitConnectionDetails.Address homeAddress;

	@AttributeOverrides({
			@AttributeOverride(name = "address1", column = @Column(name = "waddr1")),
			@AttributeOverride(name = "address2", column = @Column(name = "waddr2")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "wzipcode"))
	})
	@Embedded
	private RabbitConnectionDetails.Address workAddress;


}
