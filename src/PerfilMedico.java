import java.time.LocalDate;
import java.time.Period;

/**
 * Perfil médico "inicial" de una persona: edad, frecuencias cardiacas e IMC.
 */
public class PerfilMedico {

    private static final int FRECUENCIA_BASE = 220;
    private static final double PORCENTAJE_MINIMO = 0.50;
    private static final double PORCENTAJE_MAXIMO = 0.85;

    private String primerNombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private double alturaCm;
    private double pesoKg;

    public PerfilMedico(String primerNombre, String apellido, String sexo,
                        int diaNacimiento, int mesNacimiento, int anioNacimiento,
                        double alturaCm, double pesoKg) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        establecerAlturaCm(alturaCm);
        establecerPesoKg(pesoKg);
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

    public String obtenerSexo() {
        return sexo;
    }

    public void establecerSexo(String sexo) {
        this.sexo = sexo;
    }

    public int obtenerDiaNacimiento() {
        return diaNacimiento;
    }

    public void establecerDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int obtenerMesNacimiento() {
        return mesNacimiento;
    }

    public void establecerMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int obtenerAnioNacimiento() {
        return anioNacimiento;
    }

    public void establecerAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public double obtenerAlturaCm() {
        return alturaCm;
    }

    /** La altura debe ser positiva; de lo contrario se conserva el valor actual. */
    public void establecerAlturaCm(double alturaCm) {
        if (alturaCm > 0) {
            this.alturaCm = alturaCm;
        }
    }

    public double obtenerPesoKg() {
        return pesoKg;
    }

    /** El peso debe ser positivo; de lo contrario se conserva el valor actual. */
    public void establecerPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
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

    /** IMC = peso (kg) / altura (m)^2. Devuelve 0 si la altura no es válida. */
    public double calcularIMC() {
        if (alturaCm <= 0) {
            return 0.0;
        }
        double alturaMetros = alturaCm / 100.0;
        return pesoKg / (alturaMetros * alturaMetros);
    }

    public String clasificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 25) {
            return "Normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        }
        return "Obeso";
    }
}
