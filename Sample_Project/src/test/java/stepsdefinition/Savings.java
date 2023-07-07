package stepsdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import static helpers.FunctionsLibrary.ReadPropertiesFile;
import static modules.Hooks.*;

public class Savings {
    private HashMap<String, String> appProperties = ReadPropertiesFile();
    private String url = appProperties.get("url");

//    public Savings() throws IOException {
//    }
@When("Open the savings money retirement application URL")
public void openTheSavingsMoneyRetirementApplicationURL() throws Throwable {
    driver.get(url);
    System.out.println("Entered URL" + driver.getCurrentUrl());
    Thread.sleep(2000);
    System.out.println("*************Open the application URL");
}

    @Then("Click on what is your current age field (.*)$")
    public void clickOnWhatIsYourCurrentAgeFieldAge(String age) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.current_Age, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.current_Age);
        Thread.sleep(500);
        functionsLibrary.elementSendKeys(SavingsPageObj.current_Age, age);
        Thread.sleep(500);
//        SavingsPageObj.current_Age.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER));
//        Thread.sleep(500);
    }

    @Then("Enter the At what age do you plan to retire field (.*)$")
    public void enterTheAtWhatAgeDoYouPlanToRetireField(String Retire_Age) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.at_what_age_do_you_plan_to_retire_field, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.at_what_age_do_you_plan_to_retire_field);
        Thread.sleep(500);
        functionsLibrary.elementSendKeys(SavingsPageObj.at_what_age_do_you_plan_to_retire_field, Retire_Age);
        Thread.sleep(500);
    }

    @Then("Enter the What is your current annual income field (.*)$")
    public void enterTheWhatIsYourCurrentAnnualIncomeField(String Current_annual_income) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.what_is_your_current_annual_income_field, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.what_is_your_current_annual_income_field);
        Thread.sleep(1500);
        functionsLibrary.elementSendKeys(SavingsPageObj.what_is_your_current_annual_income_field, Current_annual_income);
        Thread.sleep(1500);
    }

    @Then("Enter the What is your spouses annual income field (.*)$")
    public void enterTheWhatIsYourSpousesAnnualIncomeField(String Spouse_annual_income) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.what_is_your_spouses_annual_income_field, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.what_is_your_spouses_annual_income_field);
        Thread.sleep(1500);
        functionsLibrary.elementSendKeys(SavingsPageObj.what_is_your_spouses_annual_income_field, Spouse_annual_income);
        Thread.sleep(2500);
    }

    @Then("Enter the What is your current retirement savings balance field (.*)$")
    public void enterTheWhatIsYourCurrentRetirementSavingsBalanceField(String Savings_balance) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.retirement_savings_balance_field, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.retirement_savings_balance_field);
        Thread.sleep(1500);
        functionsLibrary.elementSendKeys(SavingsPageObj.retirement_savings_balance_field, Savings_balance);
        Thread.sleep(2500);
    }

    @Then("Enter the How much are you currently saving each year for retirement field (.*)$")
    public void enterTheHowMuchAreYouCurrentlySavingEachYearForRetirementField(String Retirement) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.saving_each_year_for_retirement_field, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.saving_each_year_for_retirement_field);
        Thread.sleep(1500);
        functionsLibrary.elementSendKeys(SavingsPageObj.saving_each_year_for_retirement_field, Retirement);
        Thread.sleep(1500);
    }

    @Then("Enter the What is the rate of increase in your savings each year field (.*)$")
    public void enterTheWhatIsTheRateOfIncreaseInYourSavingsEachYearField(String Savings_each_year) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.increase_in_your_savings_each_year, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.increase_in_your_savings_each_year);
        Thread.sleep(1500);
        functionsLibrary.elementSendKeys(SavingsPageObj.increase_in_your_savings_each_year, Savings_each_year);
        Thread.sleep(2500);
    }

    @Then("Click on Yes toggle button Should we include Social Security benefits")
    public void clickOnYesToggleButtonShouldWeIncludeSocialSecurityBenefits() throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.Click_Yes_button_toggle, 30);
        Thread.sleep(1500);
        functionsLibrary.elementClick(SavingsPageObj.Click_Yes_button_toggle);
        Thread.sleep(1500);
    }

    @Then("Enter the Social Security override amount (.*)$")
    public void enterTheSocialSecurityOverrideAmount(String Security_override_amount) throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.social_security_override_amount_field, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.social_security_override_amount_field);
        Thread.sleep(1500);
        functionsLibrary.elementSendKeys(SavingsPageObj.social_security_override_amount_field, Security_override_amount);
        Thread.sleep(2500);
    }

    @Then("Click on calculate button")
    public void clickOnCalculateButton() throws InterruptedException {
        functionsLibrary.waitvisibilityOfElement(SavingsPageObj.click_calculate_button, 30);
        Thread.sleep(500);
        functionsLibrary.elementClick(SavingsPageObj.click_calculate_button);
        Thread.sleep(1500);
    }
}
