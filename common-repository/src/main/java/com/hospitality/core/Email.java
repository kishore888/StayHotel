package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;
import lombok.Data;


/**
 * The persistent class for the email database table.
 * 
 */
@Entity
//@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
@Data
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

}