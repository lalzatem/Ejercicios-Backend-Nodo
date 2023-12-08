package EjerciciosMapasArrayLists;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

/*
    Programa que lea una serie de valores numéricos enteros desde el teclado
    y los guarde en un ArrayList de tipo Integer. La lectura de números enteros
    termina cuando se introduce el valor -99. Este valor no se guarda en el ArrayList.
    A continuación el programa mostrará por pantalla el número de valores que se han
    leído, su suma y su media. Por último se mostrará un listado de los números
    que estén sobre la media
*/

public class SumaMediaListas {
    public static void main(String[] args){
        suma_media();
    }

    public static void suma_media(){
        List<Double> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        boolean continua;

        System.out.println("Ingresa los números, para dejar de introducir los valores escriba -99: ");
        do {
            try{
                continua = false;
                num = scanner.nextDouble();
                lista.add(num);
            } catch (InputMismatchException ex){
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                scanner.next();
                continua = true;
            }
        } while (continua || num != -99);

        lista.remove(lista.size()-1);
        System.out.println("Lista: "+lista);

        //suma
        double suma = lista.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Suma de la lista: "+suma);

        //media
        OptionalDouble media = lista.stream().mapToDouble(Double::doubleValue).average();
        System.out.println("Media de la lista: "+media.getAsDouble());

        //cant num sobre la media
        long contSobreMedia = lista.stream().filter(list -> list > media.getAsDouble()).count();
        System.out.println("Cantidad de numeros sobre la media: "+contSobreMedia);

        //print de num sobre la media
        List<Double> numSobreMedia = lista.stream().filter(list -> list > media.getAsDouble()).toList();
        System.out.println("Numeros sobre la media: "+numSobreMedia);
    }

}
