package EjerciciosPracticosPOO;

/**Crea una clase Libro con los métodos: préstamo, devolución y toString,
 * cuyo prototipo debe ser: public String toString(). Este método debe retornar
 * una cadena que represente al objeto. Por ejemplo: si la clase tiene los atributos:
 * título, isbn y autor, una cadena que represente a un libro podría ser:
 * “Harry Potter, 9780545582889, Rowling, J. K.”. La clase contendrá un constructor
 * por defecto, un constructor con parámetros y los métodos de acceso.
 */
public class Libro {
     private String titulo;
     private int isbn;
     private String autor;
     private boolean prestamo;
     private boolean devolucion;

     public Libro(){
     }

    public Libro(String titulo, int isbn, String autor, boolean prestamo, boolean devolucion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestamo = prestamo;
        this.devolucion = devolucion;
    }

    public Libro(String titulo, int isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestamo = false;
        this.devolucion = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestamo() {
        return prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    public boolean isDevolucion() {
        return devolucion;
    }

    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    public void prestamo(){
         if(!prestamo){
             prestamo = true;
             devolucion = false;
             System.out.println("Acabaste de prestar el libro");
        } else System.out.println("El libro no está disponible porque se encuentra prestado");
    }

    public void devolucion(){
        if(!devolucion){
            devolucion = true;
            prestamo = false;
            System.out.println("El libro ha sido devuelto");
        } else System.out.println("El libro ya fue devuelto");
    }

    @Override
    public String toString() {
        return "Libro: " +
            titulo + ", " +
            isbn + ", " +
            autor +
            ", Prestado=" + prestamo +
            ", Devuelto=" + devolucion ;
    }
}
