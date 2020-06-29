//方式1
/*
export let name = "heima";
export let age = 13;
export let gender = "男";
export let say = function (str) {
    console.log(str);
};*/

//方式2；更推荐
let name = "heima";
let age = 13;
let gender = "男";
let say = function (str) {
    console.log(str);
};

export {name, age, gender, say}
