package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;
import lombok.Data;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@Table(name="module")
//@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
@Data
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

}