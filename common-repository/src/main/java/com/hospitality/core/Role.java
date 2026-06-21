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
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class Role extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private String roleId;

	@Column(name="description")
	private String description;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	//bi-directional many-to-one association to RolePrivilege
	@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
	private List<RolePrivilege> rolePrivileges;

	//bi-directional many-to-one association to UsersRole
	@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
	}

}