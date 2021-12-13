package edu.wsu.wsufoodies;

import static org.junit.Assert.*;
import static edu.wsu.wsufoodies.User.Standing.SENIOR;

import org.junit.Test;

public class UserTest {

    @Test
    public void unitTest() {
        User test = new User("Chris", "George", "1234", "chris@gmail.com", SENIOR);
        assertEquals("Chris", test.getFirstName());
        assertEquals("George", test.getLastName());
        assertEquals("1234", test.getPassword());
        assertEquals("chris@gmail.com", test.getEmail());
        assertEquals(SENIOR, test.getStanding());
    }
}