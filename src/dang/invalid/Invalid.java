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
        if (registrationID.length() > 10){
            return false;
        }
        return true;
    }
}
