package universidad;

public class Cursos {

    private int cod;
    private String name;
    private int credits;
    private int room;
    private String building;
    public int getCod() {
        return cod;
    }
    public Cursos(int cod, String name, int credits, int room, String building) {
        this.cod = cod;
        this.name = name;
        this.credits = credits;
        this.room = room;
        this.building = building;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
