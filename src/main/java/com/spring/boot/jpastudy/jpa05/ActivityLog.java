package com.spring.boot.jpastudy.jpa05;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Entity
@Table(schema = "crm", name = "activity_log")
public class ActivityLog {
	@Id
	@SequenceGenerator(
			name = "log_seq_gen",
			sequenceName = "activity_seq",
			schema = "crm",
			allocationSize = 1
	)
	@GeneratedValue(generator = "log_seq_gen")
	private Long id;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "activity_type")
	private String activityType;
	private LocalDateTime created;

	protected ActivityLog() {
	}

	public ActivityLog(String userId, String activityType) {
		this.userId = userId;
		this.activityType = activityType;
		this.created = LocalDateTime.now();
	}

}
