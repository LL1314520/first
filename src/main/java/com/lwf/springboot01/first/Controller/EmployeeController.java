package com.lwf.springboot01.first.Controller;

import com.lwf.springboot01.first.dao.DepartmentDao;
import com.lwf.springboot01.first.dao.EmployeeDao;
import com.lwf.springboot01.first.entities.Department;
import com.lwf.springboot01.first.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        final Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
}
