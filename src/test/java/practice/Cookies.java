package practice;



	import java.io.BufferedReader;		
	import java.io.File;		
	import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;		
	import java.util.StringTokenizer;		
	import org.openqa.selenium.Cookie;		
	import org.openqa.selenium.WebDriver;		
	import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Cookies		
	{		
	  
		@SuppressWarnings("deprecation")
		public static void main(String[] args){ 
	    	WebDriver driver;     
			WebDriverManager.chromedriver().setup();       
					
	        driver=new ChromeDriver();					
	    try{			
	     
	        File file = new File("Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
	        StringTokenizer token = new StringTokenizer(strline,";");									
	        while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();
	      //  String dDate=token.nextToken(); 
	       // DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
	        Date expiry = null;//
	       
	     //   Date expiry = new Date();
	      //  System.out.println(expiry);
	        
	        		
	      String val;			
	        if(!(val=token.nextToken()).equals("null"))
			{		
	        	DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
	        	df.parse(val); 
	          	expiry = new Date();					
	        }		
	      //  Boolean isSecure = new Boolean(token.nextToken()).								
	       // booleanValue();	
	        Boolean isSecure=Boolean.valueOf(token.nextToken());
	        System.out.println(isSecure);
	        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
	        System.out.println(ck);
	        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
	        }		
	        }		
	        }catch(Exception ex){					
	        ex.printStackTrace();			
	        }		
	   
	        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");					
	}	
		

}
