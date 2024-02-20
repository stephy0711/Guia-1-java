package universidad;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Carrera {

    private int cod;
    private String name;
    private int totalCred;
    private int semester;
    private int lvl;
    ArrayList<Estudiante> studentList = new ArrayList<>();
    ArrayList<Cursos> coursesList = new ArrayList<>();

    public Carrera(int cod, String name, int totalCred, int semester, int lvl) {
        this.cod = cod;
        this.name = name;
        this.totalCred = totalCred;
        this.semester = semester;
        this.lvl = lvl;
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

    public int getTotalCred() {
        return totalCred;
    }

    public void setTotalCred(int totalCred) {
        this.totalCred = totalCred;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public ArrayList<Estudiante> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Estudiante> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Cursos> getCoursesList() {
        return coursesList;
    }

    public void showCourses(){
        for ( Cursos course : getCoursesList() ){
            System.out.println("- "+ course.getName() );
        }
    }
    public void addCourse( Cursos cour ){
        coursesList.add(cour);
    }

    public void changeCourseItem( Cursos course ){
        for (int i = 0; i < coursesList.size(); i++){
            if (coursesList.get(i).getCod() == course.getCod()){
                coursesList.set(i, course );
                break;
            }
        }
    }


}
