CREATE TABLE course ( 
    id INTEGER, 
    title VARCHAR2(150) NOT NULL UNIQUE,   
    date_created DATE NOT NULL,
    chapter_id INTEGER,
    CONSTRAINT chapter_chid_fk FOREIGN KEY(chapter_id) REFERENCES chapter(id),
    CONSTRAINT course_cid_pk PRIMARY KEY (id)
);

CREATE TABLE chapter ( 
    id INTEGER,
    title VARCHAR2(150) NOT NULL,   
    chapter_number INTEGER,
    page_id INTEGER,
    course_id INTEGER,
    CONSTRAINT chapter_chid_pk PRIMARY KEY (id),
    CONSTRAINT page_pid_fk FOREIGN KEY(page_id) REFERENCES page(id),
    CONSTRAINT course_cid_fk FOREIGN KEY(course_id) REFERENCES course(id)
);

CREATE TABLE page ( 
    id INTEGER,
    components VARCHAR2(4000) NOT NULL,
    title VARCHAR2(150) NOT NULL,   
    page_number INTEGER,
    chapter_id INTEGER,
    CONSTRAINT page_pid_pk PRIMARY KEY (id),
    CONSTRAINT chapter_chid_fk FOREIGN KEY(chapter_id) REFERENCES chapter(id)
);

INSERT INTO course VALUES(100, 'Java', SYSDATE );

UPDATE course
SET title = 'Core Java'
WHERE id = 100;

SELECT * FROM course;

SELECT * FROM course WHERE id = 400;

DELETE FROM course WHERE id = 200;

DELETE FROM course;

DROP TABLE course;