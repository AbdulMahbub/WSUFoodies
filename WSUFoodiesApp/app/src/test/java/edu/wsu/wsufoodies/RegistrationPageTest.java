package edu.wsu.wsufoodies;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class RegistrationPageTest {
    private RegistrationPage test;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void standingsTest() {
        test = new RegistrationPage();
        assertEquals("JUNIOR", test.standings[2]);
        assertEquals("SENIOR", test.standings[3]);
    }
}