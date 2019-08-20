package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC_SS1 {

	//TC_SS1: Verify the login session - Enter valid userID and password
	//Browser: Firefox
	//Data: User ID : mngr214283 	Password : syqEsEt
	
	//Declare variables
	static WebDriver driver;
	static String driverPath = "D:\\Software\\Selenium\\Resource\\geckodriver.exe";
	private static final DesiredCapabilities DesiredCapabilites = null;
	static String url = "http://www.demo.guru99.com/V4/";
	static String userid = "mngr214283";
	static String password = "syqEsEt";
	static String expectedwelcome = "Welcome To Manager's Page of Guru99 Bank";
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
						
		//Step 1: Go to http://www.demo.guru99.com/V4/
		System.setProperty("webdriver.gecko.driver", driverPath);
		DesiredCapabilities capabilities = DesiredCapabilites.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		
		driver.get(url);
		
		//Step 2: Enter valid userid
		WebElement e_userid = driver.findElement(By.xpath("//input[@name='uid']"));
		e_userid.sendKeys(userid);		
		
		//Step 3: Enter valid password
		WebElement e_password = driver.findElement(By.xpath("//input[@name='password']"));
		e_password.sendKeys(password);
		
		//Step 4: Click Login
		WebElement e_login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		e_login.click();
		
		//Verify result: Expected result: Login successfully
		WebElement e_welcome = driver.findElement(By.xpath("//marquee[@class='heading3']"));
		String actualwelcome = e_welcome.getText();
		if(actualwelcome.contentEquals(expectedwelcome))
			System.out.println("Test case TC_SS1 is Pass");
		else
			System.out.println("Test case TC_SS1 is Fail");
		
		//Close browser
		driver.close();
		
	}

}
