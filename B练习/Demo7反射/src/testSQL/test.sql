create table goods (
    goods_id int,
    goods_name varchar(50),
    unitprice double(3,1),
    category varchar(50),
    provider varchar(50)
);

insert into student values (1000,'zhangsan',18,98.9);

create table student (
    id int,
    name varchar(20),
    email varchar(20)
);

insert into student values (1001,"张三","299908@"),(1002,"李思思","1232131@");
select id,email from student;
select email,id from student;

create table exam_score (
    id int(11),
    name varchar(20),
    chinese decimal(3,1),
    math decimal(3,1),
    english decimal(3,1)
);

insert into exam_score values
    (1,"唐三藏",67,98,56),
    (2,"孙悟空",87.5,78,77),
    (3,"猪悟能",88,98.5,90),
    (4,"曹孟德",82,84,67),
    (5,"刘玄德",55.5,85,45),
    (6,"孙权",70,73,78.5),
    (7,"宋公明",75,65,30)
;

create table class(class_id int primary key auto_increment,name varchar(50));
create table student(studentId int primary key auto_increment,name varchar(20),
classId int, foreign key(classId) references class(class_id));

insert into class values (1,"java100"),(2,"java101"),(3,"java102");
insert into student values(null,'张三',1);