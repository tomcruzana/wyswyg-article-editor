CREATE TABLE course ( 
    id INTEGER, 
    title VARCHAR2(150) NOT NULL,   
    date_created DATE NOT NULL,
    CONSTRAINT course_cid_pk PRIMARY KEY (id)
);

SELECT * FROM course;