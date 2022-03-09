/* create tables */
CREATE TABLE course ( 
    id VARCHAR2(150), 
    title VARCHAR2(150) NOT NULL UNIQUE,   
    date_created DATE NOT NULL,
    CONSTRAINT course_cid_pk PRIMARY KEY (id)
);

CREATE TABLE chapter ( 
    id VARCHAR2(150),
    title VARCHAR2(150) NOT NULL,   
    chapter_number INTEGER,
    course_id VARCHAR2(150),
    CONSTRAINT chapter_chid_pk PRIMARY KEY (id)
);

CREATE TABLE page ( 
    id VARCHAR2(150),
    components VARCHAR2(4000) NOT NULL, /* temp: update to CLOB */
    title VARCHAR2(150) NOT NULL,   
    page_number INTEGER,
    chapter_id VARCHAR2(150),
    CONSTRAINT page_pid_pk PRIMARY KEY (id)
);

ALTER TABLE chapter
ADD CONSTRAINT course_cid_fk FOREIGN KEY(course_id) REFERENCES course(id)
ON DELETE CASCADE;

ALTER TABLE page
ADD CONSTRAINT page_chapter_chid_fk FOREIGN KEY(chapter_id) REFERENCES chapter(id)
ON DELETE CASCADE;

COMMIT;

/* delete data */
ALTER TABLE chapter
DROP CONSTRAINT course_cid_fk;

ALTER TABLE page
DROP CONSTRAINT page_chapter_chid_fk;

DROP TABLE course;
DROP TABLE chapter;
DROP TABLE page;
