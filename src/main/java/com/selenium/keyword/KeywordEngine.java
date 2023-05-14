package com.selenium.keyword;

import com.selenium.BaseClass.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KeywordEngine extends BaseClass
{
    public Workbook book;
    public Sheet sheet;
    public String scenarioSheet="C:\\Users\\ANIL\\AppData\\Local\\Temp\\KeyWordDrivenFramework\\src\\main\\resources\\Keyword.xlsx";
    public void startExecution() throws InterruptedException
    {
        FileInputStream file;
        try {
            file = new FileInputStream(scenarioSheet);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet("Sheet1");

        int k = 0;
        for (int i = 0; i < sheet.getLastRowNum(); i++)
        {
            String locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
            String locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
            String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
            String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
            switch (action) {
                case "open browser":
                                       setUp();
                                        break;
                case "enter url":
                                      driver.get(value);
                                      break;

                case "quit":
                                       tearDown();
                                       break;
                default:
                                       break;
            }
            switch (locatorType)
            {
                case "id":
                     WebElement ele = driver.findElement(By.id(locatorValue));
                     if (action.equalsIgnoreCase("sendkeys")) {
                        ele.sendKeys(value);
                    } else if (action.equalsIgnoreCase("click")) {
                        ele.click();
                    } else if (action.equalsIgnoreCase("isDisplayed")) {
                        ele.isDisplayed();
                    }
                    locatorType = null;
                    break;

                case "xpath":
                    ele = driver.findElement(By.xpath(locatorValue));
                    if (action.equalsIgnoreCase("sendkeys")) {
                        ele.sendKeys(value);
                    } else if (action.equalsIgnoreCase("click")) {
                        ele.click();
                    } else if (action.equalsIgnoreCase("isDisplayed")) {
                        ele.isDisplayed();
                    }
                    locatorType = null;
                    break;
                default:
                                break;
            }
        }
    }}


