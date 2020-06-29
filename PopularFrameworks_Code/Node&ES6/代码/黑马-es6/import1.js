import {name,age, gender, say} from "./export1"

console.log(name, age, gender);

//导入的变量是只读的，不可再改变其值
//name = "test";

say("hello heima");

//可以对导入的变量起别名

import {name as abc, say as hello} from "./export1"

console.log(abc);

hello("hello nodejs")