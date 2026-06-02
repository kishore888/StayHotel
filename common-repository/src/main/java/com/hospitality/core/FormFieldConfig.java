package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@Entity
@Table(name = "form_field_config")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class FormFieldConfig extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "config_id")
    private String configId;

    @Column(name = "entity_type", nullable = false, length = 50)
    private String entityType;

    @Column(name = "field_name", nullable = false, length = 100)
    private String fieldName;

    @Column(name = "label", nullable = false, length = 200)
    private String label;

    @Column(name = "field_type", nullable = false, length = 50)
    private String fieldType;

    @Column(name = "visible", nullable = false)
    private Boolean visible = true;

    @Column(name = "required", nullable = false)
    private Boolean required = false;

    @Column(name = "field_order", nullable = false)
    private Integer fieldOrder;

    @Column(name = "max_length")
    private Integer maxLength;

    @Column(name = "pattern_regex", length = 500)
    private String patternRegex;

    @Column(name = "pattern_message", length = 500)
    private String patternMessage;

    @Column(name = "field_options", length = 2000)
    private String fieldOptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public FormFieldConfig() {}

    public String getConfigId() { return configId; }
    public void setConfigId(String configId) { this.configId = configId; }

    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getFieldType() { return fieldType; }
    public void setFieldType(String fieldType) { this.fieldType = fieldType; }

    public Boolean getVisible() { return visible; }
    public void setVisible(Boolean visible) { this.visible = visible; }

    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }

    public Integer getFieldOrder() { return fieldOrder; }
    public void setFieldOrder(Integer fieldOrder) { this.fieldOrder = fieldOrder; }

    public Integer getMaxLength() { return maxLength; }
    public void setMaxLength(Integer maxLength) { this.maxLength = maxLength; }

    public String getPatternRegex() { return patternRegex; }
    public void setPatternRegex(String patternRegex) { this.patternRegex = patternRegex; }

    public String getPatternMessage() { return patternMessage; }
    public void setPatternMessage(String patternMessage) { this.patternMessage = patternMessage; }

    public String getFieldOptions() { return fieldOptions; }
    public void setFieldOptions(String fieldOptions) { this.fieldOptions = fieldOptions; }

    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}
