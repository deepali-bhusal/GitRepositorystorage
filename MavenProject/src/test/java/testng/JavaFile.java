package testng;

import org.testng.annotations.Test;

public class JavaFile {
	@Test(priority=4,expectedExceptions = ArithmeticException.class)
	public void Example()
	{
		System.out.println("This is Exception");
		int i=10/0;
		System.out.println("This is Exception handling");
		System.out.println("Hello java File of testng");
	}
	
	@Test(priority=1,description="Signup page",enabled=true)
	public void signup()
	{
		System.out.println("Hello java File,I am Testng");
	}
	
	@Test(priority=2,timeOut=1000)
	public void login() throws InterruptedException
	{
		System.out.println("Hello java File,login page");
		//Thread.sleep(2000);
		//Thread.sleep(500);
	}
	
	@Test(priority=3)
	public void compose()
	{
		System.out.println("Hello java File");
	}
	

}
