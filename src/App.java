import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class App {
	
    //1
	@Test
	public void checkLoginProfile(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\my_test_pro\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String expmsg = "Copyright © 2005-2019 JavaByKiran.";
		String actmsg = driver.findElement(By.xpath("//strong")).getText();
		Assert.assertEquals(actmsg, expmsg);
		driver.close();

	}
	//2
	@Test
	public void checkInvalidCredentials() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran23@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String Expmsg = driver.findElement(By.id("email_error")).getText();
		String Actmsg = "Please enter email as kiran@gmail.com";
		
		Assert.assertEquals(Actmsg, Expmsg);
		driver.close();
		
	}
	
	//3
	@Test
	public void checkRegistrnewmember() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Register a new membership")).click();
		driver.findElement(By.id("name")).sendKeys("ingole");
		driver.findElement(By.id("mobile")).sendKeys("9963214785");
		driver.findElement(By.id("email")).sendKeys("ingole345@gmail.com");
		driver.findElement(By.id("password")).sendKeys("@6458#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Alert alertName = driver.switchTo().alert();
		String Act_response = alertName.getText();
		alertName.accept();

		String Exp_response = "User registered successfully.";
		System.out.println("Act_response"+ Act_response);
		System.out.println(Exp_response);
		
		Assert.assertEquals(Act_response, Exp_response);
		driver.close();
	}
	
	//4
	@Test
	public void checkMainNavigaton() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String ActNavigation = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		for(int i=2; i<=7; i++) {
			String navigation ="/html/body/div/aside/section/ul/li["+i+"]/a/span";
			ActNavigation = driver.findElement(By.xpath(navigation)).getText();
			System.out.println(ActNavigation);
		}
		String ExpNavigation = "Logout";
		
		Assert.assertEquals(ActNavigation, ExpNavigation);
		driver.close();
	}
	
	//5
	@Test
	public void checkWebSiteFooter() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String ActText = driver.findElement(By.xpath("//*[@class='pull-right hidden-xs']")).getText();
		String ExpText = "Design for Selenium Automation Test V 2.3.0";
		
		Assert.assertEquals(ActText, ExpText);
		driver.close();
	}
	
	//6
	@Test
	public void checkDashboardCourses() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String ActCourses = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		for(int i=1; i<=4; i++) {
			String course ="/html/body/div/div[1]/section[2]/div/div["+i+"]/div/div[1]";
			ActCourses = driver.findElement(By.xpath(course)).getText();
			System.out.println(ActCourses);
		}
		String ExpCourses = "Php"+'\n'+"Web Development";
		
		Assert.assertEquals(ActCourses, ExpCourses);
		driver.close();
	}
	
	//7
	@Test
	public void checkUserListbox() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		WebElement state = driver.findElement(By.xpath("//select[contains(text(),'')]"));
		state.click();
		
		Select S = new Select(state);
	    List<WebElement> allvals = S.getOptions();
	    ArrayList<String> Actallstate = new ArrayList<String>();
	    for(WebElement we :allvals) {
	    	String State_name = we.getText();
	    	Actallstate.add(State_name);
	    }
	    Actallstate.remove(0);
	    System.out.println(Actallstate);
	    
	    ArrayList<String> Expallstate = new ArrayList<String>();
	    Expallstate.add("Maharashtra");
	    Expallstate.add("Delhi");
	    Expallstate.add("HP");
	    Expallstate.add("Punjab");
	    
	    Assert.assertEquals(Actallstate, Expallstate);
		driver.close();
	    
	}
	
	//8
	@Test
	public void addNewusername() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		driver.findElement(By.id("username")).sendKeys("shweta");
		driver.findElement(By.id("mobile")).sendKeys("70385291850");
		driver.findElement(By.id("email")).sendKeys("shweta232@gmail.com");
		driver.findElement(By.id("course")).sendKeys("python");
		driver.findElement(By.id("Female")).click();
		WebElement select_state = driver.findElement(By.xpath("//select[contains(text(),'')]"));
		select_state.click();
		Select State = new Select(select_state);
		State.selectByIndex(1);
		driver.findElement(By.id("password")).sendKeys("@234#");
		driver.findElement(By.xpath("//input[@placeholder='FriendMobile']")).sendKeys("7894561230");
		driver.findElement(By.id("submit")).click();
		Alert alertname = driver.switchTo().alert();
		String Act_notification = alertname.getText();
		alertname.accept();
		String Acp_notification = "User Added Successfully. You can not see added user.";
		
		Assert.assertEquals(Act_notification, Acp_notification);
		driver.close();
	}
	
	//9
	@Test
	public void checkuserlistname () {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String ActUsernamelist = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		
		for(int i=2; i<=4; i++) {
			for(int j=1; j<=7; j++) {
				String userlistpath = "/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]";
				ActUsernamelist = driver.findElement(By.xpath(userlistpath)).getText();
				
			}
		}
		String Expusernamelist = "Maharashtra";
		
		
		Assert.assertEquals(ActUsernamelist, Expusernamelist);
		driver.close();
	}
	
	
	//10
	@Test
	public void checkLogoutProcess() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
		
		String ActResult = driver.findElement(By.xpath("//p[@style]")).getText();
		String ExpResult = "Logout successfully";		
		driver.close();		
	}
	
	//11
	@Test
	public void checkOperatorListContact() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String Actcontact = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Operators")).click();
		for(int i=2; i<=6; i++) {
			String contactlist = "/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[5]";
			Actcontact = driver.findElement(By.xpath(contactlist)).getText();
					System.out.println(Actcontact);
		}
		String Expcontact = "8866888662";
		
		Assert.assertEquals(Actcontact, Expcontact);
		driver.close();
		
	}
	
	//12
	@Test
	public void checkGobuttoninUsefulLinks() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Useful Links")).click();
		
		String Actbutton = driver.findElement(By.xpath("//span[@class='label label-success']")).getText();
		String Expbutton = "Go !";
		
		Assert.assertEquals(Actbutton, Expbutton);
		driver.close();
		}
	
	//13
	@Test
	public void checkContentInuUsefulLink() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String Actcontent = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Useful Links")).click();
		for(int i=2; i<=7; i++) {
			String contentlist = "/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[2]";
			Actcontent = driver.findElement(By.xpath(contentlist)).getText();
			System.out.println(Actcontent);
		}
		String Expcontent = "Placement";
		
		Assert.assertEquals(Actcontent, Expcontent);
		driver.close();	
	}
	
	@Test
	public void checkDeletButtonInUser() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		String ActButton = driver.findElement(By.xpath("//span[@class='label label-danger']")).getText();
		String ExpButton = "Delete";
		
		Assert.assertEquals(ActButton, ExpButton);
		driver.close();
		
	}
	
	@Test
	public void checkJDKImageInDownloads() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebElement ActJDk = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Downloads")).click();
		ActJDk = driver.findElement(By.xpath("//img[contains(@src,'../images/jdk.png')]"));
		
		String ACT = ActJDk.getText();
		String EXP = "";
		
		Assert.assertEquals(ACT, EXP);
		driver.close();
	}
	
	@Test
	public void checkFFImage() {
		WebDriver driver = new ChromeDriver();
		WebElement ActImage = null;
		driver.get("C:\\Users\\Admin\\Documents\\my_test_pro\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.partialLinkText("Downloads")).click();
		ActImage = driver.findElement(By.xpath("//img[contains(@src,'../images/firefox.png')]"));
		String ACTUAL = ActImage.getText();
		String EXPECTED ="";
		
		Assert.assertEquals(ACTUAL, EXPECTED);
		driver.close();
		
	}
}






