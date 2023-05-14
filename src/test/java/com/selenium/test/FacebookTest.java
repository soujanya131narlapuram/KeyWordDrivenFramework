package com.selenium.test;

import com.selenium.BaseClass.BaseClass;
import com.selenium.keyword.KeywordEngine;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookTest extends BaseClass {

      @Test
    public void keyWordDrivenTest() throws InterruptedException {
    KeywordEngine keywordDriven=new KeywordEngine();
    keywordDriven.startExecution();


    }


}
