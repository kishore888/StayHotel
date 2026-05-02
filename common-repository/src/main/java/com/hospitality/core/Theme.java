package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
//@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Theme extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="theme_id")
	private String themeId;

	@Column(name="hotel_id")
	private String hotelId;

	@Column(name="theme_name")
	private String themeName;

	//bi-directional many-to-one association to ElementStyle
	@OneToMany(fetch=FetchType.LAZY, mappedBy="theme")
	private List<ElementStyle> elementStyles;

	public Theme() {
	}

	public String getThemeId() {
		return this.themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getThemeName() {
		return this.themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public List<ElementStyle> getElementStyles() {
		return this.elementStyles;
	}

	public void setElementStyles(List<ElementStyle> elementStyles) {
		this.elementStyles = elementStyles;
	}

	public ElementStyle addElementStyle(ElementStyle elementStyle) {
		getElementStyles().add(elementStyle);
		elementStyle.setTheme(this);

		return elementStyle;
	}

	public ElementStyle removeElementStyle(ElementStyle elementStyle) {
		getElementStyles().remove(elementStyle);
		elementStyle.setTheme(null);

		return elementStyle;
	}

}