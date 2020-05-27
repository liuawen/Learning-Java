-- 创建数据库day01_test05db
CREATE DATABASE day01_test05db;

-- 指定使用哪个数据库
USE day01_test05db;

-- 在market中创建数据表customers，
CREATE TABLE pet(
	`name` VARCHAR(20),
	`owner` VARCHAR(20),
	species VARCHAR(20),
	sex CHAR(1),
	birth	YEAR,
	death YEAR
);
-- 3、添加数据
INSERT INTO pet VALUES('Fluffy','harold','Cat','f','2013','2010'); 				
INSERT INTO pet(`name`,`owner`,species,sex,Birth) VALUES('Claws','gwen','Cat','m','2014'); 
INSERT INTO pet(`name`,species,sex,Birth) VALUES('Buffy','Dog','f','2009');
INSERT INTO pet(`name`,`owner`,species,sex,Birth) VALUES('Fang','benny','Dog','m','2000');
INSERT INTO pet VALUES('bowser','diane','Dog','m','2003','2009');
INSERT INTO pet(`name`,species,sex,birth) VALUES('Chirpy','Bird','f','2008');

#4、添加字段主人的生日owner_birth。
ALTER TABLE pet ADD COLUMN owner_birth DATE;

#5、将名称为Claws的猫的主人改为kevin
UPDATE pet SET `owner`='kevin' WHERE `name`='Claws' AND species='Cat';

#6、将没有死的狗的主人改为duck
UPDATE pet SET `owner`='duck' WHERE species='Dog' AND death IS NULL;

#7、查询没有主人的宠物的名字；
SELECT `name` FROM pet WHERE `owner` IS NULL;

#8、查询已经死了的cat的姓名，主人，以及去世时间；
SELECT `name`,`owner`,death FROM pet WHERE death IS NOT NULL;

#9、删除已经死亡的狗
DELETE FROM pet WHERE death IS NOT NULL;

#10、查询所有宠物信息
SELECT * FROM pet;
