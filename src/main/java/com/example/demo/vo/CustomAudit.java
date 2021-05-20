package com.example.demo.vo;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CustomAudit {

	@PrePersist
	void preCreate(final Auditable auditable) {

		Audit audit = auditable.getAudit();

		if (audit == null) {
			audit = new Audit();
			auditable.setAudit(audit);
		}

		final LocalDateTime now = LocalDateTime.now();

		audit.setCreatedTimestamp(now);
		audit.setLastUpdatedTimestamp(now);

		audit.setCreatedBy("Abhishek");

		audit.setLastUpdatedBy("Abhishek");
	}

	@PreUpdate
	void preUpdate(final Auditable auditable) {
		final LocalDateTime now = LocalDateTime.now();

		final Audit audit = auditable.getAudit();

		audit.setLastUpdatedTimestamp(now);

		audit.setLastUpdatedBy("khalid");
	}

}
