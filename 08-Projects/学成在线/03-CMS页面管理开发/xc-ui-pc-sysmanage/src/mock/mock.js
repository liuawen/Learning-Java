import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { LoginUsers, Users } from './data/user';
import { Course } from './data/course';
let _Users = Users;
let _Course = Course;
export default {
  /**
   * mock bootstrap
   */
  bootstrap() {
    let mock = new MockAdapter(axios);

    // mock success request
    mock.onGet('/success').reply(200, {
      msg: 'success'
    });

    // mock error request
    mock.onGet('/error').reply(500, {
      msg: 'failure'
    });

    //登录
    mock.onPost('/login').reply(config => {
      let {username, password} = JSON.parse(config.data);
      return new Promise((resolve, reject) => {
        let user = null;
        setTimeout(() => {
          let hasUser = LoginUsers.some(u => {
            if (u.username === username && u.password === password) {
              user = JSON.parse(JSON.stringify(u));
              user.password = undefined;
              return true;
            }
          });

          if (hasUser) {
            resolve([200, { code: 200, msg: '请求成功', user }]);
          } else {
            resolve([200, { code: 500, msg: '账号或密码错误' }]);
          }
        }, 1000);
      });
    });

    //课程列表
    // mock.onGet('/course/list').reply(config => {
    //   //let {name} = config.params;
    //   let mockCourses = _Course.filter(course => {
    //     if (name && course.name.indexOf(name) == -1) return false;
    //     return true;
    //   });
    //   return new Promise((resolve, reject) => {
    //     setTimeout(() => {
    //       resolve([200, {
    //         total: total,
    //         courses: mockCourses
    //       }]);
    //     }, 1000);
    //   });
    // });
    mock.onGet('/course/list').reply(config => {
      // console.log(config.params);
      let {page, name} = config.params;
      let mockCourses = _Course.filter(course => {
        if (name && course.name.indexOf(name) == -1) return false;
        return true;
      });
      let total = mockCourses.length;
      // console.log("total="+total);
      mockCourses = mockCourses.filter((u, index) => index < 20 * page && index >= 20 * (page - 1));
      // console.log("mockCourses="+mockCourses);
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            courses: mockCourses
          }]);
        }, 200);
      });
    });
    //新增课程
    mock.onPost('/course/add').reply(config => {
      var data = JSON.parse(config.data);
      //console.log(data);
      // console.log(config.data.params);
      let { name, author, createtime,status } = data.params;
      _Course.push({
        name: name,
        author: author,
        createtime: createtime,
        status: status
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '新增成功'
          }]);
        }, 500);
      });
    });
    //根据id查询课程
    mock.onGet('/course/get').reply(config => {
      console.log("fdsfdsfds")
      console.log(config)

      let { id } = config.params;
      console.log("id="+id)
      let mockCourses = _Course.filter(course => {
        if (id && course.id.indexOf(id) == -1) return false;
        return true;
      });
      let total = mockCourses.length;
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            courses: mockCourses
          }]);
        }, 200);
      });
    });
    //更新课程
    mock.onPost('/course/edit').reply(config => {
      var data = JSON.parse(config.data);
      //console.log(data);
      // console.log(config.data.params);
      let { id,name, author, createtime,status } = data.params;
      _Course.some(u => {
        if (u.id === id) {
          u.name = name;
          u.author = author;
          u.createtime = createtime;
          u.status = status;
          return true;
        }
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '编辑成功'
          }]);
        }, 500);
      });
    });
    //删除课程
    mock.onGet('/course/del').reply(config => {
      console.log(config)
      let { id } = config.params;
      _Course = _Course.filter(u => u.id !== id);
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '删除成功'
          }]);
        }, 500);
      });
    });
    //获取用户列表
    mock.onGet('/user/list').reply(config => {
      let {name} = config.params;
      let mockUsers = _Users.filter(user => {
        if (name && user.name.indexOf(name) == -1) return false;
        return true;
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            users: mockUsers
          }]);
        }, 1000);
      });
    });

    //获取用户列表（分页）
    mock.onGet('/user/listpage').reply(config => {
      let {page, name} = config.params;
      let mockUsers = _Users.filter(user => {
        if (name && user.name.indexOf(name) == -1) return false;
        return true;
      });
      let total = mockUsers.length;
      mockUsers = mockUsers.filter((u, index) => index < 20 * page && index >= 20 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            users: mockUsers
          }]);
        }, 1000);
      });
    });

    //删除用户
    mock.onGet('/user/remove').reply(config => {
      let { id } = config.params;
      _Users = _Users.filter(u => u.id !== id);
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '删除成功'
          }]);
        }, 500);
      });
    });

    //批量删除用户
    mock.onGet('/user/batchremove').reply(config => {
      let { ids } = config.params;
      ids = ids.split(',');
      _Users = _Users.filter(u => !ids.includes(u.id));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '删除成功'
          }]);
        }, 500);
      });
    });

    //编辑用户
    mock.onGet('/user/edit').reply(config => {
      let { id, name, addr, age, birth, sex } = config.params;
      _Users.some(u => {
        if (u.id === id) {
          u.name = name;
          u.addr = addr;
          u.age = age;
          u.birth = birth;
          u.sex = sex;
          return true;
        }
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '编辑成功'
          }]);
        }, 500);
      });
    });

    //新增用户
    mock.onGet('/user/add').reply(config => {
      let { name, addr, age, birth, sex } = config.params;
      _Users.push({
        name: name,
        addr: addr,
        age: age,
        birth: birth,
        sex: sex
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            code: 200,
            msg: '新增成功'
          }]);
        }, 500);
      });
    });

  }
};
