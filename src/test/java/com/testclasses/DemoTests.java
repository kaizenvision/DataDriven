package com.testclasses;

import org.testng.annotations.Test;

public class DemoTests {
    @Test(invocationCount = 3, priority = 2)
    public void test(){
        System.out.println(" i am in invocationCount parameter");
    }

    @Test(enabled = false)
    public void test1(){
        System.out.println("in false...");
    }

    @Test(priority = -2)
    public void test2(){
        System.out.println("i am in priority -2");
    }

    @Test(groups = {"regression"})
    public void test3(){
        System.out.println("i am in regression group");
    }

    @Test(groups = {"sanity"})
    public void test4(){
        System.out.println("i am in sanity group");
    }

}
