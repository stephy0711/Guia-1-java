package tienda.productos;

import java.time.LocalDate;

public class Producto {

    private String cod;
    private String name;
    private int type;
    
    private LocalDate dateExpired;
    private String manufactr;

    private int count;
    private double price;

    public Producto(int type,String cod, String name, LocalDate dateExpired, String manufactr, int count, double price) {
        this.cod = cod;
        this.name = name;
        this.type = type;
        this.dateExpired = dateExpired;
        this.manufactr = manufactr;
        this.count = count;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public LocalDate getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(LocalDate dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getManufactr() {
        return manufactr;
    }

    public void setManufactr(String manufactr) {
        this.manufactr = manufactr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
