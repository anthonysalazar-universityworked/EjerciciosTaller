import javax.swing.JOptionPane;

/**
 * Aplicación de prueba de FrecuenciasCardiacas (ingreso de datos con ventanas emergentes).
 */
public class PruebaFrecuenciasCardiacas {

    private static final String TITULO = "Ejercicio 3.16 - Frecuencias cardiacas";

    public static void main(String[] args) {
        // Captura de datos personales y fecha de nacimiento desde la interfaz gráfica
        String nombre = leerTexto("Primer nombre:");
        String apellido = leerTexto("Apellido:");
        int mes = leerEntero("Mes de nacimiento (1-12):");
        int dia = leerEntero("Día de nacimiento:");
        int anio = leerEntero("Año de nacimiento:");

        FrecuenciasCardiacas persona;
        // Intento de instanciación del objeto y validación de la fecha ingresada
        try {
            persona = new FrecuenciasCardiacas(nombre, apellido, mes, dia, anio);
            persona.calcularEdad(); // valida que la fecha sea real
        } catch (java.time.DateTimeException e) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es válida.", TITULO,
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String resultado = String.format(
                "Nombre: %s %s%n"
                + "Fecha de nacimiento: %d/%d/%d%n%n"
                + "Edad: %d años%n"
                + "Frecuencia cardiaca máxima: %d pulsos/min%n"
                + "Frecuencia cardiaca esperada: %.1f - %.1f pulsos/min",
                persona.obtenerPrimerNombre(), persona.obtenerApellido(),
                persona.obtenerMesNacimiento(), persona.obtenerDiaNacimiento(),
                persona.obtenerAnioNacimiento(),
                persona.calcularEdad(),
                persona.calcularFrecuenciaCardiacaMaxima(),
                persona.calcularFrecuenciaEsperadaMinima(),
                persona.calcularFrecuenciaEsperadaMaxima());

        JOptionPane.showMessageDialog(null, resultado, TITULO, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String leerTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(null, mensaje, TITULO, JOptionPane.QUESTION_MESSAGE);
        if (texto == null) {
            System.exit(0); // el usuario canceló
        }
        return texto.trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido.", TITULO,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
