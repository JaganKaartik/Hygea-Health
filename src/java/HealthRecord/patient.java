/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HealthRecord;

/* POJO for Patient Information */

/**
 *
 * @author jagankaartik58
 */


public class Patient 
{ 
    private String PatientID;
    private String First_name;
    private String Last_name;
    private String DOB;
    private String BloodGroup;
    private String Address;
    private String Pincode;
    private String PhoneNumber;
    private String MaritalStatus;
    private String Age;
    private String Sex;
    
    /*
        
        Using in-built getter and setter methods 

    */

    /**
     * @return the PatientID
     */
    public String getPatientID() {
        return PatientID;
    }

    /**
     * @param PatientID the PatientID to set
     */
    public void setPatientID(String PatientID) {
        this.PatientID = PatientID;
    }

    /**
     * @return the First_name
     */
    public String getFirst_name() {
        return First_name;
    }

    /**
     * @param First_name the First_name to set
     */
    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    /**
     * @return the Last_name
     */
    public String getLast_name() {
        return Last_name;
    }

    /**
     * @param Last_name the Last_name to set
     */
    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the BloodGroup
     */
    public String getBloodGroup() {
        return BloodGroup;
    }

    /**
     * @param BloodGroup the BloodGroup to set
     */
    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Pincode
     */
    public String getPincode() {
        return Pincode;
    }

    /**
     * @param Pincode the Pincode to set
     */
    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    /**
     * @return the PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber the PhoneNumber to set
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * @return the MaritalStatus
     */
    public String getMaritalStatus() {
        return MaritalStatus;
    }

    /**
     * @param MaritalStatus the MaritalStatus to set
     */
    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    /**
     * @return the Age
     */
    public String getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
     */
    public void setAge(String Age) {
        this.Age = Age;
    }

    /**
     * @return the Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }
}
