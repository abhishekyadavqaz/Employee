package com.example.demo.vo;

public interface Auditable {

	void setAudit(Audit audit);

	Audit getAudit();

}
