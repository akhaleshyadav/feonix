package feonix.testing.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logs {
	 public static void Takelog(String classname, String msg)
	   {
		   DOMConfigurator.configure("D:\\Automation\\Selenium_Workspace\\CP-BPTC_Framework\\src\\BPTC\\utilities\\layout.xml");
		   Logger l=Logger.getLogger(classname);
		   l.info(msg);
	   }

    public static void takescreens()
    {
    	System.out.println("It for taking the screenshot");
    }
    }