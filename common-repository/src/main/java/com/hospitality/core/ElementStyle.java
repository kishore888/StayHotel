package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


/**
 * The persistent class for the element_style database table.
 * 
 */
@Entity
@Table(name="element_style")
//@NamedQuery(name="ElementStyle.findAll", query="SELECT e FROM ElementStyle e")
@JsonIdentityInfo(generator = JSOGGenerator.class)
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

	public String getElementStyleId() {
		return this.elementStyleId;
	}

	public void setElementStyleId(String elementStyleId) {
		this.elementStyleId = elementStyleId;
	}

	public String getBackgroundColor() {
		return this.backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getElementName() {
		return this.elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}