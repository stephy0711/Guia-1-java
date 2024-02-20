package proyectil;

public class Proyectil {
    private double velocidad;
    private double angulo;

    public Proyectil(){
        this.velocidad = 0;
        this.angulo = 0;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double calcDistancia(){
        double anguloRadianes = Math.toRadians(angulo);
        return (Math.pow(velocidad, 2) * Math.sin(2 * anguloRadianes)) / 9.81; // Fórmula de distancia horizontal
    }

    public double calcAlturaMax(){
        double anguloRadianes = Math.toRadians(angulo);
        return Math.pow(velocidad * Math.sin(anguloRadianes), 2) / (2 * 9.81); //Formula altura maxima
    }

    public void printResultados(){
        System.out.println("Velocidad: "+ velocidad + " m/s");
        System.out.println("Angulo: "+ angulo + " grados");
        System.out.println("Distancia recorrida: "+ calcDistancia());
        System.out.println("Altura maxima alcanzada: "+ calcAlturaMax());
    }

}
