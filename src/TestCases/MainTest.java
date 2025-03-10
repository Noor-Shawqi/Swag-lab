package TestCases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
	WebDriver driver = new ChromeDriver();
	String MyWebSite = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	Random Rand=new Random();

	@BeforeTest
	public void MySetUp() {
		driver.get(MyWebSite);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Login() {
		WebElement usernameinput = driver.findElement(By.id("user-name"));
		usernameinput.sendKeys(UserName);
		WebElement passwordinput = driver.findElement(By.id("password"));
		passwordinput.sendKeys(Password);
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddFirstItem() {
		WebElement addtocartbutton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addtocartbutton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddAllItems() {
		List<WebElement> addtocartbuttons = driver.findElements(By.className("btn"));
		for (int i = 0; i < addtocartbuttons.size(); i++) {
			addtocartbuttons.get(i).click();
		}
	}

	@Test(priority=2,enabled=false)
		public void AddCertainItems() {
		List <WebElement> addtocartbuttons=driver.findElements(By.className("btn"));
		for (int i = 0; i < addtocartbuttons.size(); i++) {

			if (i == 0 && i == 2) {
				continue;
			}
			addtocartbuttons.get(i).click();
		}
	}
	@Test(priority=2,enabled=false)
	public void AddItemsThatStartsWithSauce() {
	 List <WebElement> addtocartbuttons=driver.findElements(By.className("btn"));
	 List<WebElement> itemsname=driver.findElements(By.className("inventory_item_name"));
	 for (int i = 0; i < itemsname.size(); i++) {
		if(itemsname.get(i).getText().startsWith("Sauce")){
			addtocartbuttons.get(i).click();
		}
	 }

	}
	@Test(priority=2)
	public void AddRandomItem() {
	List <WebElement> addtocartbuttons=driver.findElements(By.className("btn"));
	int randominput=Rand.nextInt(addtocartbuttons.size());
	addtocartbuttons.get(randominput).click();

	}
	@Test(priority=3)
	public void CheckoutProcess() {
		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();

		WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
		Checkoutbutton.click();
		// Array of first names

		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };

		int RandomFirstName = Rand.nextInt(firstNames.length);

		// Array of last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int RandomLastName = Rand.nextInt(lastNames.length);

		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };
		int RandomPostalCode = Rand.nextInt(postalCodes.length);

		WebElement FirstnameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostCodeInput = driver.findElement(By.id("postal-code"));

		FirstnameInput.sendKeys(firstNames[RandomFirstName]);
		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostCodeInput.sendKeys(postalCodes[RandomPostalCode]);
		
		WebElement ContinueButton = driver.findElement(By.id("continue"));
		ContinueButton.click();
		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
	}

		
	}
