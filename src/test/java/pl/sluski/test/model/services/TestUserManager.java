package pl.sluski.test.model.services;

import model.pojo.User;
import model.services.UserManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author Sluski
 */
public class TestUserManager {
    
    private User user;
    
    public TestUserManager() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new User("clientAddr", "clientSSID");
        UserManager.add(user);
    }
    
    @After
    public void tearDown() {
        UserManager.allUsers.clear();
    }

    @Test
    public void testFindBySSIDWithCorrectData(){
        Assert.assertTrue(UserManager.findBySSID("clientSSID") != null);
    }
    
    @Test
    public void testFindBySSIDWithUnexistSSID(){
        Assert.assertTrue(UserManager.findBySSID("nothing") == null);
    }
    
    @Test
    public void testFindByAddressWithCurrectData(){
        Assert.assertTrue(UserManager.findByAddress("clientAddr") != null);
    }
    
    @Test
    public void testFindByAddressWithUnexistSSID(){
        Assert.assertTrue(UserManager.findByAddress("nothing") == null);
    }
    
    @Test
    public void testUserExistWithCorrectData(){
        Assert.assertTrue(UserManager.userExist("clientAddr"));
    }
    
    @Test
    public void testUserExistWithIncorrectData(){
        Assert.assertFalse(UserManager.userExist("nothing"));
    }
    
    @Test 
    public void testRemoveUserIfExistWithRemoveOneUser(){
        UserManager.allUsers.clear();
        UserManager.add(user);
        UserManager.add(new User("otherAddr", "otherSSID"));
        UserManager.removeIfExist("otherAddr");
        Assert.assertEquals("Check if will remove user", 1, UserManager.allUsers.size());
    }
    
    @Test
    public void testRemoveUserIfExistWithoutRemove(){
        UserManager.allUsers.clear();
        UserManager.add(user);
        UserManager.add(new User("otherAddr", "otherSSID"));
        UserManager.removeIfExist("nothing");
        Assert.assertEquals("Check if don't remove user", 2, UserManager.allUsers.size());
    }
    
        @Test(expected = NullPointerException.class)
    public void testNullPointerExceptionOnAddUser() {
        UserManager.add(null);

    }

    @Test
    public void testAddUserWithCorrectData() {
        UserManager.add(user);
        Assert.assertEquals("Check list size is equal to 1", 2, UserManager.allUsers.size());
    }

    @Test
    public void testAddUserListSize() {
        UserManager.add(user);
        UserManager.add(user);
        UserManager.add(user);
        UserManager.add(user);
        Assert.assertEquals("Chech if four users were added to list", 5, UserManager.allUsers.size());
    }
}
