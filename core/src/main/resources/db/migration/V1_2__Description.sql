CREATE TABLE person (
 id int NOT NULL AUTO_INCREMENT,
 name VARCHAR(25),
 sex VARCHAR(5),
 email VARCHAR(40),
 age int,
 password VARCHAR(50),
 PRIMARY KEY(id)
);
insert into person (name, sex, email, age, password) values ("张明", "女", "1234@qq.com", 23, "21232f297a57a5a743894a0e4a801fc3");
insert into person (name, sex, email, age, password) values ("李华", "男", "8934@qq.com", 73, "21232f297a57a5a743894a0e4a801fc3");
insert into person (name, sex, email, age, password) values ("张孔明", "男", "9999@qq.com", 13, "21232f297a57a5a743894a0e4a801fc3");
