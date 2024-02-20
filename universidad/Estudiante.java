package universidad;

import java.time.LocalDate;

public class Estudiante extends Persona{


    private String school;
    private LocalDate entryDate;

    public Estudiante(int cedula, LocalDate birthDate, String city, String department, String country, String school, LocalDate entryDate) {
        super(cedula, birthDate, city, department, country);
        this.school = school;
        this.entryDate = entryDate;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

}
