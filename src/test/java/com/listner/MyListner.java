package com.listner;

import com.utility.Utility;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class MyListner implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            Utility.takeScreenShot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
