package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    By desktops = By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]");

    By showDesktops = By.xpath("//a[contains(text(),'Show AllDesktops')]");
    By dropDown =By.xpath("//select[@id='input-sort']");
    By productName= By.xpath("//h4/a");
    By input = By.cssSelector("#input-sort");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By hpProduct = By.xpath("//a[contains(text(),'HP LP3065')]");
    By button= By.xpath("//div[@class = 'input-group date']//button");
   By monthY = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
  By clickArrow = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
  By allDays = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day'])");
  By addToCart = By.id("button-cart");
  By shoppingCart =By.xpath("//div[@class='alert alert-success alert-dismissible']") ;
    //1.1 Mouse hover on Desktops Tab.and click
    public void mousehoverOnDeskTops(){
        mouseHoverToElement(desktops);

    }
    //1.2 Click on “Show All Desktops”
    public void clickOnShowAllDesktops(){
        clickOnElement(showDesktops);
    }
    //1.3 Select Sort By position "Name: Z to A"
    public void selectSortByPosition(){
        selectByVisibleTextFromDropDown(dropDown,"Name (Z - A)");
    }
    public void selectSortByPositionAtoZ(){
        selectByVisibleTextFromDropDown(input,"Name (A - Z)");
    }
     //1.4 Verify the Product will arrange in Descending order
    public void verifyProductInDescending(){
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(productName);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
     //   Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(input, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(productName);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //1.4 Verify the Product will arrange in Descending order

        //  Assert.assertEquals("Product not sorted into Z to A order",
              //         originalProductsName, afterSortByZToAProductsName);

    }
    // Select currency as £ Pound Sterling
    public void selectCurrencyAsPound(){
        clickOnElement(currency);
    }
// 2.4 Select product “HP LP3065”
    public void selectHpProduct(){
        clickOnElement(hpProduct);
    }
    //2.5 Verify the Text "HP LP3065"
    // 2.6 Select Delivery Date "2022-11-30"
    public void deliveryDate(){
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

      //  String year = "2023";
       // String month = "November";
      //  String date = "30";

      //  clickOnElement(button);
      //  while (true) {
          //  String monthYear = driver.findElement(monthY).getText();
          //  String[] a = monthYear.split(" ");
         //   String mon = a[0];
          //  String yer = a[1];
            //if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
             //   break;
           // } else {
            //    clickOnElement(clickArrow);
           // }
       // }

       // List<WebElement> allDate = driver.findElements(allDays);
      //  for (WebElement dateList : allDate) {
         //   if (dateList.getText().equalsIgnoreCase(date)) {
            //    dateList.click();
              //  break;
           // }
      //  }

   // }
    //        2.7.Enter Qty
    // 2.8 Click on “Add to Cart” button
   public void addToCart() {
        clickOnElement(addToCart);
   }

         //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
          //  2.10 Click on link “shopping cart” display into success message
    public void clickOnShoppingCartMessage(){
        clickOnElement(shoppingCart);
    }
          //2.11 Verify the text "Shopping Cart"
          //  2.12 Verify the Product name "HP LP3065"
         //   2.13 Verify the Delivery Date "2022-11-30"
          //  2.14 Verify the Model "Product21"
          //  2.15 Verify the Todat "£74.73"
}


