/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RegistrationDTO implements Serializable{

    private String registrationID;
    private String fullName;
    private int age;
    private boolean gender;
    private String email;
    private String phone;
    private String address;
    private int numberOfMember;
    private int numberOfChildren;
    private int numberOfAdults;

    public RegistrationDTO() {
    }
     
    public RegistrationDTO(String registrationID, String fullName, int age, boolean gender, String email, String phone, String address, int numberOfMember, int numberOfChildren, int numberOfAdults) {
        this.registrationID = registrationID;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.numberOfMember = numberOfMember;
        this.numberOfChildren = numberOfChildren;
        this.numberOfAdults = numberOfAdults;
    }

    

    /**
     * @return the registrationID
     */
    public String getRegistrationID() {
        return registrationID;
    }

    /**
     * @param registrationID the registrationID to set
     */
    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the numberOfMember
     */
    public int getNumberOfMember() {
        return numberOfMember;
    }

    /**
     * @param numberOfMember the numberOfMember to set
     */
    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    /**
     * @return the numberOfChildren
     */
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * @param numberOfChildren the numberOfChildren to set
     */
    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    /**
     * @return the numberOfAdults
     */
    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * @param numberOfAdults the numberOfAdults to set
     */
    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
    
    @Override
    public String toString() {
        String replaceAddress = address.replaceAll("\\n", ".!.!");
        return registrationID + "," + fullName + "," + age + "," + gender + "," + email + "," + phone + "," + replaceAddress + "," + numberOfMember + "," + numberOfChildren + "," + numberOfAdults;
    }
}
