package com.meng.test;

import org.junit.Test;

import java.util.List;

public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao = new CustomerDAO();

        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);
    }

    @Test
    public void test2(){
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.add(new Sudent());
        List<Sudent> list = studentDAO.getForList(10);


    }


}
