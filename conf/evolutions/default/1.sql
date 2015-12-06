# Creating ranking table

# --- !Ups

CREATE TABLE ranking (
    id SERIAL NOT NULL UNIQUE,
    player TEXT NOT NULL UNIQUE,
    points INTEGER NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE ranking;
