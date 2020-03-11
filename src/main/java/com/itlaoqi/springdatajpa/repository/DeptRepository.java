package com.itlaoqi.springdatajpa.repository;

import com.itlaoqi.springdatajpa.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository 是Spring Boot 为我们提供的简化类，默认提供了增删改查方法
//我们只需要定义Reporisotry接口就可以了。在SB启动的时候会自动帮我们生成具体的实现类，来实现CRUD方法
//Dept,Integer 使用JpaRepository需要传入实体类及主键的类型
public interface DeptRepository extends JpaRepository<Dept,Integer> {
    //selet * from dept where dname = ...
    //public List<Dept> findByDnameAndLocation(String dname , String location);
    //select * from dept where deptno <= ? and dname like '%..%' order by dname asc
    //public List<Dept> findByDeptnoLessThanEqualsAndDnameContainingOrderByDname(String deptno , String dname);
    //JPQL  java persistence query language 持久化查询语言
    //类SQL语言，从SQL转为JPQL只需要注意一下几点
    //1.大多数情况下将* 替换为别名
    //2.表名改为类名
    //3.字段名改为属性名
    //select * from dept d where d.dname = ? order by deptno desc
    //:dn是命名参数，其本质就是一个占位符，命名参数的格式为  :参数名
    @Query("select d from Dept d where d.dname = :dn order by deptno desc")
    //将dname参数的值带入到:dn中
    public List<Dept> findDepts(@Param("dn") String dname);


}
