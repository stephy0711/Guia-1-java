package universidad;

import tienda.productos.Producto;

import java.util.ArrayList;

public class Facultad {
    private int cod;
    private String name;
    ArrayList<Profesor> teacherList = new ArrayList<>();

    ArrayList<Carrera> careerList = new ArrayList<>();
    public Facultad(){
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Profesor> getTeacherList() {
        return teacherList;
    }
    public ArrayList<Carrera> getCareerList() {
        return careerList;
    }
    public void setCareerList(ArrayList<Carrera> careerList) {
        this.careerList = careerList;
    }
    public void showTeachers(){
        System.out.println("-- Profesores de "+ getName() +" --");
        for(Profesor tchr : getTeacherList()){
            System.out.println("- "+ tchr.getCod());
        }
    }

    public void addTeacher( Profesor tch ){
        teacherList.add(tch);
    }

    public void addCareer( Carrera career ){
        careerList.add(career);
    }
    public void showCareers(){
        System.out.println("-- CARRERAS --");
        for(Carrera career : getCareerList()){
            System.out.println("- "+ career.getName());
        }
    }

    public void showCoursesofCareer(){
        for(Carrera cra : getCareerList() ){
            System.out.println(" | -- CARRERA "+ cra.getName() +" -- |");
            cra.showCourses();
        }
    }

    public Profesor teacherValidation( int teacherCode ){
        for (Profesor teacher: getTeacherList()){
            if (teacher.getCod() == teacherCode){
                return teacher;
            }
        }
        return null;
    }

    public Carrera careerValidation( int careerCode ){
        for (Carrera career : getCareerList()){
            if (career.getCod() == careerCode ){
                return career;
            }
        }
        return null;
    }

}
