package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class B1 {
@BeforeSuite
public void bsconfig() {
	System.out.println("before suite executed");
}
@BeforeTest
public void btconfig() {
	System.out.println("before test executed");
}
@BeforeClass
public void aconfig() {
	System.out.println("before a class executed");
}
@BeforeClass
public void bconfig() {
	System.out.println("before b class executed");
}
@BeforeMethod
public void ammmconfig() {
	System.out.println("before a method executed");
}
@BeforeMethod
public void bmmm1config() {
	System.out.println("before b method1 executed");
}


@AfterTest
public void atconfig() {
	System.out.println("after test executed");
}
@AfterClass
public void acbconfig() {
	System.out.println("after class acb executed");
}
@AfterClass
public void accconfig() {
	System.out.println("after class acc executed");
}
@AfterMethod
public void abmconfig() {
	System.out.println("after method ab executed");
}
@AfterMethod
public void acmconfig() {
	System.out.println("after method ac executed");
}
@AfterSuite
public void asconfig() {
	System.out.println("after suite executed");
}

}
