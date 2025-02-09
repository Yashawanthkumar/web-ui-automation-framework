package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class DropDownPage extends BasePage{
    private By dropdown = By.id("dropdown");

    public DropDownPage() {
        super();
    }

    public void selectOptionByValue(String value) {
        selectByValue(dropdown, value);
    }

    public String getSelectedOption() {
        return getSelectedOptionText(dropdown);
    }
}
