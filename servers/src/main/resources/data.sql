INSERT IGNORE INTO questions
VALUES (1, "관계형 모델이란 무엇인가?");

INSERT IGNORE INTO answers_without_word
VALUES (1, 1, 1, "관계형 모델은 실제 세계의 데이터를");

INSERT IGNORE INTO answers_with_word
VALUES (1, 1, 1, 2, "라는 개념을 사용해 구현한 데이터 모델이다.");
INSERT IGNORE INTO answers_with_word
VALUES (2, 1, 2, 3, "단위로 다양한 연산을 사용해 처리를 수행하는 데이터 모델이다.");
INSERT IGNORE INTO answers_with_word
VALUES (3, 1, 3, 4, "을 사용한 연산을 수행하므로");
INSERT IGNORE INTO answers_with_word
VALUES (4, 1, 4, 5, "이라고 부른다.");

INSERT IGNORE INTO words
VALUES (1, 1, "관계");
INSERT IGNORE INTO words
VALUES (2, 2, "릴레이션");
INSERT IGNORE INTO words
VALUES (3, 3, "릴레이션");
INSERT IGNORE INTO words
VALUES (4, 4, "관계형 모델");
