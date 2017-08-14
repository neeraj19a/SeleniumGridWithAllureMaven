package com.neerajProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilityFiles.PageBase;

public class HomePage extends TestBase{

    public HomePage(RemoteWebDriver driver) {
        this.driver=driver;
        Log.info("Now here"+driver);
        PageFactory.initElements(driver, this);
    }


    //######Gmail
    @FindBy(xpath = ".//span[@id='link-signup']/a")
    public WebElement GmailCreateAccount;

    @FindBy(xpath = ".//*[@id='FirstName']")
    public WebElement GmailFirstName;

    @FindBy(xpath = ".//*[@id='LastName']")
    public WebElement GmailLastName;

    @FindBy(xpath = ".//*[@id='GmailAddress']")
    public WebElement GmailAddress;

    @FindBy(xpath = ".//*[@id='Passwd']")
    public WebElement GmailPassword;

    @FindBy(xpath = ".//*[@id='PasswdAgain']")
    public WebElement GmailPasswordAgain;

    @FindBy(xpath = ".//*[@id='BirthMonth']/div[1]")
    public WebElement GmailMonth;

    @FindBy(xpath = ".//*[@id='BirthDay']")
    public WebElement GmailDay;

    @FindBy(xpath = ".//*[@id='BirthYear']")
    public WebElement GmailYear;

    @FindBy(xpath = ".//*[@id='Gender']/div")
    public WebElement GmailGender;

    @FindBy(xpath = ".//*[@id='RecoveryEmailAddress']")
    public WebElement RecoverEmail;

    @FindBy(xpath = ".//*[@id='recaptcha_response_field']")
    public WebElement Captcha;

    @FindBy(xpath = ".//*[@id='TermsOfService']")
    public WebElement Terms;

    @FindBy(xpath = ".//*[@id='submitbutton']")
    public WebElement Submit;


    //####Facebook##
    @FindBy(xpath = ".//input[@name='firstname']")
    public WebElement FirstName;

    @FindBy(xpath = ".//input[@name='lastname']")
    public WebElement LastName;

    @FindBy(xpath = ".//input[@name='reg_email__']")
    public WebElement Email;

    @FindBy(xpath = ".//input[@name='reg_email_confirmation__']")
    public WebElement ConfirmEmail;

    @FindBy(xpath = ".//input[@name='reg_passwd__']")
    public WebElement Password;

    @FindBy(id = "day")
    public WebElement Select;


    @FindBy(xpath = ".//*[@id='month']")
    public WebElement Month;


    @FindBy(xpath = ".//*[@id='year']")
    public WebElement Year;


    @FindBy(xpath = ".//input[@value='2']")
    public WebElement Sex;


    @FindBy(xpath = ".//button[@name='websubmit']")
    public WebElement CreateAccount;

    @FindBy(xpath = ".//a[starts-with(.,'Next')]")
    public WebElement Next;

    @FindBy(xpath = ".//a[starts-with(.,'Skip Step')]")
    public WebElement SkipStep;


    //###########
    @FindBy(xpath = ".//*[@id='email']")
    public WebElement TrafficEmail;

    @FindBy(xpath = ".//*[@id='password']")
    public WebElement TrafficPassword;

    @FindBy(xpath = ".//*[@id='code']")
    public WebElement TrafficCode;

    @FindBy(xpath = ".//*[@id='signin_form']/div[5]/div[2]/input[2]")
    public WebElement TrafficLogin;


    @FindBy(xpath = ".//a[starts-with(.,'Likes')]")
    public WebElement TrafficLikes;

    @FindBy(xpath = ".//a[starts-with(.,'Refresh Page')]")
    public WebElement TrafficRefresh;

    //#####Facebook Login
    @FindBy(xpath = ".//*[@id='email']")
    public WebElement FacebookEmail;

    @FindBy(xpath = ".//*[@id='pass']")
    public WebElement FacebookPassword;

    @FindBy(xpath = ".//*[@id='loginbutton']")
    public WebElement FacebookLogin;

    @FindBy(xpath = ".//div[@aria-label='Search Facebook']")
    public WebElement FacebookSearch;

    @FindBy(xpath = ".//span[@class='fragmentEnt']/../..")
    public WebElement FacebookSearchItems;

    @FindBy(xpath = ".//span[@class=%s]")
    public WebElement FacebookTry;

    //####TrafficFunction
    public void clickTrafficEmail(String Email) {
        TrafficEmail.click();
        TrafficEmail.sendKeys(Email);
    }

    public void clickTrafficPassword(String Password) {
        TrafficPassword.click();
        TrafficPassword.sendKeys(Password);
    }

    public void clickTrafficCode(String Code) {
        TrafficCode.click();
        TrafficCode.sendKeys(Code);
    }

    public void clickTrafficLogin() {
        TrafficLogin.click();

    }

    public void clickTrafficLikes() {
        TrafficLikes.click();

    }

    public void clickTrafficRefresh() {
        TrafficRefresh.click();
    }

    //######Facebook Login
    public void clickFacebookEmail(String Email) {
        //webDriverOperations.click(FacebookEmail);
        //To implement findAndReplace

        //driver.findElement(By.xpath(".//*[@id='email']")).click();
        click(FacebookEmail);
        FacebookEmail.click();
        FacebookEmail.sendKeys(Email);
        FacebookEmail.clear();
        setText(FacebookEmail,Email);
        //webDriverOperations.setText(FacebookEmail,Email);
    }

    public void clickFacebookEmailUsingFindAndReplace(String Email) {
        //webDriverOperations.click(FacebookEmail);
        //To implement findAndReplace
        WebElement element=findandReplace(".//span[@class=%s]","xpath");
        click(element);

        //driver.findElement(By.xpath(".//*[@id='email']")).click();
        FacebookEmail.click();
        FacebookEmail.sendKeys(Email);

        //webDriverOperations.setText(FacebookEmail,Email);
    }
    public void clickFacebookPassword(String Pass) {
        FacebookPassword.click();
        FacebookPassword.sendKeys(Pass);
    }

    public void clickFacebookLogin() {
        FacebookLogin.click();

    }

    public void clickFacebookSearch(String search) {
        FacebookSearch.click();
        FacebookSearch.sendKeys(search);

    }


    //#GmailFunctions
    public void clickGmailCreateAccount() {
        GmailCreateAccount.click();
    }

    public void clicksetGmailFirstName(String firstName) {
        GmailFirstName.click();
        GmailFirstName.sendKeys(firstName);
    }

    public void clicksetGmailLastName(String lastName) {
        GmailLastName.click();
        GmailLastName.sendKeys(lastName);
    }

    public void clicksetGmailAddress(String email) {
        GmailAddress.click();
        GmailAddress.sendKeys(email);
    }

    public void clicksetGmailPassword(String password) {
        GmailPassword.click();
        GmailPassword.sendKeys(password);
    }

    public void clicksetGmailPasswordAgain(String password) {
        GmailPasswordAgain.click();
        GmailPasswordAgain.sendKeys(password);
    }

    public void clickGmailMonth() {
        GmailMonth.click();
        driver.findElement(By.xpath(".//*[@id=':3']")).click();
    }

    public void clicksetGmailDay(String Day) {
        GmailDay.click();
        GmailDay.sendKeys(Day);
    }

    public void clicksetGmailYear(String Year) {
        GmailYear.click();
        GmailYear.sendKeys(Year);
    }

    public void clickGmailGender() {
        GmailGender.click();
        driver.findElement(By.xpath(".//*[@id=':f']")).click();

    }

    public void clicksetRecoverEmail(String recoverEmail) {
        RecoverEmail.click();
        RecoverEmail.sendKeys(recoverEmail);
    }

    public void clicksetCaptcha(String captcha) {
        Captcha.click();
        Captcha.sendKeys(captcha);
    }

    public void clickTerms() {
        Terms.click();
    }

    public void clickSubmit() {
        Submit.click();
    }


    //#FacebookFunctions
    public void clicksetFirstName(String firstName) {
        //webDriverOperations.click(FirstName);
        //webDriverOperations.setText(FirstName,firstName);
    }

    public void clicksetLastName(String lastName) {
        LastName.click();
        LastName.sendKeys(lastName);
    }


    public void clicksetEmail(String email) {
        Email.click();
        Email.sendKeys(email);
    }

    public void clicksetConfirmEmail(String reemail) {
        ConfirmEmail.click();
        ConfirmEmail.sendKeys(reemail);
    }

    public void clicksetPassword(String password) {
        Password.click();
        Password.sendKeys(password);
    }

    public void clicksetday() {
        Select dropdown = new Select(Select);
        dropdown.selectByValue("11");


    }

    public void clicksetMonth() {
        Select dropdown = new Select(Month);
        dropdown.selectByValue("3");

    }

    public void clicksetYear() {
        Select dropdown = new Select(Year);
        dropdown.selectByValue("1989");

    }

    public void clicksetSex() {
        Sex.click();

    }

    public void clickCreateAccount() {
        CreateAccount.click();
    }

    public void clickNext() {
        Next.click();

    }

    public void clickSkipStep() {
        SkipStep.click();
    }


}
