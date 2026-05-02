package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;

import java.util.List;


/**
 * The persistent class for the privilege database table.
 * 
 */
@Entity
@Table(name="privilege")
//@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="privilege_id")
	private String privilegeId;

	@Column(name="description")
	private String description;

	@Column(name="privilege_code")
	private String privilegeCode;

	@Column(name="privilege_order")
	private Integer privilegeOrder;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="module_id")
	private Module module;
	
	//bi-directional many-to-one association to RolePrivilege
	@OneToMany(fetch=FetchType.LAZY, mappedBy="privilege")
	private List<RolePrivilege> rolePrivileges;

	public Privilege() {
	}

	public String getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrivilegeCode() {
		return this.privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	public Integer getPrivilegeOrder() {
		return this.privilegeOrder;
	}

	public void setPrivilegeOrder(Integer privilegeOrder) {
		this.privilegeOrder = privilegeOrder;
	}

	public List<RolePrivilege> getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(List<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

	public RolePrivilege addRolePrivilege(RolePrivilege rolePrivilege) {
		getRolePrivileges().add(rolePrivilege);
		rolePrivilege.setPrivilege(this);

		return rolePrivilege;
	}

	public RolePrivilege removeRolePrivilege(RolePrivilege rolePrivilege) {
		getRolePrivileges().remove(rolePrivilege);
		rolePrivilege.setPrivilege(null);

		return rolePrivilege;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}