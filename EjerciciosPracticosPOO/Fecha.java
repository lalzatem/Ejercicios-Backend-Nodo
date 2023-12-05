package EjerciciosPracticosPOO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Crea una clase Fecha. La clase contendrá además de los constructores que consideres
 adecuados, métodos de acceso y el método toString, tal como lo explicamos en el ejercicio
 anterior, un método para comprobar si la fecha es correcta y otro para sumarle un día
 al valor actual de la fecha. Se debe investigar y utilizar la clase GregorianCalendar
 para implementar los métodos y constructores de Fecha
 */


public class Fecha  {

    private Calendar fecha;

    public Fecha() {
        this.fecha = Calendar.getInstance();
    }
    public Fecha(int dia,int mes,int anio) {
        this.fecha = new GregorianCalendar(anio, mes - 1, dia);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public boolean fechaEsCorrecta(String fecha, String formatoFecha){
        DateFormat fechaValida = new SimpleDateFormat(formatoFecha);
        fechaValida.setLenient(false);
        try{
            fechaValida.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public Calendar sumarUnDia(){
        fecha.add(Calendar.DAY_OF_MONTH, 1);
        return fecha;
    }


    @Override
    public String toString() {
        int dia = getFecha().get(GregorianCalendar.DAY_OF_MONTH);
        int mes = getFecha().get(GregorianCalendar.MONTH);
        int year= getFecha().get(Calendar.YEAR);
        return dia + "/" + mes + "/" + year;
    }
}
