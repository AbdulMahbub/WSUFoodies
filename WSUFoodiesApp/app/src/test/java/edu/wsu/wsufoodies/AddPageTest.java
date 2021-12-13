package edu.wsu.wsufoodies;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class AddPageTest {
    private AddPage test;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void onCreateTest() {
        test = new AddPage();
        assertEquals(null, test.userName);
    }
}