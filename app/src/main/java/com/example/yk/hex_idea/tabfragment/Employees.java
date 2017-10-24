package com.example.yk.hex_idea.tabfragment;

import com.example.yk.hex_idea.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pasi on 20/10/16.
 */

public class Employees {
    // employees list
    private List<Employee> employeeList;

    // just fake some data
    public void initializeData() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jerry Elliott","Account Coordinator","jelliott0@miitbeian.gov.cn","47-(691)872-9398", R.drawable.employee01));
        employeeList.add(new Employee("Angela Porter","Senior Sales Associate","aporter1@typepad.com","60-(429)569-1985",R.drawable.employee02));
        }

    // return employee list
    public List<Employee> getEmployees() {
        return employeeList;
    }

    // just add a new employee, called from fab
    public void addEmployee() {
        employeeList.add(new Employee("Jerry Elliott","Account Coordinator","jelliott0@miitbeian.gov.cn","47-(691)872-9398",R.drawable.employee01));
    }
}
