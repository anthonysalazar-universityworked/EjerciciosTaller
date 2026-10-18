/**
 * Representa un empleado con su nombre, apellido y salario mensual.
 */
public class Empleado {

    private String primerNombre;
    private String apellidoPaterno;
    private double salarioMensual;

    public Empleado(String primerNombre, String apellidoPaterno, double salarioMensual) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        establecerSalarioMensual(salarioMensual);
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public void establecerApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public double obtenerSalarioMensual() {
        return salarioMensual;
    }

    /** Si el salario no es positivo, no se modifica el valor actual. */
    public void establecerSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0) {
            this.salarioMensual = salarioMensual;
        }
    }

    public double obtenerSalarioAnual() {
        return salarioMensual * 12;
    }

    public void aplicarAumento(double porcentaje) {
        establecerSalarioMensual(salarioMensual * (1 + porcentaje / 100));
    }
}
