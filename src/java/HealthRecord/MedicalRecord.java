/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthRecord;

/* POJO For Medical Records */

/**
 *
 * @author jagankaartik58
 */

public class MedicalRecord 
{	
   
   /*    Patient ID     */

   private String PatientID; //

   // Other Records

   private String Allergies; // 
   private String Medications; //
   private String Problems; // 
   private String Vaccinations;
   
   /* Vitals */
   
   private String Height; //
   private String Weight; // 
   private String BodyTemp; // 


   private String PulseRate;
   private String BPDiastolic;
   private String BPSystolic;

   //Other Medical History 

   private String PrevConsultation;
   private String Habits;
   private String SurgeryHistory;
   

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
     * @return the Allergies
     */
    public String getAllergies() {
        return Allergies;
    }

    /**
     * @param Allergies the Allergies to set
     */
    public void setAllergies(String Allergies) {
        this.Allergies = Allergies;
    }

    /**
     * @return the Medications
     */
    public String getMedications() {
        return Medications;
    }

    /**
     * @param Medications the Medications to set
     */
    public void setMedications(String Medications) {
        this.Medications = Medications;
    }

    /**
     * @return the Problems
     */
    public String getProblems() {
        return Problems;
    }

    /**
     * @param Problems the Problems to set
     */
    public void setProblems(String Problems) {
        this.Problems = Problems;
    }

    /**
     * @return the Height
     */
    public String getHeight() {
        return Height;
    }

    /**
     * @param Height the Height to set
     */
    public void setHeight(String Height) {
        this.Height = Height;
    }

    /**
     * @return the Weight
     */
    public String getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    /**
     * @return the Vaccinations
     */
    public String getVaccinations() {
        return Vaccinations;
    }

    /**
     * @param Vaccinations the Vaccinations to set
     */
    public void setVaccinations(String Vaccinations) {
        this.Vaccinations = Vaccinations;
    }

    /**
     * @return the BodyTemp
     */
    public String getBodyTemp() {
        return BodyTemp;
    }

    /**
     * @param BodyTemp the BodyTemp to set
     */
    public void setBodyTemp(String BodyTemp) {
        this.BodyTemp = BodyTemp;
    }

    /**
     * @return the PulseRate
     */
    public String getPulseRate() {
        return PulseRate;
    }

    /**
     * @param PulseRate the PulseRate to set
     */
    public void setPulseRate(String PulseRate) {
        this.PulseRate = PulseRate;
    }

    /**
     * @return the BPDiastolic
     */
    public String getBPDiastolic() {
        return BPDiastolic;
    }

    /**
     * @param BPDiastolic the BPDiastolic to set
     */
    public void setBPDiastolic(String BPDiastolic) {
        this.BPDiastolic = BPDiastolic;
    }

    /**
     * @return the BPSystolic
     */
    public String getBPSystolic() {
        return BPSystolic;
    }

    /**
     * @param BPSystolic the BPSystolic to set
     */
    public void setBPSystolic(String BPSystolic) {
        this.BPSystolic = BPSystolic;
    }

    /**
     * @return the PrevConsultation
     */
    public String getPrevConsultation() {
        return PrevConsultation;
    }

    /**
     * @param PrevConsultation the PrevConsultation to set
     */
    public void setPrevConsultation(String PrevConsultation) {
        this.PrevConsultation = PrevConsultation;
    }

    /**
     * @return the Habits
     */
    public String getHabits() {
        return Habits;
    }

    /**
     * @param Habits the Habits to set
     */
    public void setHabits(String Habits) {
        this.Habits = Habits;
    }

    /**
     * @return the SurgeryHistory
     */
    public String getSurgeryHistory() {
        return SurgeryHistory;
    }

    /**
     * @param SurgeryHistory the SurgeryHistory to set
     */
    public void setSurgeryHistory(String SurgeryHistory) {
        this.SurgeryHistory = SurgeryHistory;
    }

}
