package Palindromo;

import java.util.Scanner;

public class Palindromo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la palabra: ");
        String palabra = sc.nextLine();
        palindromo(palabra);
    }

    public static boolean palindromo(String palabra){
        StringBuilder stringBuilder = new StringBuilder(palabra);
        String palabraInvertida = stringBuilder.reverse().toString();
        if(palabra.equalsIgnoreCase(palabraInvertida)){
            System.out.println("La palabra " + palabra + " es un palindromo.");
            return true;
        } else {
            System.out.println("La palabra " + palabra + " NO es un palindromo.");
            return false;
        }
    }
}
