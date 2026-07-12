package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
   
   
    
    @DataProvider(name = "invalidLogin")
    public Object[][] invalidLogin() {
        return new Object[][]{
            
            {"wrongUserName", "Password@123","Error!"},
            
            {"wrongUserName", "","Error!"},

            {"", "Password@123","Error!"},

            {"","","Error!"}
        };
    }

 
}
