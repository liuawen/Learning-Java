

ALTER TABLE departments
DISABLE CONSTRAINT DEPT_MGR_FK;

ALTER TABLE job_history
DISABLE CONSTRAINT JHIST_EMP_FK;

DROP TRIGGER secure_employees;

DROP TRIGGER update_job_history;

DROP PROCEDURE add_job_history;

DROP PROCEDURE secure_dml;

DELETE FROM employees
WHERE manager_id IN (108, 114, 120, 121, 122, 123, 145, 146, 147, 148);

DELETE FROM employees
WHERE employee_id IN (114, 120, 121, 122, 123, 145, 146, 147, 148, 
                      196, 197, 198, 199, 105, 106, 108, 175, 177, 
                      179, 203, 204);

DELETE FROM locations
WHERE location_id NOT IN 
  (SELECT DISTINCT location_id
   FROM departments);

DELETE FROM countries
WHERE country_id NOT IN
  (SELECT country_id
   FROM locations);

DELETE FROM jobs
WHERE job_id NOT IN
  (SELECT job_id
   FROM employees);

DELETE FROM departments
WHERE department_id NOT IN 
  (SELECT DISTINCT department_id
   FROM employees
   WHERE department_id IS NOT NULL);

UPDATE departments
SET manager_id = 124
WHERE department_id = 50;

UPDATE departments
SET manager_id = 149
WHERE department_id = 80;

DELETE FROM locations
WHERE location_id IN (2700, 2400);

UPDATE locations
SET street_address = '460 Bloor St. W.', 
    postal_code = 'ON M5S 1X8'
WHERE location_id = 1800;

ALTER TABLE departments
ENABLE CONSTRAINT DEPT_MGR_FK;

CREATE TABLE job_grades
(grade_level VARCHAR2(3),
 lowest_sal  NUMBER,
 highest_sal NUMBER);

INSERT INTO job_grades
VALUES ('A', 1000, 2999);

INSERT INTO job_grades
VALUES ('B', 3000, 5999);

INSERT INTO job_grades
VALUES('C', 6000, 9999);

INSERT INTO job_grades
VALUES('D', 10000, 14999);

INSERT INTO job_grades
VALUES('E', 15000, 24999);

INSERT INTO job_grades
VALUES('F', 25000, 40000);

INSERT INTO departments VALUES 
        ( 190 
        , 'Contracting'
        , NULL
        , 1700
        );

COMMIT;

