package movieApp.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public static User newUser = new User("name", "password", "admin");

    @Test
    void testGetName(){
        assertEquals("name", newUser.getName());
    }

    @Test
    void testSetName(){
        newUser.setName("newname");
        assertEquals("newname", newUser.getName());
    }

    @Test
    void testGetPassword(){
        assertEquals("newpassword", newUser.getPassword());
    }

    @Test
    void testSetPassword(){
        newUser.setPassword("newpassword");
        assertEquals("newpassword", newUser.getPassword());
    }

    @Test
    void testGetUserType(){
        assertEquals("customer", newUser.getUserType());
    }

    @Test
    void testSetUserType(){
        newUser.setUserType("customer");
        assertEquals("customer", newUser.getUserType());
    }


}