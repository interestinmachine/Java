
-- 使⽤数据数据
use springtransaction;
-- 创建表[⽤户表]
drop table if exists userinfo;
create table userinfo(
                         id int primary key auto_increment,
                         username varchar(100) not null,
                         password varchar(32) not null,
                         photo varchar(500) default '',
                         createtime datetime default now(),
                         updatetime datetime default now(),
                         `state` int default 1
);
-- 创建⽂章表
drop table if exists articleinfo;
create table articleinfo(
                            id int primary key auto_increment,
                            title varchar(100) not null,
                            content text not null,
                            createtime datetime default now(),
                            updatetime datetime default now(),
                            uid int not null,
                            rcount int not null default 1,
                            `state` int default 1
);
-- 创建视频表
drop table if exists videoinfo;
create table videoinfo(
                          vid int primary key,
                          `title` varchar(250),
                          `url` varchar(1000),
                          createtime datetime default now(),
                          updatetime datetime default now(),
                          uid int
);
-- 添加⼀个⽤户信息
INSERT INTO `springtransaction`.`userinfo` (`id`, `username`, `password`, `photo`,
                                  `createtime`, `updatetime`, `state`) VALUES
    (1, 'admin', 'admin', '', '2021-12-06 17:10:48', '2021-12-06 17:10:48',
     1);
-- ⽂章添加测试数据
insert into articleinfo(title,content,uid)
values('Java','Java正⽂',1);
-- 添加视频
insert into videoinfo(vid,title,url,uid) values(1,'java
title','http://www.baidu.com',1);
