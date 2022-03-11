/* ID format CR100-CH100-PG100 */

/* insert data */
INSERT INTO course VALUES('CJ100', 'Core Java', SYSDATE);
INSERT INTO chapter VALUES('CJ100CH100', 'Introduction', 1, 'CJ100');
INSERT INTO page VALUES('CJ100CH100PG1', '<p>welcome</p>', 'section 1: history', 1,'CJ100CH100');
COMMIT;
/* queries */
SELECT * FROM course;
SELECT * FROM chapter;
SELECT * FROM page;
SELECT * FROM course, chapter, page;

SELECT * FROM ((course INNER JOIN chapter ON course.id = chapter.course_id) INNER JOIN page ON chapter.id = page.chapter_id);

/* delete records */
DELETE FROM course c WHERE c.id = 'CJ100';
DELETE FROM chapter ch WHERE ch.id = 'CJ100CH100';
DELETE FROM page p WHERE p.id = 'CJ100CH100PG1';