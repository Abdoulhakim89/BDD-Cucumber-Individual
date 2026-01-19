package steps;

import factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import pages.CartPage;
import pages.StorePage;

public class AddToCartStepDefs {
    private WebDriver driver;
    private StorePage store;

    @Given("the customer is on the Store page")
    public void theCustomerIsOnTheStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store/");
    }

    @When("the customer adds {string}")
    public void theCustomerAdds(String product) {
        store = new StorePage(driver);
        store.addProductToCart(product);

    }

    @Then("the customer should see {int} {string} in the cart")
    public void theCustomerShouldSeeInTheCart(int quantity, String product) {
        CartPage cart = store.viewCartPage();
        assertTrue(cart.getProductName(product).contains(product));
        assertTrue(cart.getProductQuantity()==quantity);
    }
}
