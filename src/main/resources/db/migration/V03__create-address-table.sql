CREATE TABLE address(
    id uuid NOT NULL,
    retailer_id uuid NOT NULL,
    province VARCHAR(255) NOT NULL,
    municipality VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    localization GEOGRAPHY(point, 4326) NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE address ADD FOREIGN KEY(retailer_id)
    REFERENCES retailers(id);