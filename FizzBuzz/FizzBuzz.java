package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /*Escribir un programa que muestre en pantalla los números del 1 al 100,
    sustituyendo los múltiplos de 3 por la palabra “fizz”, los múltiplos de 5 por “buzz”
    y los múltiplos de ambos, es decir, los múltiplos de 3 y 5 (o de 15), por la palabra “fizzbuzz”.*/
    private static List<String> num;

    public static void fizzbuzz(){
        num = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if(i%3 == 0 && i%5 == 0){
                num.add("fizzbuzz");
            }
            else if(i%3 == 0){
                num.add("fizz");
            } else if (i%5 == 0) {
                num.add("buzz");
            } else {
                num.add(String.valueOf(i));
            }
        }
        System.out.println(num);
    }

    public static void fizzbuzz2(){
        for(int i = 1; i <= 100; i++) {
            String result = switch (i % 3) {
                case 0 -> (i % 5 == 0) ? "FizzBuzz" : "Fizz";
                default -> (i % 5 == 0) ? "Buzz" : Integer.toString(i);
            };
            System.out.print(result+", ");
        }
    }


}