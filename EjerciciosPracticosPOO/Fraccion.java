package EjerciciosPracticosPOO;

/**
 Ejercicio 4: Crea una clase Fraccion con métodos necesarios para sumar, restar,
 multiplicar y dividir fracciones. Todos los métodos deben estar sobrecargados
 de modo que también puedan usarse para operar entre fracciones
 y números enteros (por ejemplo: ⅗+2 o ⅝*4)
 */
public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(){
        this.denominador=1;
    }

    public Fraccion(int numerador, int denominador){
        this.numerador=numerador;
        this.denominador=denominador;
    }

    public Fraccion(int numerador){
        this.numerador=numerador;
        this.denominador=1;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void sumar(Fraccion f2){
        this.numerador =  this.numerador * f2.denominador + this.denominador * f2.numerador;
        this.denominador = this.denominador * f2.denominador;

    }
    public void restar(Fraccion f2){
        this.numerador =  this.numerador * f2.denominador - this.denominador * f2.numerador;
        this.denominador = this.denominador * f2.denominador;
    }

    public void multiplicar(Fraccion f2){
        this.numerador =  this.numerador * f2.numerador;
        this.denominador = this.denominador * f2.denominador;
    }

    public void dividir(Fraccion f2){
        this.numerador =  this.numerador * f2.denominador;
        this.denominador = this.denominador * f2.numerador;
    }

    @Override
    public String toString() {
        int numerador = getNumerador();
        int denominador = getDenominador();
        return numerador + "/" + denominador;

    }
}
