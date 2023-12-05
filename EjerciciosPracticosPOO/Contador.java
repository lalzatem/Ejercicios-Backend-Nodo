package EjerciciosPracticosPOO;

/**
 * Crea una clase Contador.Contador (sí, contador de programación) con métodos que permitan
 * incrementar y decrementar su valor. La clase contendrá un constructor por defecto,
 * un constructor con parámetros,
 * un constructor copia y los setters y getters (métodos de acceso) que corresponda.
 */
public class Contador {

    private int cont;
    public Contador() {
    }

    public Contador(int cont) {
        this.cont = cont;
    }

    public Contador(Contador contador){
        this.cont = contador.cont;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }


    public int incrementar(){
        return cont++;
    }

    public int decrementar(){
        return cont--;
    }

}
