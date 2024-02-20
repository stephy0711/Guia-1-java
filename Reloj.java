package reloj;

public class Reloj {
    private short seconds;
    private short minutes;
    private short hour;

    public Reloj(){
    }

    public Reloj( short seconds, short minutes, short hour ){
        this.seconds = seconds;
        this.minutes = minutes;
        this.hour = hour;
    }

    public short getSeconds() {
        return seconds;
    }

    public void setSeconds(short seconds) {
        this.seconds = seconds;
    }

    public short getMinutes() {
        return minutes;
    }

    public void setMinutes(short minutes) {
        this.minutes = minutes;
    }

    public short getHour() {
        return hour;
    }

    public void setHour(short hour) {
        this.hour = hour;
    }

    public void validateTime(String[] arr){

        Short[] shr = new Short[3];
        for (int j = 0; j < 3; j++) {
            if (j < arr.length){
                if (j == 0 && Short.parseShort(arr[j]) <= 24){
                    shr[j] = Short.parseShort(arr[j] );
                }else{
                    System.out.println(" -- Hora invalida -- ");
                }
                if (j == 1 && Short.parseShort(arr[j]) <= 60){
                    shr[j] = Short.parseShort(arr[j] );
                    System.out.println(" -- Minutos invalida -- ");
                }
                if (j == 2 && Short.parseShort(arr[j]) <= 60){
                    shr[j] = Short.parseShort(arr[j] );
                    System.out.println(" -- Segundos invalida -- ");
                }
            }else{
                shr[j] = 0;
            }
        }
        setHour(shr[0]);
        setMinutes(shr[1]);
        setSeconds(shr[2]);

    }

}
