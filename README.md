## 啦啦啦啦啦，富贵同学又开始开坑了，出了个免费的专栏，主要给用springBoot集成第三方的插件或者功能，如果这篇专栏能帮到你，一定不要忘了点一个赞哦！！欢迎大家收藏分享
![在这里插入图片描述](https://img-blog.csdnimg.cn/385dc942abfc4a019d845055328814c1.png#pic_center)
发现有些小伙伴不知道JPA和Hibernate有什么区别，在写博客的时候看到有人说集成hibernate，结果进去一看，就是到了一个jpa的包，所以给大家科普一下这两者的区别
JPA和Hibernate之间的主要区别在于JPA是一个规范。Hibernate是Red Hat对JPA规范的实现。所以hibernate的底层也是jpa，而且springjpa项目也是spring全家桶中的一员，所以他的jar包是长这个样子的:
![在这里插入图片描述](https://img-blog.csdnimg.cn/b9ed09110af049509bbf7724933f8eb6.png)
所以今天就带大家用springboot集成jpa实现最简单的增删改查

## 第一步，导入jar包

```java
		 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
          <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

```
## 第二步，配置数据库文件

```java
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1/springbootjpa?useUnicode=true&characterEncoding=utf8&useSSL=false # 数据库连接地址
    username: root # 用户名
    password: 123456 # 密码
    driverClassName: com.mysql.jdbc.Driver # 数据库驱动
  jpa:
    show-sql: true #打印sql
```
## 第三步，编写实体类

```java
package com.wangfugui.springbootjpa.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//id自增
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private Integer age;

    @Column(name = "create_time")
    private Date createTime;


}

```
## 第四步，最关键的一步，编写dao类

```java

import com.wangfugui.springbootjpa.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, CrudRepository<User,Integer> {
}

```
我们继承`JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, CrudRepository<User,Integer>` 就可以实现最基础的增删改查了
我觉得把所有的类写出来没有必要了，看到有些人写博客喜欢把所有的类都贴上去，觉得很杂，所以大家可以访问我的仓库地址，所有的源码都在里面

[https://gitee.com/WangFuGui-Ma/spring-boot-jpa](https://gitee.com/WangFuGui-Ma/spring-boot-jpa)

## 第五步，增删改查

```java
    @PostMapping("/insert")
    public String insert(@RequestBody User user) {
        return userService.insert(user);

    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/getOne")
    public User getOne(@RequestParam Integer id) {
        return userService.getOne(id);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
```
好了，这就是最基本的jpa的功能，如果大家想继续了解分页查询等高端操作，请给富贵同学点赞，后期会考虑出个jpa使用高级篇，最近都在日更，有点顶不住了，而且又没有关注，心都凉了，所以
![在这里插入图片描述](https://img-blog.csdnimg.cn/a866736dfb41420f8d8a8484d1e9abb7.jpg?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5o6J5aS05Y-R55qE546L5a-M6LS1,size_10,color_FFFFFF,t_70,g_se,x_16#pic_center)