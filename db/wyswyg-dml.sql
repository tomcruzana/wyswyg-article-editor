/* ID format CR100-CH100-PG100 */

/* insert data */
INSERT INTO course VALUES('CJ100', 'Core Java', SYSDATE,  'CJ100CH100');
INSERT INTO chapter VALUES('CJ100CH100', 'Introduction', 1,  'CJ100CH100PG1', 'CJ100');
INSERT INTO page VALUES('CJ100CH100PG1', '<p>welcome</p>', 'section 1: history', 1,'CJ100CH100');

INSERT INTO course VALUES('CJ100', 'Core Java', SYSDATE,  NULL);
INSERT INTO chapter VALUES('CJ100CH100', 'Introduction', 1,  NULL, 'CJ100');
INSERT INTO page VALUES('CJ100CH100PG1', '<p>welcome</p>', 'section 1: history', 1,'CJ100CH100');

UPDATE course
SET page_id = 'CJ100CH100'
WHERE id = 'CJ100';

UPDATE chapter
SET page_id = 'CJ100CH100PG1'
WHERE id = 'CJ100CH100';

/* queries */
SELECT * FROM course;
SELECT * FROM chapter;
SELECT * FROM page;
SELECT * FROM course, chapter, page;

SELECT * FROM ((course INNER JOIN chapter ON course.chapter_id = chapter.id) INNER JOIN page ON chapter.page_id = page.id);