/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.invalid;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Invalid implements Serializable{
    public boolean checkRegistrationID (String registrationID){
        if (registrationID.length() <= 10 && registrationID.length() > 0 && registrationID.matches("\\w+")){
            return true;
        }
        return false;
    }
    public boolean checkFullName(String fullName){
        if (fullName.length() > 0 && fullName.length() <= 50){
            return true;
        }
        return false;
    }
    
    public boolean checkEmail(String email){
        if (email.matches("\\w+@\\w+[.]\\w+") && email.length() <= 30 && email.length() > 0 || email.matches("\\w+@\\w+[.]\\w+[.]\\w+")) {
            return true;
        }
        return false;
    }
    
    public boolean checkPhone(String phone){
        if (phone.length() > 0 && phone.length() <= 15 && phone.matches("\\d+")){
            return true;
        }
        return false;
    }
    
    public boolean checkNumberOfChildren(int numberOfChildren){
        if (numberOfChildren >= 0){
            return true;
        }
        return false;
    }
    
    public boolean checkNumberOfAdults(int numberOfAdults){
        if (numberOfAdults >= 0){
            return true;
        }
        return false;
    }
    
    public boolean checkTotalMember(int numberOfAdults, int numberOfChildren, int numberOfMembers){
        if ((numberOfAdults + numberOfChildren) == numberOfMembers){
            return true;
        }
        return false;
    }
    
    public boolean checkAddress(String address){
        if (address.length() > 0 && address.length() <= 500){
            return true;
        }
        return false;
    }
}
