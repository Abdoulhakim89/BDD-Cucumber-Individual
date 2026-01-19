package pages;

import domainObjects.BillingDetailsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    private By billingFirstname = By.id("billing_first_name");
    private By billingLastname = By.id("billing_last_name");
    private By billingCountry = By.id("billing_country");
    private By billingStreet = By.id("billing_address_1");
    private By billingTown = By.id("billing_city");
    private By billingState = By.id("billing_state");
    private By billingZip = By.id("billing_postcode");
    private By billingEmail = By.id("billing_email");
    private By placeOrderButton = By.id("place_order");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public Select countryDropDown(){
        return new Select(fieldFinder(billingCountry));
    }
    public WebElement fieldFinder(By finder){return driver.findElement(finder);}

    public void fillBillingForm(BillingDetailsObject billingDetails){
        fieldFinder(billingFirstname).sendKeys(billingDetails.getFirstname());
        fieldFinder(billingLastname).sendKeys(billingDetails.getLastname());
        countryDropDown().selectByContainsVisibleText(billingDetails.getCountry());
        fieldFinder(billingStreet).sendKeys(billingDetails.getStreet());
        fieldFinder(billingTown).sendKeys(billingDetails.getTown());
        fieldFinder(billingState).sendKeys(billingDetails.getState());
        fieldFinder(billingZip).sendKeys(billingDetails.getZip());
        fieldFinder(billingEmail).sendKeys(billingDetails.getEmail());

    }
    public void placeOrder(){

    }

}
