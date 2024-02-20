package universidad;

public class Profesor {

    private int cod;
    private String profession;
    private String nationality;
    private double salary;

    public Profesor(){
    }
    public Profesor(int cod, String profession, String nationality, double salary) {
        this.cod = cod;
        this.profession = profession;
        this.nationality = nationality;
        this.salary = salary;
    }
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
