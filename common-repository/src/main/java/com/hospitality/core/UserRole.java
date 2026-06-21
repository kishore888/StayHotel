package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;


/**
 * The persistent class for the users_role database table.
 * 
 */
@Entity
@Table(name="user_role")
//@NamedQuery(name="UsersRole.findAll", query="SELECT u FROM UsersRole u")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class UserRole extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_role_id")
	private String userRoleId;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;

	public UserRole() {
	}


}