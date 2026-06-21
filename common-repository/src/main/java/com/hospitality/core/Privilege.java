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
 * The persistent class for the privilege database table.
 * 
 */
@Entity
@Table(name="privilege")
//@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
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

//	public RolePrivilege addRolePrivilege(RolePrivilege rolePrivilege) {
//		getRolePrivileges().add(rolePrivilege);
//		rolePrivilege.setPrivilege(this);
//
//		return rolePrivilege;
//	}
//
//	public RolePrivilege removeRolePrivilege(RolePrivilege rolePrivilege) {
//		getRolePrivileges().remove(rolePrivilege);
//		rolePrivilege.setPrivilege(null);
//
//		return rolePrivilege;
//	}

}