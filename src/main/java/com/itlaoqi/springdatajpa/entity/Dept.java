package com.itlaoqi.springdatajpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //告诉SpringBoot这是一个实体类，在SB启动的时候会加载这个类
@Table(name="dept") //Dept类对应dept表
public class Dept {
    @Id //说明下面的deptno属性是主键
    //GenerationType.IDENTITY代表使用数据库底层自动增长的数值作为主键。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Oracle数据库没有自动增长属性，而是使用Sequence序列生成
    //@SequenceGenerator() 生成Oracle主键值
    @Column(name="deptno") //deptno属性对应于deptno 字段，
    //如果属性名与字段名相同可以省略@Column,但不建议这么使用
    private Integer deptno;
    //@Column(name="dname")
    private String dname;
    @Column(name="loc")
    private String location;
    //在绝大多数情况下我们不配置onetoMang
    //1. 数据获取效率差
    //2. 会形成死循环
    /*@OneToMany
    @JoinColumn(name="deptno")
    private List<Emp> emps = new ArrayList();

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }*/

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
