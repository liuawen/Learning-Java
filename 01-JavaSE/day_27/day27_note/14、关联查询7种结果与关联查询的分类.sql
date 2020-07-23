/*
关联查询的结果有七种情况：
（1）A∩B
（2）A
（3）A - A ∩ B
（4）B
（5）B - A ∩ B
（6）A ∪ B
（7）A ∪ B - A ∩ B

如何实现这些结果？
1、内连接：inner join 
	（1）A∩B
2、外连接
（1）左外连：left join
	（2）A
	（3）A - A ∩ B
（2）右外连接：right join
	（4）B
	（5）B - A ∩ B
（3）全外连接：full join
	但是不直接支持全外连接，但是可以使用union（合并）结果来实现以下两种结果
	（6）A ∪ B		用  （2）A  union（合并） （4）B
	（7）A ∪ B - A ∩ B	用  （3）A - A ∩ B  union（合并）（5）B - A ∩ B
*/