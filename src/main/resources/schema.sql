CREATE TABLE planet (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ds_name VARCHAR(255) NOT NULL,
    vl_width INTEGER NOT NULL,
    vl_height INTEGER NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE probe (
    id   INTEGER NOT NULL AUTO_INCREMENT,
    id_planet INTEGER NOT NULL,
    ds_name VARCHAR(255) NOT NULL,
    ds_direction VARCHAR(255) NOT NULL,
    vl_position_vertical INTEGER NOT NULL,
    vl_horizontal_vertical INTEGER NOT NULL,
    PRIMARY KEY (id)
);