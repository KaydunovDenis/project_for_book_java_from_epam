DROP TABLE IF EXISTS g13_2.movie_actor, g13_2.movie, g13_2.actor, g13_2.director cascade;

CREATE SCHEMA IF NOT EXISTS g13_2;

CREATE TABLE g13_2.director
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR,
    date_of_birth DATE
);

CREATE TABLE g13_2.movie
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR,
    release_date    DATE,
    release_country VARCHAR,
    director_id     INT,
    FOREIGN KEY (director_id) REFERENCES director (id)
);

CREATE TABLE g13_2.actor
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR,
    date_of_birth DATE
);

CREATE TABLE g13_2.movie_actor
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    actor_id INT,
    FOREIGN KEY (movie_id) REFERENCES g13_2.movie,
    FOREIGN KEY (actor_id) REFERENCES g13_2.actor
);


INSERT INTO g13_2.actor (name, date_of_birth)
VALUES ('Denis Kaydunov', DATE '1990-01-12'),
       ('Den Belzerian', DATE '1980-02-17'),
       ('Denny Kad', DATE '1991-03-11'),
       ('Emily Discount', DATE '2000-01-12'),
       ('Emil Dis', DATE '2020-01-12'),
       ('Milly Count', DATE '2000-02-12'),
       ('Ily Isc', DATE '2001-01-12');

INSERT INTO g13_2.director (name, date_of_birth)
VALUES ('Denis Kaydunov', DATE '1990-01-12'),
       ('Den Belzerian', DATE '1980-02-17'),
       ('Denny Kad', DATE '1991-03-11'),
       ('Ily Isc', DATE '2001-01-12');

INSERT INTO g13_2.movie (name, release_date, release_country, director_id)
VALUES ('War', DATE '1990-01-12', 'USA', 2),
       ('World', DATE '2023-03-30', 'Russia', 1),
       ('War and world', DATE '2021-02-10', 'Russia', 2),
       ('Denis Kaydunov', DATE '2024-03-30', 'Russia', 1),
       ('Dandy', DATE '2021-05-30', 'Bulgaria', 4),
       ('Dandy 2', DATE '2022-04-11', 'Bulgaria', 3);

INSERT INTO g13_2.movie_actor (movie_id, actor_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 1),
       (3, 2),
       (4, 1),
       (4, 4),
       (5, 1),
       (6, 1),
       (6, 3),
       (6, 6),
       (6, 7),
       (6, 5);
