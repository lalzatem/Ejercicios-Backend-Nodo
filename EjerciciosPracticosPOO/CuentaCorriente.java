package EjerciciosPracticosPOO;
/**
 * Crea una clase CuentaCorriente, con los métodos: ingreso, egreso, reintegro y transferencia.
 * La clase contendrá un constructor por defecto, uno con parámetros y otro que recibirá una
 * CuentaCorriente de la cual copiará todos sus datos. Además, se deben desarrollar los
 * métodos de acceso (para cada variable de instancia de la clase, desarrollar un método
 * set y otro get. Por ejemplo: si la clase tiene una variable double saldo,
 * sus métodos de acceso serán: double getSaldo() y void setSaldo(double s)
 */
public class CuentaCorriente {

    private String cliente;
    private int numCuenta;
    private double saldo;

    public CuentaCorriente(){
    }
    public CuentaCorriente(String cliente, int numCuenta, double saldo) {
        this.cliente = cliente;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta) {
        cliente = cuenta.cliente;
        numCuenta = cuenta.numCuenta;
        saldo = cuenta.saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double valor){
        saldo = saldo + valor;
    }
    public void egreso(double valor){
        if(saldo>=valor){
            saldo -= valor;
        }else{
            System.out.println("No se puede realizar el retiro por saldo insuficiente");
        }
    }
    public void reintegro(double valor){
        saldo = saldo + valor;
    }
    public void transferencia(double valor, CuentaCorriente cuenta){
        if(saldo>=valor){
            egreso(valor);
            cuenta.ingreso(valor);
        }else System.out.println("No se puede realizar la transferencia por saldo insuficiente");
    }
}
