package com.example.demo.audit;

public interface Auditable {

	void setAudit(Audit audit);

	Audit getAudit();

}
