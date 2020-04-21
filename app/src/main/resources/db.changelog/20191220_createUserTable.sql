CREATE TABLE uzytkownik
(
  id BIGSERIAL NOT NULL,
  firstName VARCHAR NOT NULL,
  lastName varchar NOT NULL,
  username varchar NOT NULL,
  password varchar NOT NULL,
  email varchar NOT NULL,
  birthDate date NOT NULL,
  isAdmin boolean NOT NULL,

  PRIMARY KEY (username),
  UNIQUE (username)
);