package universidad;

import java.time.LocalDate;

public class Persona {


    private int cedula;
    private LocalDate birthDate;
    private String city;
    private String department;
    private String country;

    public Persona(int cedula, LocalDate birthDate, String city, String department, String country) {
        this.cedula = cedula;
        this.birthDate = birthDate;
        this.city = city;
        this.department = department;
        this.country = country;
    }
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
