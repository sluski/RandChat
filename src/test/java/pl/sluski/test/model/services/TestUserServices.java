/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sluski.test.model.services;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import model.pojo.User;
import model.services.UserServices;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sluski
 */
public class TestUserServices {
    
    private static UserServices userServices;
    private static User user;
    
    public TestUserServices() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        userServices = new UserServices();
        HttpServletRequest request;
        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void createUser_allParameters_addUser(){
    }
}
