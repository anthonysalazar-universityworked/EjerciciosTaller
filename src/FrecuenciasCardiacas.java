import java.time.LocalDate;
import java.time.Period;

/**
 * Calcula la edad y las frecuencias cardiacas máxima y esperada de una persona.
 */
public class FrecuenciasCardiacas {

    private static final int FRECUENCIA_BASE = 220;
    private static final double PORCENTAJE_MINIMO = 0.50;
    private static final double PORCENTAJE_MAXIMO = 0.85;

    private String primerNombre;
    private String apellido;
    private int mesNacimiento;
    private int diaNacimiento;
    private int anioNacimiento;

    public FrecuenciasCardiacas(String primerNombre, String apellido,
                                int mesNacimiento, int diaNacimiento, int anioNacimiento) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.mesNacimiento = mesNacimiento;
        this.diaNacimiento = diaNacimiento;
        this.anioNacimiento = anioNacimiento;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerApellido(String apellido) {
        this.apellido = apellido;
    }

    public int obtenerMesNacimiento() {
        return mesNacimiento;
    }

    public void establecerMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int obtenerDiaNacimiento() {
        return diaNacimiento;
    }

    public void establecerDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int obtenerAnioNacimiento() {
        return anioNacimiento;
    }

    public void establecerAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int calcularEdad() {
        LocalDate nacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    public int calcularFrecuenciaCardiacaMaxima() {
        return FRECUENCIA_BASE - calcularEdad();
    }

    public double calcularFrecuenciaEsperadaMinima() {
        return calcularFrecuenciaCardiacaMaxima() * PORCENTAJE_MINIMO;
    }

    public double calcularFrecuenciaEsperadaMaxima() {
        return calcularFrecuenciaCardiacaMaxima() * PORCENTAJE_MAXIMO;
    }
}
