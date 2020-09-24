/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HealthRecord;

/* POJO for Doctor Information */

/**
 *
 * @author jagankaartik58
 */
public class Doctor 
{
    private String EID;
    private String Name;
    private String Gender;
    private String Education;
    private String Speciality;
    private String Certifications;

    /**
     * @return the EID
     */
    public String getEID() {
        return EID;
    }

    /**
     * @param EID the EID to set
     */
    public void setEID(String EID) {
        this.EID = EID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Education
     */
    public String getEducation() {
        return Education;
    }

    /**
     * @param Education the Education to set
     */
    public void setEducation(String Education) {
        this.Education = Education;
    }

    /**
     * @return the Speciality
     */
    public String getSpeciality() {
        return Speciality;
    }

    /**
     * @param Speciality the Speciality to set
     */
    public void setSpeciality(String Speciality) {
        this.Speciality = Speciality;
    }

    /**
     * @return the Certifications
     */
    public String getCertifications() {
        return Certifications;
    }

    /**
     * @param Certifications to set
     */
    
    public void setCerfitications(String Certifications) {
        this.Certifications = Certifications;
    }
}
