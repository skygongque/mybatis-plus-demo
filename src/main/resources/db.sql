create database if not exists mybatis;
create table user (
                      `id` INT key AUTO_INCREMENT,
                      `name` VARCHAR(100) NOT NULL,
                      `age` int
)