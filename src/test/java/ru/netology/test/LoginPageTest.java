package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;

import static ru.netology.data.SQLHelper.cleanDatabase;


public class LoginPageTest {

   @AfterAll
  static void tearDown() {
       cleanDatabase();
   }

 //  @Test
   //@DisplayName("Should get error notification if user is not valid")
   //void shouldGetErrorIfWrongUser(){
     //  var loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
       //var authInfo = DataHelper.generateUser();
       //loginPage.validLogin(authInfo);
       //loginPage.verifyErrorNotificationVisibility();
   //}

    @Test
    @DisplayName("Should successfully login to dashboard page with valid login and password")
    void shouldSuccessfullyLogin() {
        var loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfoUseTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}
