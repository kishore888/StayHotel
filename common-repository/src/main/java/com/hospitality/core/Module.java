package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@Table(name="module")
//@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="module_id")
	private String moduleId;

	@Column(name="description")
	private String description;

	@Column(name="module_name")
	private String moduleName;

	public Module() {
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}