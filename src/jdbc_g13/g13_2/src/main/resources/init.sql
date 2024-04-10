DROP TABLE IF EXISTS movie, actor, director;

CREATE TABLE movie
(
    id             INT AUTO_INCREMENT,
    name           VARCHAR,
    releaseDate    TIMESTAMP,
    releaseCountry VARCHAR
);

CREATE TABLE actor
(
    id          INT AUTO_INCREMENT,
    name        VARCHAR,
    dateOfBirth VARCHAR
);

CREATE TABLE director
(
    id          INT AUTO_INCREMENT,
    name        VARCHAR,
    dateOfBirth VARCHAR
);

