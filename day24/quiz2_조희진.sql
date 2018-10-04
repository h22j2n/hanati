--�� ���º� - ���ѽð� 60��(bangry313@naver.com �̸��� ����) 
--1. 'London'���� �ٹ��ϴ� ��� ����� �����ȣ(employee_id),  
--����̸�(last_name), �����̸�(job_title), �μ��̸�(department_name),  
--�μ���ġ(city)�� ��ȸ�Ͻÿ�. 
--  -���� ���̺� : employees, jobs, departments, locations 
SELECT e.last_name "����̸�", 
       j.job_title "�����̸�", 
       d.department_name "�μ��̸�", 
       l.city "�μ���ġ" 
FROM   jobs j 
       join employees e 
         ON j.job_id = e.job_id 
       join departments d 
         ON e.department_id = d.department_id 
       join locations l 
         ON d.location_id = l.location_id; 

--2. ����̸�(last_name)�� 'A'�� ���Ե� �����  
--�̸�(last_name)�� �μ���(department_name)�� ��ȸ�Ͻÿ�. 
SELECT e.last_name "�̸�", 
       d.department_name "�μ���" 
FROM   employees e 
       join departments d 
         ON e.last_name LIKE '%A%'; 

--3. �޿�(salary)�� 3000���� 5000 ������ ����� ��ȣ, �̸�,  
--�޿�, �μ����� ��ȸ�϶�. 
SELECT e.employee_id "����� ��ȣ",  
       e.last_name "�̸�", 
       e.salary "�޿�", 
       d.department_name "�μ���" 
FROM   employees e 
       join departments d 
         ON e.salary BETWEEN 3000 AND 5000; 

--4. 'Accounting' �μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ��ȸ�϶�. 
--   - �Ի��� ��� ���� - 2007�� 05�� 21��(������) 
SELECT e.last_name "����� �̸�", 
       To_char(e.hire_date, 'YYYY') 
       ||'�� ' 
       || To_char(e.hire_date, 'MM') 
       ||'�� ' 
       ||To_char(e.hire_date, 'DD') 
       ||'�� (' 
       ||To_char(e.hire_date, 'DAY') 
       ||')' "�Ի���"
FROM   employees e 
       join departments d 
         ON d.department_name = 'Accounting'; 

--5. 'Landry(last_name)'�� ���� �μ��� �ٹ��ϴ� ����� ��� ��� ������ ��ȸ�϶�. 
--    (��. Landry�� ����) 
SELECT * 
FROM   employees 
WHERE  department_id = (SELECT department_id 
                        FROM   employees 
                        WHERE  Lower(last_name) = 'landry') 
       AND Lower(last_name) != 'landry'; 

--6. 'Lee(last_name)'���� �ʰ� �Ի��� ����� �̸��� �Ի��� ��ȸ�϶�. 
SELECT last_name "�̸�", 
       hire_date "�Ի���" 
FROM   employees 
WHERE  To_char(hire_date, 'YYYYMMDD') > (SELECT To_char(hire_date, 'YYYYMMDD') 
                                         FROM   employees 
                                         WHERE  Lower(last_name) = 'lee'); 

--7. 'Lee(last_name)'���� ���� �޿��� �޴� ����� �̸��� �޿��� ��ȸ�϶�. 
SELECT last_name "�̸�", 
       salary "�޿�"
FROM   employees 
WHERE  salary > (SELECT salary 
                 FROM   employees 
                 WHERE  Lower(last_name) = 'lee'); 

--8. 50�� �μ��� ������ ���� �޿��� �޴� ����� �̸��� �޿��� ��ȸ�϶�. 
SELECT last_name "�̸�", 
       salary "�޿�"
FROM   employees 
WHERE  salary IN (SELECT salary 
                  FROM   employees 
                  WHERE  department_id = 50); 

--9. ��� ����� ��ձ޿����� ���� �޿��� �޴� �������  
--���, �̸�, �޿��� ��ȸ�϶�. 
SELECT employee_id "���", 
       last_name "�̸�", 
       salary "�޿�"
FROM   employees 
WHERE  salary > (SELECT Avg(salary) 
                 FROM   employees); 

--10.�̸�(last_name)��  'T'�� ���ԵǾ� �ִ� �����  
--������ �μ��� �ٹ��ϴ� ����� ��ȣ, �̸��� ��ȸ�϶�. 
SELECT employee_id "���", 
       last_name "�̸�"
FROM   employees 
WHERE  department_id IN (SELECT department_id 
                         FROM   employees 
                         WHERE  last_name LIKE '%T%'); 

--11.10�� �μ� �ִ�޿��ڿ� ������ �޿��� �޴�  
--����� ��ȣ, �̸�, �޿��� ��ȸ�϶�. 
SELECT employee_id "���", 
       last_name "�̸�", 
       salary "�޿�"
FROM   employees 
WHERE  salary IN (SELECT Max(salary) 
                  FROM   employees 
                  WHERE  department_id = 10); 

--12. 10���μ��� �ٹ��ϴ� ����� �̸��� �μ��� ��ȸ�϶�. 
SELECT e.last_name "�̸�", 
       d.department_name "�μ���" 
FROM   employees e 
       join departments d 
         ON e.department_id = d.department_id 
WHERE  d.department_id = 10; 

--13. 'IT_PROG' ������ �ִ� �޿��ں��� ���� �޿��� �޴�  
--��� ����(�μ���ȣ, �����ȣ, �̸�, �޿�)�� ����϶�. 
SELECT department_id "�μ���ȣ", 
       employee_id "�����ȣ", 
       last_name "�̸�", 
       salary "�޿�"
FROM   employees 
WHERE  salary > ALL (SELECT salary 
                     FROM   employees 
                     WHERE  job_id = 'IT_PROG'); 

--14. ��� �޿����� ���� �޿��� �ް� �̸��� u�� ���Ե� �����  
--���� �μ��� �ٹ��ϴ� ��� ����� ��� ����(�����ȣ, �̸�, �޿�)��  
--��ȸ�϶�. 
SELECT employee_id "�����ȣ", 
       last_name "�̸�", 
       salary "�޿�"
FROM   employees 
WHERE  salary > (SELECT Avg(salary) 
                 FROM   employees) 
       AND department_id IN (SELECT department_id 
                             FROM   employees 
                             WHERE  last_name LIKE '%u%'); 

--15. ��ձ޿��� ���� ���� ������ȣ(job_id)�� ��ձ޿��� ����϶� 
--    ��) ������ȣ  ��ձ޿� 
--       ------------------- 
--        CLERK      2300     
SELECT * 
FROM   (SELECT job_id, 
               Avg(salary) 
        FROM   employees 
        GROUP  BY job_id 
        ORDER  BY Avg(salary) desc) 
WHERE  ROWNUM = 1; 