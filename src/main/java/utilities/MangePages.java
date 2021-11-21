package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageobjects.nopCommerce.ComputerPage;
import pageobjects.nopCommerce.HeaderMenuPage;
import pageobjects.nopCommerce.UpperHeaderPage;

public class MangePages extends Base {

    @Step("Business Flow: Initialize nopCommerce Elements from Page Objects")
    public static void init_nopCommerce(){
      nopCommerceLogin = PageFactory.initElements(driver,pageobjects.nopCommerce.LoginPage.class);
        nopCommerceMain = PageFactory.initElements(driver,pageobjects.nopCommerce.MainPage.class);
        upperheaderMenu = PageFactory.initElements(driver, UpperHeaderPage.class);
        HeaderMenu=  PageFactory.initElements(driver, HeaderMenuPage.class);
        computerMenu=  PageFactory.initElements(driver, ComputerPage.class);
        nopCommerceRegistration=PageFactory.initElements(driver, pageobjects.nopCommerce.RegisterPage.class);
        desktopPage=PageFactory.initElements(driver,pageobjects.nopCommerce.DesktopPage.class);
        cameraPhotoPage=PageFactory.initElements(driver,pageobjects.nopCommerce.Camera_PhotoPage.class);
        wishListPage=PageFactory.initElements(driver,pageobjects.nopCommerce.WishListPage.class);

    }

    @Step("Business Flow: Initialize Mobile Elements from Page Objects")
    public static void init_MobileApps(){
      eribankMainPage = new pageobjects.experitest.MainPage(MobileDriver);
      MortgageRequestPage = new pageobjects.experitest.MortgageRequestPage(MobileDriver);
        apiDemosMainPage= new pageobjects.ApiDemos.ApiDemosMainPage(MobileDriver);

    }

    @Step("Business Flow: Initialize ToDolist Elements from Page Objects")
    public static void init_ToDo(){
        todoMainPage = PageFactory.initElements(driver,pageobjects.todolist.MainPage.class);
    }

    @Step("Business Flow: Initialize Calculator Elements from Page Objects")
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver,pageobjects.calculator.calcMainPage.class);
    }

}
