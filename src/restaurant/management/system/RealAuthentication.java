    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

/**
 *
 * @author Amr AlEskndrany
 */
       //Proxy Pattern
public class RealAuthentication implements Authentication {
     @Override
    public void authenticate(String password) throws Exception {
        String correctPassword = "admin123"; // كلمة المرور الصحيحة
        if (!password.equals(correctPassword)) {
            throw new Exception("Invalid password. Access denied.");
        }
    }
}
