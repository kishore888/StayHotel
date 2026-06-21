package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;


/**
 * The persistent class for the role_privilege database table.
 * 
 */
@Entity
@Table(name="role_privilege")
//@NamedQuery(name="RolePrivilege.findAll", query="SELECT r FROM RolePrivilege r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
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

}