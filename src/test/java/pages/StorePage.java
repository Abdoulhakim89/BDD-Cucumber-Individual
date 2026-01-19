package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{

    private By addToCartButton = By.xpath(".//a[contains(text(),'Add to cart')]");
    private By viewCartLink = By.className("added_to_cart");
    private WebElement currentProductToAdd;

    public StorePage(WebDriver driver) {
        super(driver);
    }

     public void addProductToCart(String productName){
         wait.until(ExpectedConditions.elementToBeClickable((By.xpath(".//li[.//h2[contains(text(),\""+productName+"\")]]"))));
         currentProductToAdd =driver.findElement(By.xpath(".//li[.//h2[contains(text(),\""+productName+"\")]]"));
         currentProductToAdd.findElement(addToCartButton).click();

         wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));
     }
     public CartPage viewCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));
         driver.findElement(viewCartLink).click();
         return new CartPage(driver);
     }





}
