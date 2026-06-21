package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;


/**
 * The persistent class for the element_style database table.
 * 
 */
@Entity
@Table(name="element_style")
//@NamedQuery(name="ElementStyle.findAll", query="SELECT e FROM ElementStyle e")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class ElementStyle extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="element_style_id")
	private String elementStyleId;

	@Column(name="background_color")
	private String backgroundColor;

	@Column(name="color")
	private String color;

	@Column(name="element_name")
	private String elementName;
	
	@Column(name="class_name")
	private String className;

	//bi-directional many-to-one association to Theme
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="theme_id")
	private Theme theme;

	public ElementStyle() {
	}

}