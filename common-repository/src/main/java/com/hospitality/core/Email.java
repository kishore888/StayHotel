package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;


/**
 * The persistent class for the email database table.
 * 
 */
@Entity
//@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email_id")
	private String emailId;

	@Column(name="from")
	private String from;

	@Column(name="message")
	private String message;

	@Column(name="status")
	private String status;

	@Column(name="subject")
	private String subject;

	@Column(name="to")
	private String to;
	
	@Column(name="attachment")
	private String attachment;

	public Email() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}