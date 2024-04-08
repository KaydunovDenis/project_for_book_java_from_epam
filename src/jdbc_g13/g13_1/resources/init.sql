DROP TABLE IF EXISTS CATALOG, FILE;


create table CATALOG
(
    CATALOG_ID        INTEGER auto_increment
        primary key,
    PARENT_CATALOG_ID INTEGER DEFAULT NULL,
    NAME              CHARACTER VARYING(1000),
    FOREIGN KEY (PARENT_CATALOG_ID) REFERENCES CATALOG (CATALOG_ID) ON DELETE CASCADE
);

INSERT INTO CATALOG (PARENT_CATALOG_ID, NAME) VALUES (NULL, 'Catalog 1');

create table FILE
(
    FILE_ID           INTEGER auto_increment
        primary key,
    PARENT_CATALOG_ID INTEGER,
    NAME              CHARACTER VARYING(1000),
    SIZE              INTEGER,
    FOREIGN KEY (PARENT_CATALOG_ID) REFERENCES CATALOG (CATALOG_ID) ON DELETE CASCADE
);


INSERT INTO CATALOG (PARENT_CATALOG_ID, NAME)
VALUES (1, 'Catalog 2'),
       (1, 'Catalog 3'),
       (2, 'Subcatalog 1.1'),
       (2, 'Subcatalog 1.2'),
       (3, 'Subcatalog 2.1'),
       (3, 'Subcatalog 2.2'),
       (3, 'Subcatalog 3.1'),
       (3, 'Subcatalog 3.2'),
       (3, 'Subcatalog 3.3');


INSERT INTO FILE (PARENT_CATALOG_ID, NAME, SIZE)
VALUES (1, 'File 1', 100),
       (1, 'File 2', 200),
       (2, 'File 3', 150),
       (2, 'File 4', 300),
       (3, 'File 5', 250),
       (3, 'File 6', 400),
       (4, 'File 7', 300),
       (4, 'File 8', 500),
       (5, 'File 9', 350),
       (5, 'File 10', 600);
