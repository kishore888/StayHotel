-- Form Field Configuration table
-- Stores per-hotel dynamic form field settings for each entity type (employee, room, roomType)

CREATE TABLE IF NOT EXISTS form_field_config (
    config_id        VARCHAR(36)  NOT NULL PRIMARY KEY,
    hotel_id         VARCHAR(36)  NOT NULL,
    entity_type      VARCHAR(50)  NOT NULL,
    field_name       VARCHAR(100) NOT NULL,
    label            VARCHAR(200) NOT NULL,
    field_type       VARCHAR(50)  NOT NULL,
    visible          BOOLEAN      NOT NULL DEFAULT TRUE,
    required         BOOLEAN      NOT NULL DEFAULT FALSE,
    field_order      INT          NOT NULL DEFAULT 0,
    max_length       INT,
    pattern_regex    VARCHAR(500),
    pattern_message  VARCHAR(500),
    field_options    VARCHAR(2000),
    created_on       TIMESTAMP,
    updated_on       TIMESTAMP,
    created_by       VARCHAR(100),
    updated_by       VARCHAR(100),

    CONSTRAINT fk_ffc_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id),
    CONSTRAINT uq_ffc_hotel_entity_field UNIQUE (hotel_id, entity_type, field_name)
);

CREATE INDEX IF NOT EXISTS idx_ffc_hotel_entity ON form_field_config (hotel_id, entity_type);
