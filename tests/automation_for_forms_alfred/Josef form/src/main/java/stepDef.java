import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class stepDef {

    public static WebDriver driver= null;
    public static String browser = "";
    @Before
    public void setUp(){
        if(browser == "Firefox") {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser == "Edge") {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I go to the form URL")
    public void i_go_to_the_form_url() {
        driver.get("http://localhost:9001/#/qa");
    }

    @When("I fill all the fields {string},{string},{string},{string}")
    public void i_fill_all_the_fields(String Name, String Email, String Age, String Phone) throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys(Name);
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("age")).sendKeys(Age);
        driver.findElement(By.name("phone")).sendKeys(Phone);
        Thread.sleep(5000);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }



    @Then("I should be able to submit the form successfully {string},{string},{string},{string}")
    public void i_should_be_able_to_submit_the_form_successfully(String Name, String Email, String Age, String Phone) throws InterruptedException {
        String value = driver.findElement(By.xpath("/html/body/div/main/div/p[5]")).getText();
            String expected = "Form submited: "+Name+"("+Email+"), age of "+Age+", tel: "+Phone+" ✅";
            SoftAssert softAssert = new SoftAssert();
            //asserting to check whether the form is on the "form successfully submitted" page and the success message is shown
            softAssert.assertNotNull(value);
            softAssert.assertEquals(value,expected,"Comment matching");
            softAssert.assertAll();
            Thread.sleep(3000);

    }


    @When("I fill the fields incorrectly with these values  {string},{string},{string},{string}")
    public void i_fill_the_fields_incorrectly_with_these_values(String Name, String Email, String Age, String Phone) throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys(Name);
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("age")).sendKeys(Age);
        driver.findElement(By.name("phone")).sendKeys(Phone);
        Thread.sleep(5000);
    }


    @Then("I should not be able to submit the form successfully")
    public void i_should_not_be_able_to_submit_the_form_successfully() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //Asserting to check whether the form has not been submitted and the submit button is still visible even after clicking
        softAssert.assertNotNull(driver.findElement(By.xpath("/html/body/div/main/div/form/button")));
        softAssert.assertAll();
        Thread.sleep(3000);
    }




}

