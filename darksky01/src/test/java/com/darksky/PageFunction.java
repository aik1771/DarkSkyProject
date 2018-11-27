package com.darksky;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat;

public class PageFunction {
	
	public static String temperature,numericTemperature,temperatureRange;
	public static int currentTemperature,lowTemperature,highTemperature;
	
	public static void clearContent(By locator) throws InterruptedException {
        DriverWrapper.getDriver().findElement(locator).clear();
        Thread.sleep(2000);
    }
	
	public static void setValue(By locator, String text) throws InterruptedException {
        DriverWrapper.getDriver().findElement(locator).sendKeys(text);
        Thread.sleep(2000);
        
        
    }
	
	public static void clickOn(By locator) throws InterruptedException {
		Thread.sleep(2000);
		
        DriverWrapper.getDriver().findElement(locator).click();
        Thread.sleep(3000);
         
    }
	public static String getHours(int range) throws ParseException
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("h aa");
		String formattedDate = dateFormat.format(new Date()).toString();
		System.out.println("Current time is " +formattedDate);
		
		SimpleDateFormat formatter = new SimpleDateFormat("h aa");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, range);
		Date d  = cal.getTime();
		String newTime = formatter.format(d);
		newTime = newTime.replaceAll("\\s+","");
		newTime =  newTime.toLowerCase();
		System.out.println("New time is in " + range + " hours will be from now" + newTime);
		
		
		
		return newTime;
		
	 
	

		
	}
	
	public static void getAllHours()
	{
		List<WebElement> myElements = DriverWrapper.getDriver().findElements(By.xpath("//div[@class='dayDetails revealed']//div[@class='hours']//span[1]"));
	       // System.out.println("Size of List: "+myElements.size());
	        for(WebElement e : myElements) 
	        { 
	        	System.out.println("Get # " + e.getText());
	               
	        }
	}
	public static void getTemperatureRange()
	{
		
		int numberFound=1;
		String element = DriverWrapper.getDriver().findElement(By.xpath("//*[@id='week']/a[1]/span[2]")).getText();
	//	System.out.println("What's my Range " +element);
		String[] parts = element.split("˚");
		String temp1 = parts[0]; // 004
		String temp2 = parts[1]; // 034556
		
		temp2=temp2.replaceAll("\\s","");
		//System.out.println("Element 1 " +temp1 + "lenght is " +temp1.length());
	//	System.out.println("Element 2 " +temp2 + "lenght is " +temp2.length());
		

		//blah blah blah blah
		List<WebElement> myElements = DriverWrapper.getDriver().findElements(By.xpath("//span[@class='temp']"));
       // System.out.println("Size of List: "+myElements.size());
        for(WebElement e : myElements) 
        {        
            if (numberFound==3)
            {
            	
            	break;
            }
            else
            {
            String  tempFound = e.getText();
            tempFound=tempFound.replace("˚","");
            tempFound=tempFound.replaceAll("\\s","");
        	System.out.print("Found  " + numberFound + " temperature at "+tempFound+"\t");
        	numberFound+=1;
        	String tempLength=e.getText();
        //	System.out.println("String lenghth " +tempLength.length() );
        	
        	if (tempFound.contains(temp1))
        	{
        		System.out.println("Lowest temperature of " + temp1 + " match found!");
        	}
        	if (tempFound.contains(temp2))
        	{
        		System.out.println("Hightest temperature of " + temp2 + " match found!");
        	}
            }
            
        }
	}
	public static void getData() throws ParseException
	{
		int count =0;
		int range = 0;
		int match =0;
	
		
	
	
	for (int i=3;i<25;i+=2)
	{
		
		count+=1;
		range+=2;
		String name = DriverWrapper.getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='hours']//span["+i+"]")).getText();

		if (getHours(range).contains(name))
		{
			match +=1;
			System.out.println("found #" +match+ " match for time on the page " + name + " Time in number of hours function " + getHours(range));
		}
		if (count==12)
		{
			break;
		}
	
		
	  
	}
	}
	
	public static void getTemperature(By locator)
	{
		temperature=DriverWrapper.getDriver().findElement(locator).getText();
	
	    String[] numericTemperature = temperature.split("˚");
	    
	    System.out.println("Temperature is " + numericTemperature[0]);
	   
	    
		//System.out.println("Temperature is " + Integer.parseInt(numericTemperature));
		
		currentTemperature=Integer.parseInt(numericTemperature[0]);
	}
	
	public static void checkRange(By locator)
	{
		temperatureRange=DriverWrapper.getDriver().findElement(locator).getText();
		String[] lowTemp = temperatureRange.split("Low");
		String[] highTemp = temperatureRange.split("High");
		String[] getHigh = highTemp[1].split("˚");
		String[] getLow = lowTemp[1].split("˚");
		String t1=getLow[0];
		String t2=getHigh[0];
		t1=t1.replaceAll("\\s","");
		t1=t1.replaceAll("[^\\d.]", "");
		t2=t2.replaceAll("\\s","");
		t2=t2.replaceAll("[^\\d.]", "");
		
	
		lowTemperature = Integer.parseInt(t1);
	    highTemperature= Integer.parseInt(t2);
	   
	   if (currentTemperature >= lowTemperature || currentTemperature <= highTemperature)
	   {
		   System.out.println("You current temperature of " + currentTemperature + 
				   " is in the range "+ lowTemperature + " and " + highTemperature);
		   
	   }
	   else
	   {
		   System.out.println("You current temperature of " + currentTemperature + 
				   " is not in the range "+ lowTemperature + " and " + highTemperature);
		   
	   }
	  
		
		
	}
	
	

}
