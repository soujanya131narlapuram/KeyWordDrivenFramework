
     package com.selenium.BaseClass;

     import org.apache.log4j.LogManager;
     import org.apache.log4j.Logger;
     import org.openqa.selenium.WebDriver;
     import org.openqa.selenium.chrome.ChromeDriver;
     import org.openqa.selenium.chrome.ChromeOptions;

     public class BaseClass {
     public static WebDriver driver;

     public void setUp(){
          ChromeOptions ops=new ChromeOptions();
          ops.addArguments("--disable-notifications");

          driver =new ChromeDriver(ops);

          driver.manage().window().maximize();
          driver.get("https://www.facebook.com/");


     }


     public void tearDown(){
          driver.close();
     }
}



