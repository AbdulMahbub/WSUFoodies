package edu.wsu.wsufoodies;

import static org.junit.Assert.*;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.HashMap;

import edu.wsu.wsufoodies.retrofitStuff.LoginResult;
import retrofit2.Response;

public class LoginPageTest {
    private LoginPage test;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void loginTest() {
        test = new LoginPage();
        assertNull(test.emailBox);
        assertNull(test.passwordBox);
    }
}