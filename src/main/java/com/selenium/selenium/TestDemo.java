package com.selenium.selenium;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @description: 测试项目
 * @author: zhangshuai
 * @create: 2018-12-29 14:09
 */
public class TestDemo {



    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");//chromedriver服务地址
        WebDriver driver =new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动

        try {

            driver.get("http://www.baidu.com");//打开指定的网站
            driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//找到kw元素的id，然后输入hello
            int i = 9/0;
            driver.findElement(By.id("su")).click(); //点击按扭

            /**
             * WebDriver自带了一个智能等待的方法。
             dr.manage().timeouts().implicitlyWait(arg0, arg1）；
             Arg0：等待的时间长度，int 类型 ；
             Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
             */

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();

            // 打印异常原因，控制台也会打印
            System.out.println("======exception reason=======" + e);
            //图片名称加时间戳
            String dateString = getDateFormat();

            // getScreenshotAs()对当前窗口进行截图
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // 需要指定图片的保存路径及文件名
            FileUtils.copyFile(srcFile, new File("D:\\seleniumErro\\" + dateString + ".png"));
            e.printStackTrace();
        }
        /**
         * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
         * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
         * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
         */
        driver.quit();//退出浏览器

    }




    public static String getDateFormat(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = sdf.format(date);
        return dateString;
    }

}
