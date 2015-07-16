CREATE TABLE person (
 id int NOT NULL AUTO_INCREMENT,
 name VARCHAR(25),
 sex VARCHAR(5),
 email VARCHAR(40),
 age int,
 PRIMARY KEY(id)
);
insert into person (name, sex, email, age) values ("张明", "女", "1234@qq.com", 23);
insert into person (name, sex, email, age) values ("李华", "男", "8934@qq.com", 73);
insert into person (name, sex, email, age) values ("张孔明", "男", "9999@qq.com", 13);
