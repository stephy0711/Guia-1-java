package universidad;

import java.util.ArrayList;

public class Universidad {
    private String name;
    private  String rector;
    private String city;

    private ArrayList<Facultad> facultyList = new ArrayList<>();

    public Universidad(){
    }
    public Universidad(String name, String rector, String city){
        this.name = name;
        this.rector = rector;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Facultad> getFacultyList() {
        return facultyList;
    }


    public void addFacultad(Facultad fct){
        getFacultyList().add(fct);
    }
    public void getInfoUni(){
        System.out.println("Bienvenido a la "+ name);
        System.out.println("Rector: "+ rector);
        System.out.println("Radicada en "+city);
    }

    public void showFacultyList(){
        System.out.println("""
                    -------------------
                        FACULTADES
                    -------------------
                    """);
        for (Facultad faculty : getFacultyList()){
            System.out.println(faculty.getName() + "\n");
        }
    }

    public Facultad searchFaculty(int facultyCode){
        for (Facultad faculty : getFacultyList()){
            if ( faculty.getCod() == facultyCode){
                    return faculty;
            }
        }

        return null;
    }

    public void searchAndChangeCareer( Carrera cre ){
        for ( Facultad fac : getFacultyList() ){
            ArrayList<Carrera> list = fac.getCareerList();
            for ( int j =0; j < list.size(); j++){
                if (list.get(j).getCod() == cre.getCod()){
                    list.set( j, cre );
                    changeFacultyItem( fac );
                    break;
                }
            }
        }
    }

    public void changeFacultyItem( Facultad faculty ){
        for (int i = 0; i < facultyList.size(); i++){
            if (facultyList.get(i).getCod() == faculty.getCod()){
                facultyList.set(i, faculty );
                break;
            }
        }
    }

    public void showCareersOfFaculty(){
        for (Facultad faculty : getFacultyList()){
            System.out.println("/** "+faculty.getName()+" **/");
            faculty.showCareers();
        }
    }

    public void callCourses(){
        for (Facultad faculty : getFacultyList()){
            faculty.showCoursesofCareer();
        }
    }

    public Profesor callTeacherValidation( int teacherCod ){
        for ( Facultad faculty : getFacultyList() ) {
            return faculty.teacherValidation(teacherCod);
        }
        return null;
    }

    public Carrera callCareerValidation( int careerCod ){
        for ( Facultad faculty : getFacultyList() ) {
            return faculty.careerValidation(careerCod);
        }
        return null;
    }

    public void callStudents(){
        for( Facultad faculty : getFacultyList() ){
            for ( Carrera career : faculty.getCareerList() ){
                System.out.println(" -- Carrera "+ career.getName() + " --");
                for ( Estudiante student : career.getStudentList() ){
                    System.out.println("- "+ student.getCedula() );
                }
            }
        }
    }

    public Carrera callValidateCareer( int codCareer ){
        for( Facultad faculty : getFacultyList() ){
            for ( Carrera career : faculty.getCareerList() ){
                if (career.getCod() == codCareer){
                    return career;
                }
            }
        }
        return null;
    }

}
