package onlinereservationsystem;

public class Login {
    public boolean validateLogin(String username,String password) {
        String correctusername="admin";
        String correctpassword="tiger";
        if(username.equals(correctusername) && password.equals(correctpassword)) 
            return true;
         else
            return false;
    }
}
