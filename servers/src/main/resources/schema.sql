CREATE TABLE IF NOT EXISTS questions
(
    id       INTEGER      NOT NULL AUTO_INCREMENT,
    question VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS answers_without_word
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    question_id  INTEGER      NOT NULL,
    answer_order VARCHAR(128) NOT NULL,
    answer       VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS answers_with_word
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    question_id  INTEGER      NOT NULL,
    word_id      INTEGER      NOT NULL,
    answer_order VARCHAR(128) NOT NULL,
    answer       VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS words
(
    id                   INTEGER      NOT NULL AUTO_INCREMENT,
    answers_with_word_id INTEGER      NOT NULL,
    word                 VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);
