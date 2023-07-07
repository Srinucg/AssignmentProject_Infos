package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Savings {

    @FindBy(xpath = "//*[text()='What is your current age?']//following::input[@type='text'][1]")
    public WebElement current_Age;

    @FindBy(xpath = "//*[text()='At what age do you plan to retire?']//following::input[@type='text'][1]")
    public WebElement at_what_age_do_you_plan_to_retire_field;

    @FindBy(xpath = "//*[text()='What is your current annual income?']//following::input[@type='text'][1]")
    public WebElement what_is_your_current_annual_income_field;

    @FindBy(xpath = "//*[text()=\"What is your spouse's annual income?\"]//following::input[@type='text'][1]")
    public WebElement what_is_your_spouses_annual_income_field;

    @FindBy(xpath = "//*[contains(text(),\"What is your current retirement savings balance?\")]//following::input[@type='text'][1]")
    public WebElement retirement_savings_balance_field;

    @FindBy(xpath = "//*[contains(text(),\"How much are you currently saving each year for retirement?\")]//following::input[@type='text'][1]")
    public WebElement saving_each_year_for_retirement_field;

    @FindBy(xpath = "//*[contains(text(),\"What is the rate of increase in your savings each year?\")]//following::input[@type='text'][1]")
    public WebElement increase_in_your_savings_each_year;

    @FindBy(xpath = "(//*[contains(text(),\"Yes\")])[1]")
    public WebElement Click_Yes_button_toggle;

    @FindBy(xpath = "//*[contains(text(),\"Social Security override amount\")]//following::input[@type='text'][1]")
    public WebElement social_security_override_amount_field;

    @FindBy(xpath = "//*[contains(text(),\"Calculate\")]")
    public WebElement click_calculate_button;

}
