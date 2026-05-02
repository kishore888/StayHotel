package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


/**
 * The persistent class for the role_privilege database table.
 * 
 */
@Entity
@Table(name="role_privilege")
//@NamedQuery(name="RolePrivilege.findAll", query="SELECT r FROM RolePrivilege r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class RolePrivilege extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_privilege_id")
	private String rolePrivilegeId;

	//bi-directional many-to-one association to Privilege
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="privilege_id")
	private Privilege privilege;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;

	public RolePrivilege() {
	}

	public String getRolePrivilegeId() {
		return this.rolePrivilegeId;
	}

	public void setRolePrivilegeId(String rolePrivilegeId) {
		this.rolePrivilegeId = rolePrivilegeId;
	}

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}