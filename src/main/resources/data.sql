insert into course(id,name,created_date,last_updated_date) values(10001,'Matemática Básica',current_date(),current_date())
insert into course(id,name,created_date,last_updated_date) values(10002,'Linguagens',current_date(),current_date())
insert into course(id,name,created_date,last_updated_date) values(10003,'Física',current_date(),current_date())

insert into passport(id, number) values(30001,'A123')
insert into passport(id, number) values(30002,'B456')
insert into passport(id, number) values(30003,'C789')

insert into student(id, name, passport_id, active) values(20001,'Joao',30001,true)
insert into student(id, name, passport_id, active) values(20002,'Gomes',30002,true)
insert into student(id, name, passport_id, active) values(20003,'Silva',30003,true)

insert into review(id, description, rating, course_id) values(40001,'Muito bom','4.5',10001)
insert into review(id, description, rating, course_id) values(40002,'Mais ou menos - faltou algumas coisas importantes','2.5',10003)
insert into review(id, description, rating, course_id) values(40003,'Simples e objetivo','4',10001)

insert into student_course(student_id, course_id) values(20001,10001)
insert into student_course(student_id, course_id) values(20002,10001)
insert into student_course(student_id, course_id) values(20003,10001)

insert into student_course(student_id, course_id) values(20002,10003)
insert into student_course(student_id, course_id) values(20003,10003)