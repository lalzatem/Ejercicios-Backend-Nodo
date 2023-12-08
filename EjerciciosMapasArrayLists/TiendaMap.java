package EjerciciosMapasArrayLists;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/*
     Necesitamos una aplicación para una tienda mediante la que queremos almacenar
     los distintos productos que venderemos y el precio que tendrán.
     Y se quiere que tenga las funciones básicas, introducir un elemento,
     modificar su precio, eliminar un producto y mostrar los productos que tenemos con su precio.
     (toodo esto solicitándoles los datos y las opciones por consola)
 */
public class TiendaMap {

    public static void main(String[] args){
        Map<String, Double> productos = new HashMap<>();
        boolean continua = false;

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5 || continua){
            try{
                continua = false;
                menu();
                opcion = scanner.nextInt();

                switch (opcion){
                    case 1 -> agregarProducto(productos);
                    case 2 -> actualizarProducto(productos);
                    case 3 -> eliminarProducto(productos);
                    case 4 -> mostrarProductos(productos);
                    case 5 -> System.out.println("Chauu");
                    default -> System.out.println("ERROR: Elige una opcion válida");
                }

            } catch (InputMismatchException ex){
                System.out.println("Elige una opción válida.");
                scanner.next();
                continua = true;
            }
        }

    }

    public static void menu(){
        System.out.println("\n\n\n\n");
        System.out.println("*********MENU**********");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar precio");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Mostrar productos");
        System.out.println("5. Salir");
        System.out.println("Selecciona una opción");
    }

    public static void agregarProducto(Map<String, Double> productos){
        System.out.print("\nIngrese nombre producto: ");
        Scanner scanner = new Scanner(System.in);
        String producto = scanner.nextLine();
        System.out.print("\nIngrese precio producto: ");
        double precio = scanner.nextDouble();

        productos.put(producto,precio);
    }

    public static void eliminarProducto(Map<String, Double> productos){
        System.out.print("\nIngrese nombre producto: ");
        Scanner scanner = new Scanner(System.in);
        String producto = scanner.nextLine();

        boolean productoExiste = productos.containsKey(producto);
        if(productoExiste){
            productos.remove(producto);
        } else System.out.println("\nEl producto a eliminar no existe");
  }

  public static void actualizarProducto(Map<String, Double> productos) {
        System.out.print("\nIngrese nombre producto: ");
        Scanner scanner = new Scanner(System.in);
        String producto = scanner.nextLine();

        boolean productoExiste = productos.containsKey(producto);
        if(productoExiste){
            System.out.print("\nIngrese el nuevo precio del producto : ");
            double precio = scanner.nextDouble();
            productos.replace(producto, precio);
    } else System.out.println("\nEl producto a modificar no existe");
    }

    public static void mostrarProductos(Map<String, Double> productos){
        for(String producto : productos.keySet()){
            System.out.println(producto + " - $"+productos.get(producto));
        }
    }
}
