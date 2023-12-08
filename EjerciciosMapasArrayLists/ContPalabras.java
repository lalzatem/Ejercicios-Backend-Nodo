package EjerciciosMapasArrayLists;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.stream.Collectors;

/*
    Ejercicio:
    Contador de palabras
    Escribe un programa en Java que cuente la cantidad de
    veces que aparece cada palabra en una cadena de texto
    y las muestre en orden descendente de frecuencia.
*/
public class ContPalabras {
    public static void main(String[] args) {
        contadorPalabras();
    }

    public static void contadorPalabras(){
        System.out.print("Ingresa una cadena de texto: ");

        Scanner scanner= new Scanner(System.in);
        String texto = scanner.nextLine();
        String[] palabras = texto.split(" ");

        Map<String, Integer> contador = new HashMap<>();

        for(String palabra: palabras){
            if(contador.containsKey(palabra)){
                contador.put(palabra,contador.get(palabra)+1);
            } else {
                contador.put(palabra, 1);
            }
        }

        System.out.println("Forma 1: ");
        Map<String,Integer> sortedContForma1 = sortContForma1(contador);
        imprimirMapa(sortedContForma1);

        System.out.println("Forma 2: ");
        Map<String,Integer> sortedContForma2 = sortContForma2(contador);
        imprimirMapa(sortedContForma2);
    }


    public static Map<String, Integer> sortContForma1(Map<String, Integer> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1,e2) -> e1, LinkedHashMap::new));
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortContForma2(Map<K, V> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<K, V>comparingByValue().reversed())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1,e2) -> e1, LinkedHashMap::new));
    }

    public static <K,V> void imprimirMapa(Map<K,V> map){
        for(Map.Entry<K,V> entry: map.entrySet()){
            System.out.printf("%s: %s\n",entry.getKey(),entry.getValue() );
        }
    }

}
