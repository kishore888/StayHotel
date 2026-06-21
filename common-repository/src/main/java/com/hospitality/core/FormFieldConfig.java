package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

@Entity
@Table(name = "form_field_config")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
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

}
