/* 시퀀스(sequence) 생성 */
-- 테스트를 위한 테이블 생성
CREATE TABLE list(
    no   NUMBER CONSTRAINT list_no_pk PRIMARY KEY,
    name VARCHAR2(10) NOT NULL
);


CREATE SEQUENCE list_seq;
    --START WITH 1
    --INCREMENT BY 1
    --NOMAXVALUE
    --NOCYCLE
    --CACHE 20;

SELECT list_seq.CURRVAL,  list_seq.NEXTVAL
FROM dual;

INSERT INTO list
VALUES(list_seq.NEXTVAL, '김기정');


INSERT INTO list
VALUES((select max(no)+1 from list), '김기정');

select * from list;

rollback;
COMMIT;

SELECT * FROM list;


-- 직급별 뷰 생성
CREATE OR REPLACE VIEW employees_sajang_view
	AS SELECT *
       FROM EMPLOYEES;

CREATE OR REPLACE VIEW employees_bujang_view
	AS SELECT employee_id, first_name, salary
       FROM EMPLOYEES;


SELECT *
FROM employees_sajang_view;

SELECT *
FROM employees_bujang_view;



-- 인덱스에서 사용하는 가상컬럼 조회
SELECT rowid, rownum, employee_id, first_name
FROM employees;

-- 사용자 정의 인덱스 생성
CREATE INDEX emp_salary_idx
ON employees(salary);

SELECT *
FROM employees
WHERE salary >= 12000;

-- 딕셔너리로부터 인덱스 조회
SELECT *
FROM user_indexes
WHERE table_name = 'EMPLOYEES';

SELECT *
FROM user_ind_columns
WHERE table_name = 'EMPLOYEES';

-- 자동 인덱스 사용
select *
from employees
where last_name = 'James';















create table emp1
as 
select *
from employees;

insert into emp1
select * 
from emp1;

commit;

select *
from emp1
where employee_id = 107;

create index emp_id_idx
on emp1(employee_id);


