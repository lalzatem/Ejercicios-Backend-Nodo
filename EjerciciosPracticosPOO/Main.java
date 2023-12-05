package EjerciciosPracticosPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        EjercicioContador();
        EjercicioCuentaCorriente();
        EjercicioFecha();
        EjercicioFraccion();
        EjercicioLibro();
    }


    public static void EjercicioContador(){
        Scanner sc = new Scanner(System.in);
        int numIni;
        System.out.print("Introduce valor inicial: ");
        numIni = sc.nextInt();

        Contador contador1 = new Contador(); //Constructor por defecto
        contador1.setCont(numIni);
        contador1.incrementar();
        contador1.incrementar();
        System.out.println("Increnté dos veces: " + contador1.getCont());
        contador1.decrementar();
        System.out.println("Decrementé una vez: " + contador1.getCont());

        System.out.println("_________________");
        System.out.println("Se inicia contador en 2");
        Contador contador2 = new Contador(2); //Constructor que recibe contador inicial
        contador2.incrementar();
        System.out.println("Incrementé una vez: " + contador2.getCont());
        contador2.decrementar();
        contador2.decrementar();
        System.out.println("Decrementé dos vez: " + contador2.getCont());

        System.out.println("_________________");
        Contador contador3 = new Contador(contador2);
        System.out.println("Constructor copia -> contador: "+contador3.getCont());
    }
    public static void EjercicioCuentaCorriente(){
        int numCuenta;
        String cliente;
        double valor;

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del cliente: ");
        cliente = sc.nextLine();
        System.out.print("Introduce el num cuenta del cliente: ");
        numCuenta = sc.nextInt();
        System.out.print("Introduce el saldo actual de la cuenta: ");
        valor = sc.nextDouble();

        CuentaCorriente cuenta1 = new CuentaCorriente(); //Constructor por defecto
        cuenta1.setCliente(cliente);
        cuenta1.setNumCuenta(numCuenta);
        cuenta1.setSaldo(valor);
        System.out.println("Saldo actual: " + cuenta1.getSaldo());
        cuenta1.ingreso(2000);
        System.out.println("Saldo despues del ingreso de 2000: " + cuenta1.getSaldo());
        cuenta1.egreso(200);
        System.out.println("Saldo despues del egreso de 200: " + cuenta1.getSaldo());


        System.out.println("_________________");
        CuentaCorriente cuenta2 = new CuentaCorriente("Laura", 23421, 40000); // Constructor que recibe contador inicial
        System.out.println("Información Cuenta 2");
        System.out.println("CLiente: " + cuenta2.getCliente());
        System.out.println("Número de cuenta: " + cuenta2.getNumCuenta());
        System.out.println("Saldo actual: " + cuenta2.getSaldo());
        System.out.println();
        cuenta2.ingreso(3000);
        System.out.println("Saldo Cuenta 2 despues del ingreso de 3000: " + cuenta2.getSaldo());
        cuenta2.egreso(300);
        System.out.println("Saldo Cuenta 2 despues del egreso de 300: " + cuenta2.getSaldo());

        System.out.println("_________________");
        System.out.println("Saldo actual Cuenta 1: " + cuenta1.getSaldo());
        System.out.println("Saldo actual Cuenta 2: " + cuenta2.getSaldo());
        cuenta2.transferencia(20000,cuenta1);
        System.out.println("Saldo de Cuenta1 luego de que Cuenta2 le transfiriera dinero a Cuenta 1: " + cuenta1.getSaldo());
        System.out.println("Saldo de Cuenta2 luego de que Cuenta2 le transfiriera dinero a Cuenta 1: " + cuenta2.getSaldo());

        System.out.println("_________________");
        CuentaCorriente cuenta3 = new CuentaCorriente(cuenta2);
        System.out.println("Constructor copia -> CuentaCorriente: "+cuenta3.getCliente());
        System.out.println("Constructor copia -> CuentaCorriente: "+cuenta3.getNumCuenta());
        System.out.println("Constructor copia -> CuentaCorriente: "+cuenta3.getSaldo());
    }
    public static void EjercicioFecha(){
        Fecha fecha1 = new Fecha();

        Scanner sc = new Scanner(System.in);
        int dia, mes, anio;
        System.out.println("Introduce fecha: ");
        System.out.print("dia: ");
        dia = sc.nextInt();
        System.out.print("mes: ");
        mes = sc.nextInt();
        System.out.print("año: ");
        anio = sc.nextInt();

        Fecha fecha2 = new Fecha(dia,mes,anio);
        System.out.println(fecha2.toString());
        System.out.println("La fecha es válida? "+fecha2.fechaEsCorrecta(fecha2.toString(),"dd/MM/yyyy"));
        fecha2.sumarUnDia();
        System.out.println("Se suma un día a la fecha actual y da como resultado: "+fecha2);
    }
    public static void EjercicioFraccion(){
        Fraccion fraccion1 = new Fraccion(1,3);
        Fraccion fraccion2 = new Fraccion(2,3);
        fraccion1.sumar(fraccion2);
        System.out.println("suma: " + fraccion1);
        Fraccion fraccion3 = new Fraccion(2,4);
        Fraccion fraccion4 = new Fraccion(5,5);
        fraccion3.restar(fraccion4);
        System.out.println("resta: " + fraccion3);
        Fraccion fraccion5 = new Fraccion(22,4);
        Fraccion fraccion6 = new Fraccion(5,12);
        fraccion5.multiplicar(fraccion6);
        System.out.println("multiplicacion: " + fraccion5);
        Fraccion fraccion7 = new Fraccion(3,2);
        Fraccion fraccion8 = new Fraccion(2,1);
        fraccion7.dividir(fraccion8);
        System.out.println("division: " + fraccion7);
        Fraccion fraccion9 = new Fraccion();
        System.out.println("fraccion por defecto: " + fraccion9);
        Fraccion fraccion10 = new Fraccion(12);
        System.out.println("fraccion solo con numerador: " + fraccion10);
    }
    public static void EjercicioLibro(){
        Libro libro1 = new Libro();
        libro1.setTitulo("libro1");
        libro1.setAutor("autor1");
        libro1.setIsbn(12213);
        System.out.println(libro1.toString());
        libro1.prestamo();
        System.out.println(libro1.toString());
        libro1.prestamo();
        System.out.println(libro1.toString());
        libro1.devolucion();
        System.out.println(libro1.toString());
        libro1.devolucion();
        System.out.println(libro1.toString());
        Libro libro2 = new Libro("libro2",32423,"autor2");
        System.out.println("--------------------------------------------");
        System.out.println(libro2.toString());
        libro2.devolucion();
        System.out.println(libro2.toString());
        libro2.prestamo();
        System.out.println(libro2.toString());
        libro2.devolucion();
        System.out.println(libro2.toString());
    }

}
