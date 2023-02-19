package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;

import static java.nio.channels.FileChannel.open;

public class LoginPageTest {
    @AfterAll
    static void tearDown() { SQLHelper.CleanDatabase();
    }

    @Test
    @DisplayName("Should successfully login to dashboard page with valid login and password")
    void shouldSuccessfullyLogin() {
        var loginPage = open("http://localhost:9999", loginPage.class);
        var authInfo = DataHelper.getAuthInfoUseTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}
