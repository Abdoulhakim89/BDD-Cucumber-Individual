package steps;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.PageFactoryManager;
import pages.ProductDetailsPage;
import pages.StorePage;

import static org.testng.Assert.*;

public class addFromProductDetailsStepDefs {
    private WebDriver driver;
    private ProductDetailsPage productDetails;
    private StorePage storePage;
    private CartPage cartPage;



    @And("the customer navigates to {string} details page")
    public void theCustomerNavigatesToDetailsPage(String product) {
        driver = DriverFactory.getDriver();
        storePage = PageFactoryManager.getStorePage(driver);
    }

    @When("customer adds {int} {string} to cart")
    public void customerAddsToCart(int qty, String product) {
        productDetails = storePage.viewProductDetails(product);
        if(qty > 1){
        productDetails.addProductToCart(qty);
        } else {
            productDetails.addProductToCart();
        };

        productDetails.viewCart();

    }
    @Then("customer should see {int} {string} to cart")
    public void customerSeeProductInCart(int qty, String product){
        cartPage = PageFactoryManager.getCartPage(driver);
        var productName = cartPage.getProductName(product);
        int  productQuantity = cartPage.getProductQuantity();

        assertEquals(productName,product);
        assertEquals(productQuantity,qty);
    }

}
