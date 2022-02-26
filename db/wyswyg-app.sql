CREATE TABLE course ( 
    id INTEGER, 
    title VARCHAR2(150) NOT NULL,   
    date_created DATE NOT NULL,
    CONSTRAINT course_cid_pk PRIMARY KEY (id)
);

INSERT INTO course VALUES(100, 'Java', SYSDATE );

UPDATE course
SET title = 'Core Java'
WHERE id = 100;

SELECT * FROM course;

SELECT * FROM course WHERE id = 400;

DELETE FROM course WHERE id = 200;

DELETE FROM course;