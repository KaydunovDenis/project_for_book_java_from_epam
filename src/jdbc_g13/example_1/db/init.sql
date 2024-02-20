create table PUBLIC.PHONEBOOK(
                          IDPHONEBOOK INT NOT NULL PRIMARY KEY,
                          LASTNAME VARCHAR,
                          PHONE INT
);

INSERT INTO PHONEBOOK (IDPHONEBOOK, LASTNAME, PHONE)
VALUES
    (1, 'Smith', 12345890),
    (2, 'Johnson', 23478901),
    (3, 'Williams', 34789012),
    (4, 'Jones', 45678123),
    (5, 'Brown', 56781234),
    (6, 'Davis', 67892345),
    (7, 'Miller', 78923456),
    (8, 'Wilson', 89034567),
    (9, 'Moore', 90125678),
    (10, 'Taylor', 12567890);