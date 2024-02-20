//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import fecha.Fecha;
import fraccionario.Fraccionario;
import proyectil.Proyectil;
import reloj.Reloj;
import tienda.Tienda;
import tienda.productos.Producto;
import universidad.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        // Objetos
        Fraccionario frc = new Fraccionario();
        Reloj rlj = new Reloj();
        Fecha dte = new Fecha();
        Proyectil pry = new Proyectil();
        Tienda tnd = new Tienda();
        ArrayList<Producto> alm = new ArrayList<>();
        Universidad uni = new Universidad("Universidad EAN", "Hector Mora", "Bogota");
        Scanner input = new Scanner(System.in);
        // Variables globales
        String number = "";
        String info;
        String[] res;
        ArrayList<String> infoProduct = new ArrayList<>();
        String str;
        Boolean bool;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(!number.equals("n")){
            info = """
                ---------------------------------------------
                    WELCOME! EJERCICIO DE MODELADO DE CLASE
                ---------------------------------------------
                1. Ejercicio Fraccionario
                2. Ejercicio Reloj
                3. Ejercicio Fecha
                4. Ejercicio Proyectil
                5. Ejercico Tienda
                6. Ejercicio Universidad
                Ingrese el numero del ejercicio que quiera visualizar, si desea terminar pulse "n"
                Ejercicio:""";
            System.out.println(info);
            number = input.nextLine().trim();
            if (number.length() == 1){
                Scanner scr = new Scanner(System.in);
                switch (number){
                    case "1":
                         info = """
                            -----------------------------
                                EJERCICIO FRACCIONARIO
                            -----------------------------
                            Fraccion guardada anteriormente:""";
                        System.out.println(info);
                        System.out.println("Numerador: "+ frc.getNumerador());
                        System.out.println("Denominador: "+ frc.getDenominador());
                        info = """
                            Ingrese el fraccionario a guardar (recuerde separar con un / )
                            Recordemos que el denominador no puede ser 0
                            Fraccionario:""";
                        System.out.println(info);
                       try{
                           res = scr.nextLine().split("/");
                           if (res.length >= 3){
                               System.out.println("Monto invalido");
                           }else{
                               frc.setNumerador(Integer.parseInt(res[0]));
                               frc.setDenominador(Integer.parseInt(res[1]));
                           }
                       }catch(Exception e){
                           System.out.println("-- FORMATO INVALIDO --");
                       }
                        break;
                    case "2":
                        info = """
                                ------------------------
                                    EJERCICIO RELOJ
                                ------------------------
                                Hora guardada con anterioridad:
                                """;
                        System.out.println(info);
                        System.out.println("Hours: "+ rlj.getHour());
                        System.out.println("Minutes: "+ rlj.getMinutes());
                        System.out.println("Seconds: "+ rlj.getSeconds());
                        info = """
                                Ingrese el tiempo que desee guardar,
                                el formato debe ser HH:mm:ss
                                """;
                        System.out.println(info);
                        str = scr.nextLine();
                        Pattern pattern = Pattern.compile("[,.<>;'\"\"\\[\\]\\\\|/_-]");
                        Matcher matcher = pattern.matcher(str);
                        if(!matcher.find()){
                            res = str.trim().split(":");
                            rlj.validateTime(res);
                            System.out.println("Guardando exitoso...");
                        }else{
                            System.out.println("-- Formato no valido --");
                        }
                        break;
                    case "3":
                        info = """
                                ------------------------
                                    EJERCICIO FECHA
                                ------------------------
                                Fecha guardada anteriormente:
                                """;
                        System.out.println(info);
                        System.out.println("Date: "+ dte.getDate());
                        info = """
                                Favor ingrese la fecha a guardar
                                el formato es dd/MM/YYYY
                                """;
                        System.out.println(info);
                        str = scr.nextLine();
                        bool = validateDate(str);
                        if (!bool){
                            System.out.println("--- FORMATO INVALIDO INGRESE DE NUEVO ---");
                        }else{
                            dte.setDate(LocalDate.parse(str,format));
                            System.out.println("Guardando exitoso...");
                        }
                        break;
                    case "4":
                        System.out.println("""
                                ---------------------------
                                    EJERCICIO PROYECTIL
                                ---------------------------
                                Informacion anterior: 
                                """);
                        pry.printResultados();
                        try{
                            System.out.println("Ingrese la velocidad del proyectil");
                            pry.setVelocidad(scr.nextDouble());
                            System.out.println("Ingrese el angulo en el que fue lanzado el proyectil");
                            pry.setAngulo(scr.nextDouble());
                            System.out.println("Guardando exitoso...");
                        }catch( Exception e ){
                            System.out.println("-- FORMATO INCORRECTO --");
                        }
                        break;
                    case "5":
                        System.out.println("""
                                /---------------------------/
                                    PRODUCTOS GUARDADOS
                                /--------------------------/
                                """);
                        for (Producto producto : alm){
                            System.out.println("Nombre: "+ producto.getName() + "\nPrecio: "+ producto.getPrice() + "\nCantidad: "+ producto.getCount() + "\nFecha de caducidad: "+ producto.getDateExpired() + "\nFabricante: "+ producto.getManufactr() + "\nCodigo: "+ producto.getCod() + "\nTipo: "+ producto.getType() + "\n");
                        }
                        info = """
                                -----------------------------
                                    EJERCICIO DE LA TIENDA
                                -----------------------------
                                """;
                        System.out.println(info);
                        System.out.println("Ingrese el nombre de la tienda: ");
                        tnd.setName(scr.nextLine());
                        System.out.println("Ingrese la direccion de la tienda: ");
                        tnd.setAddres(scr.nextLine());
                        System.out.println("Ingrese el telefono de contacto de la tienda");
                        tnd.setPhone(scr.nextLine());
                        bool = true;
                        while(bool == true){
                            System.out.println("""
                                /*******************************/
                                            BIENVENIDO 
                                /*******************************/
                                """);
                            System.out.println("Le agradecemos de elegir a "+ tnd.getName());
                            System.out.println("Si desea contactarnos mas adelante estamos ubicados en: "+tnd.getAddres());
                            System.out.println("Y nuestro telefono es: "+ tnd.getPhone());
                            System.out.println("""
                                Que producto desea almacenar hoy? digite el numero porfavor
                                1. Lacteo
                                2. Carnico,
                                3. Fruta
                                4. Enlatado
                                """);
                            ArrayList answUser = new ArrayList<>();
                            str = scr.nextLine();
                            try{
                                if (Integer.parseInt(str) <= 4 && Integer.parseInt(str)  >= 1) {
                                    answUser.add(Integer.parseInt(str));
                                    System.out.println("Porfavor digite el codigo del producto:");
                                    answUser.add(scr.nextLine());
                                    System.out.println("Porfavor ingrese el nombre del producto");
                                    answUser.add(scr.nextLine());
                                    System.out.println("Porfavor ingrese la fecha de expiración con el formato dd/MM/YYYY");
                                    String dateExp = scr.nextLine();
                                    boolean isDate = validateDate(dateExp);
                                    if (isDate == true) {
                                        System.out.println("Ingrese el nombre del fabricante");
                                        answUser.add(scr.nextLine());
                                        System.out.println("Ingrese la cantidad que se va a almacenar del producto");
                                        answUser.add(scr.nextLine());
                                        System.out.println("Por ultimo, ingrese le precio por unidad del producto");
                                        answUser.add(scr.nextDouble());
                                            Producto prd = new Producto(
                                                    Integer.parseInt(answUser.get(0).toString()),
                                                    answUser.get(1).toString(),
                                                    answUser.get(2).toString(),
                                                    LocalDate.parse(dateExp, format),
                                                    answUser.get(3).toString(),
                                                    Integer.parseInt(answUser.get(4).toString()),
                                                    Double.parseDouble(answUser.get(5).toString())
                                            );
                                        alm.add(prd);
                                        System.out.println("Guardando exitoso...");
                                    }
                                }
                            }catch(Exception e){
                                System.out.println("-- SE PRESENTO UN ERROR AL PROCESAR EL DATO --");
                                System.out.println(" -- INTENTE DE NUEVO --");
                                System.out.println(e.getMessage());
                            }

                        }

                        break;
                    case "6":
                        System.out.println("""
                                --------------------------------
                                    EJERCICIO UNIVERSIDAD
                                --------------------------------
                                """);
                        ArrayList<String> answers = new ArrayList<>();
                        uni.getInfoUni();
                        bool = true;
                        while(bool == true){
                            try{
                                System.out.println("""
                                    Que desea seleccionar:
                                    1. Facultades
                                    2. Profesores
                                    3. Carreras
                                    4. Cursos
                                    5. Estudiantes
                                    """);
                                str = scr.nextLine();
                                switch (str){
                                    case "1":
                                        uni.showFacultyList();
                                        System.out.println("""
                                            Desea agregar una facultad?
                                            1 para Si
                                            2 para No
                                            """);
                                        if (scr.nextLine().equals("1")) {
                                            Facultad fct = new Facultad();
                                            System.out.println("Ingrese el codigo numerico de la facultad:");
                                            fct.setCod(Integer.parseInt(scr.nextLine()));
                                            System.out.println("Ingrese el nombre de la facultad:");
                                            fct.setName(scr.nextLine());
                                            System.out.println("Guardando...");
                                            uni.addFacultad(fct);
                                            System.out.println("Guardado con exito");
                                        }
                                        break;
                                    case "2":
                                        answers.clear();
                                        System.out.println("-- PROFESORES --");
                                        ArrayList<Facultad> facts = uni.getFacultyList();
                                        for(Facultad fct : facts){
                                            fct.showTeachers();
                                        }
                                        System.out.println("""
                                                Desea agregar otro profesor?
                                                1 para Si
                                                2 para No
                                                """);
                                        if (scr.nextLine().equals("1")){
                                            System.out.println("Ingrese el codigo numerico del profesor");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese la profesion del profesor, si tiene mas de una separarlo por ,");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese la nacionalidad el profesor");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el salario del docente sin ningun punto ni coma");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el codigo de la facultad a la que pertenece");
                                            answers.add(scr.nextLine());
                                            System.out.println("Guardando...");
                                            Facultad existFaculty = uni.searchFaculty(
                                                    Integer.parseInt( answers.get( answers.size() - 1).toString() )
                                            );
                                            if (existFaculty != null){
                                                Profesor teacher = new Profesor(
                                                        Integer.parseInt(answers.get(0).toString()),
                                                        answers.get(1).toString(),
                                                        answers.get(2).toString(),
                                                        Double.parseDouble( answers.get(3).toString() )
                                                );
                                                existFaculty.addTeacher(teacher);
                                                uni.changeFacultyItem( existFaculty );
                                                System.out.println("Guardado con exito!");
                                            }else{
                                                System.out.println("-- VERIFIQUE LOS DATOS INGRESADOS -- ");
                                            }

                                        }
                                        break;
                                    case "3":
                                        answers.clear();
                                        uni.showCareersOfFaculty();
                                        System.out.println("""
                                                Desea agregar otra carrera?
                                                1 para Si
                                                2 para No
                                                """);
                                        if (scr.nextLine().equals("1")){
                                            System.out.println("Digite el codigo numerico de la carrera");
                                            answers.add(scr.nextLine());
                                            System.out.println("Digite el nombre de la carrera");
                                            answers.add(scr.nextLine());
                                            System.out.println("Digite el total de creditos de la carrera");
                                            answers.add(scr.nextLine());
                                            System.out.println("Digite de semestres que tiene la carrera");
                                            answers.add(scr.nextLine());
                                            System.out.println("""
                                                    Es una carrera de Pregrado o Postgrado?
                                                    1 Para Pregrado
                                                    2 Para Postgrado
                                                    """);
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el codigo de la facultad a la que pertenece la carrera");
                                            answers.add(scr.nextLine());
                                            System.out.println("Guardando...");
                                            Carrera career = new Carrera(
                                                    Integer.parseInt( answers.get(0).toString() ),
                                                    answers.get(1).toString(),
                                                    Integer.parseInt( answers.get(2).toString() ),
                                                    Integer.parseInt( answers.get(3).toString() ),
                                                    Integer.parseInt( answers.get(4).toString() )
                                            );
                                            Facultad existFaculty = uni.searchFaculty(
                                                    Integer.parseInt( answers.get( answers.size() - 1).toString() )
                                            );
                                            if (existFaculty != null){
                                                existFaculty.addCareer( career );
                                                uni.changeFacultyItem( existFaculty );
                                                System.out.println("Guardado con exito!");
                                            }else{
                                                System.out.println("-- VERIFIQUE LOS DATOS INGRESADOS -- ");
                                            }
                                        }
                                        break;
                                    case "4":
                                        answers.clear();
                                        uni.callCourses();
                                        System.out.println("""
                                                Desea agregar otro curso?
                                                1 para Si
                                                2 para No
                                                """);
                                        if (scr.nextLine().equals("1")){
                                            System.out.println("Ingrese el codigo del curso");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el nombre del curso");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese los creditos del cursos");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el salon donde se ve el curso");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el edificio donde se dictara el curso");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el codigo del profesor que lo dicta");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el codigo a la carrera que pertenece");
                                            answers.add(scr.nextLine());
                                            System.out.println("Guardando...");
                                            Cursos course = new Cursos(
                                                    Integer.parseInt(answers.get(0).toString()),
                                                    answers.get(1).toString(),
                                                    Integer.parseInt(answers.get(2).toString()),
                                                    Integer.parseInt(answers.get(3).toString()),
                                                    answers.get(4).toString()
                                            );
                                            Profesor teacher = uni.callTeacherValidation( Integer.parseInt( answers.get( answers.size() - 2 ).toString() ) );
                                            Carrera career = uni.callCareerValidation( Integer.parseInt( answers.get( answers.size() - 1 ).toString() ) );
                                            if (  teacher != null && career != null){
                                                career.addCourse( course );
                                                career.changeCourseItem( course );
                                                uni.searchAndChangeCareer( career );
                                                System.out.println("Guardado con exito!");
                                            }else{
                                                System.out.println("-- VERIFIQUE LOS DATOS DE INGRESO --");
                                            }

                                        }
                                        break;
                                    case "5":
                                        answers.clear();
                                        uni.callStudents();
                                        System.out.println("""
                                                Desea agregar otro curso?
                                                1 para Si
                                                2 para No
                                                """);
                                        if (scr.nextLine().equals("1")){
                                            System.out.println("Ingrese la cedula del estudiante");
                                            answers.add(scr.nextLine());
                                            System.out.println("La fecha de nacimiento del estudiante en formato dd/MM/YYYY");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese la ciudad de nacimiento");
                                            answers.add(scr.nextLine());
                                            System.out.println("Departamento de nacimiento");
                                            answers.add(scr.nextLine());
                                            System.out.println("Pais de nacimiento");
                                            answers.add(scr.nextLine());
                                            System.out.println("Escuela en la que se graduo");
                                            answers.add(scr.nextLine());
                                            System.out.println("Fecha de ingreso del estudiante en formato dd/MM/YYYY");
                                            answers.add(scr.nextLine());
                                            System.out.println("Ingrese el codigo de la carrera a la que pertenece");
                                            answers.add(scr.nextLine());
                                            System.out.println("Guardando...");
                                            LocalDate bornDate = LocalDate.parse(answers.get(1).toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                            LocalDate initDate = LocalDate.parse(answers.get(6).toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                            int comparateDates = bornDate.compareTo(initDate);
                                            if ( comparateDates < 0 ) {
                                                Estudiante student = new Estudiante(
                                                        Integer.parseInt(answers.get(0).toString()),
                                                        bornDate,
                                                        answers.get(2).toString(),
                                                        answers.get(3).toString(),
                                                        answers.get(4).toString(),
                                                        answers.get(5).toString(),
                                                        initDate
                                                );
                                                Carrera career = uni.callValidateCareer( Integer.parseInt( answers.get( answers.size() - 1 ) ) );
                                                if ( career != null ){
                                                    career.getStudentList().add(student);
                                                    uni.searchAndChangeCareer( career );
                                                    System.out.println("Guardado con exito!");
                                                }else{
                                                    System.out.println("-- VERIFIQUE LOS DATOS DE INGRESO --");
                                                }
                                            }else{
                                                System.out.println("-- FECHAS INVALIDAS --");
                                            }


                                        }
                                        break;

                                }
                            }catch(Exception e){
                                System.out.println("-- ERROR INTENTE DE NUEVO --");
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                }
            }else{

                System.out.println("""
                        ------------------------------
                            CARACTER INVALIDO
                        ------------------------------""");

            }

        }
    }

    private static boolean validateDate ( String str ){
        Pattern pattern = Pattern.compile("[,.<>;'\"\"\\[\\]\\\\|_:-a-zA-Z]");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return false;
        }
        String[] val = str.split("/");
        if (val.length > 3) {
            return false;
        }
        for (int i = 0; i < val.length; i++) {
            if(i == 0 && Integer.parseInt(val[i]) > 31) {
                return false;
            }
            if(i == 1 && Integer.parseInt(val[1]) > 12){
                return false;
            }
            if(i == 2 &&  Integer.parseInt(val[2]) > 2024){
                return false;
            }
        }
        return true;
    }

}