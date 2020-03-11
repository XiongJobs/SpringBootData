package com.itlaoqi.springdatajpa.controller;

import com.itlaoqi.springdatajpa.entity.Dept;
import com.itlaoqi.springdatajpa.repository.DeptRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptRepository deptRepository = null;

    @GetMapping("/{id}")
    //将路径中符合要求的部分，注入到对应的参数中
    //这种形式称为“路径变量”
    @ResponseBody
    public Dept findById(@PathVariable("id") Integer id){
        //Optional是实体类的包装类，用于判断对象是否存在
       Optional<Dept> op =  deptRepository.findById(id);
       //op.isPresent();//如果传入的id有对应的数据返回true，否则返回false
        Dept dept = null;
        if(op.isPresent() == true){
            dept = op.get();//获取到对应的实体类
        }
        return dept;
    }
    @GetMapping("/create")
    @ResponseBody
    public Dept create(){
        Dept d = new Dept();
        d.setDname("Tranning");
        d.setLocation("New York!");
        deptRepository.save(d);
        //一旦保存后，JPA会自动将生成的主键回填到id中
        return d;
    }

    @GetMapping("/update")
    @ResponseBody
    public Dept update(){
        Dept d = deptRepository.findById(30).get();
        d.setDname("(" + d.getDname() + ")");
        //在保存的时候，都是save方法，没有id的时候时新增，有id的时候就是修改
        deptRepository.save(d);
        //一旦保存后，JPA会自动将生成的主键回填到id中
        return d;
    }

    @GetMapping("/delete")
    @ResponseBody
    public Dept delete(){
        Dept d = deptRepository.findById(40).get();
        deptRepository.delete(d);
        return d;
    }
    @GetMapping("/find")
    @ResponseBody
    public List<Dept> findDepts(String dname){
        List<Dept> list = deptRepository.findDepts(dname);
        return list;
    }
}
