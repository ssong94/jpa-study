package com.spring.boot.jpastudy.jpa05;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Entity
@Table(name = "access_log")
public class AccessLog {
	@Id
	@TableGenerator(
			name = "accessIdGen",
			table = "id_seq",
			pkColumnName = "entity",
			pkColumnValue = "accesslog",
			valueColumnName = "nextval",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "accessIdGen")
	private Long id;
	private String path;
	private LocalDateTime accessed;

	protected AccessLog() {
	}

	public AccessLog(String path, LocalDateTime accessed) {
		this.path = path;
		this.accessed = accessed;
	}

}
