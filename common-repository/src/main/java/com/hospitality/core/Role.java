package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
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

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<RolePrivilege> getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(List<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

	public RolePrivilege addRolePrivilege(RolePrivilege rolePrivilege) {
		getRolePrivileges().add(rolePrivilege);
		rolePrivilege.setRole(this);

		return rolePrivilege;
	}

	public RolePrivilege removeRolePrivilege(RolePrivilege rolePrivilege) {
		getRolePrivileges().remove(rolePrivilege);
		rolePrivilege.setRole(null);

		return rolePrivilege;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUsersRole(UserRole usersRole) {
		getUserRoles().add(usersRole);
		usersRole.setRole(this);

		return usersRole;
	}

	public UserRole removeUsersRole(UserRole usersRole) {
		getUserRoles().remove(usersRole);
		usersRole.setRole(null);

		return usersRole;
	}

}