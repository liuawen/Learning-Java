import Mock from 'mockjs';

const Course = [];

for (let i = 0; i < 86; i++) {
  Course.push(Mock.mock({
    id: Mock.Random.guid(),
    name: Mock.Random.ctitle(),
    author: Mock.Random.cfirst()+'老师',
    createtime: Mock.Random.datetime(),
    'status|1':[0,1]//0未发布，1已发布

  }));
}

export { Course};
