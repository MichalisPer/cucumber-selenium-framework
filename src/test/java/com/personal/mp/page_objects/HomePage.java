package com.personal.mp.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectSortOptionByText(String optionText) {
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(optionText);
    }


    private List<String> getProductPricesAsString() {
        return products.stream().map(e -> e.findElement(By.className(
                "inventory_item_price")).getText()).collect(Collectors.toList());
    }

    private List<Double> getProductPricesAsDouble() {
        return getProductPricesAsString().stream()
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());
    }

    public boolean arePricesSortedAscending() {
        List<Double> productPrices = getProductPricesAsDouble();
        List<Double> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);
        return productPrices.equals(sortedPrices);
    }

    public boolean arePricesSortedDescending() {
        List<Double> productPrices = getProductPricesAsDouble();
        List<Double> sortedPrices = new ArrayList<>(productPrices);
        sortedPrices.sort(Collections.reverseOrder());
        return productPrices.equals(sortedPrices);
    }
}
