create table CATALOG
(
    ID                INTEGER auto_increment
        primary key,
    PARENT_CATALOG_ID INTEGER default 0,
    NAME              CHARACTER VARYING(1000)
);

create table FILE
(
    ID                INTEGER auto_increment
        primary key,
    PARENT_CATALOG_ID INTEGER default 0,
    NAME              CHARACTER VARYING(1000),
    SIZE              INTEGER
);