package nirmesh.ndtv.detailslist;

/**
 * Created by asd on 2016-05-09.
 */
public class PatientDetail {

    public String name, diagnosis, symptoms, medication, toBetaken, comments, knownDisease, doctor, specialty;
    public int id;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKnownDisease() {
        return knownDisease;
    }

    public void setKnownDisease(String knownDisease) {
        this.knownDisease = knownDisease;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getToBetaken() {
        return toBetaken;
    }

    public void setToBetaken(String toBetaken) {
        this.toBetaken = toBetaken;
    }
}
