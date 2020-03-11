package com.itlaoqi.springdatajpa.repository;

import com.itlaoqi.springdatajpa.entity.Dept;
import com.itlaoqi.springdatajpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmpRepository extends JpaRepository<Emp,Integer> {
    //select * from emp where deptno = ?
    @Query("select e from Emp e where e.dept.deptno=:dn")
    public List<Emp> findEmps(@Param("dn") Integer deptno);
}
