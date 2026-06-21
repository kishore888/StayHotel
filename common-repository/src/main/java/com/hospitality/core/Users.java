package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class Users extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	//bi-directional many-to-one association to UsersRole
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private List<UserRole> userRoles;

	public Users() {
	}

//	public UserRole addUsersRole(UserRole usersRole) {
//		getUserRoles().add(usersRole);
//		usersRole.setUser(this);
//
//		return usersRole;
//	}
//
//	public UserRole removeUsersRole(UserRole usersRole) {
//		getUserRoles().remove(usersRole);
//		usersRole.setUser(null);
//
//		return usersRole;
//	}

}