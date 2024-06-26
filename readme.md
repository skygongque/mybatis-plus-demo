# springboot mybatis-plus学习
- 增删改查接口速通
  - 配置maven坐标`mybatis-plus-spring-boot3-starter`
  - 建立数据库表（db.sql）、配置数据源（application.properties或yml），实体类
  - mapper继承BaseMapper指定泛型为对应实体类，如`BaseMapper<User>`，这样mapper层的单表的增删改查接口就都有了，基本不用自己写
  - service继承IService指定泛型为对应实体类，`IService<User>`,service的实现了继承ServiceImpl，如`extends ServiceImpl<UserMapper, User> implements UserService`
  - controller调用service完成数据增删改查
- 知识点
  - validation做参数校验如非空校验，正则校验等，添加全局异常处理`GlobalExceptionHandler`
  - mybatis-plus的QueryWrapper方便做数据筛选，排序等
  - mybatis-plus的分页，需要配置拦截器Interceptor，`MybatisPlusConfig`
  - 封装CommonResult<T> 统一接口数据返回格式


python测试接口示例
```python
import requests
import json
from pprint import pprint

# 测试新增用户
def test_add(age):
    url = "http://localhost:8080/user/add"
    payload = json.dumps({
    "name": "小明",
    "age": age
    })
    headers = {
    'content-type': 'application/json'
    }
    response = requests.request("POST", url, headers=headers, data=payload)
    print(response.text)


# 测试列表
def test_list(params):
    url = 'http://localhost:8080/user/page'
    response = requests.get(url,params)
    pprint(response.json())


# 测试删除用户
def test_delete(id):
    url = "http://localhost:8080/user/delete"
    payload = json.dumps([{'id':id}])
    headers = {
    'content-type': 'application/json'
    }
    response = requests.request("POST", url, headers=headers, data=payload)
    print(response.text)


# 测试更新用户
def test_edit(user):
    url = "http://localhost:8080/user/edit"
    payload = json.dumps(user)
    headers = {
    'content-type': 'application/json'
    }
    response = requests.request("POST", url, headers=headers, data=payload)
    print(response.text)


def test_detail(id):
    url = "http://localhost:8080/user/detail"
    headers = {
    'content-type': 'application/json'
    }
    response = requests.get(url, headers=headers, params={'id':id})
    print(response.text)

if __name__ == "__main__":
    for i in range(100):
        test_add(i)
    test_list({'name':"小",'current':2,'size':5})
    test_delete(10)
    test_edit({'id':5,'name':"小小小可爱","age":18})
    test_detail(5)

```