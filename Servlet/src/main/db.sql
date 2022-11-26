
create database messageWall;

use messageWall;

drop table if exists message;
create table message(
    `from` varchar(100),
    `to` varchar(100),
    message varchar(100));