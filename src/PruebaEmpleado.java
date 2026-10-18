import javax.swing.JOptionPane;

/**
 * Aplicación de prueba de la clase Empleado (ingreso de datos con ventanas emergentes).
 */
public class PruebaEmpleado {

    private static final String TITULO = "Ejercicio 3.13 - Empleado";
    private static final double PORCENTAJE_AUMENTO = 10.0;

    public static void main(String[] args) {
        Empleado empleado1 = leerEmpleado(1);
        Empleado empleado2 = leerEmpleado(2);

        mostrarSalariosAnuales("Salarios anuales ANTES del aumento", empleado1, empleado2);

        empleado1.aplicarAumento(PORCENTAJE_AUMENTO);
        empleado2.aplicarAumento(PORCENTAJE_AUMENTO);

        mostrarSalariosAnuales("Salarios anuales DESPUÉS del aumento del 10%", empleado1, empleado2);
    }

    private static Empleado leerEmpleado(int numero) {
        String nombre = leerTexto("Empleado " + numero + " - Primer nombre:");
        String apellido = leerTexto("Empleado " + numero + " - Apellido paterno:");
        double salario = leerDouble("Empleado " + numero + " - Salario mensual:");
        return new Empleado(nombre, apellido, salario);
    }

    private static void mostrarSalariosAnuales(String encabezado, Empleado e1, Empleado e2) {
        String mensaje = encabezado + "\n\n"
                + descripcionSalario(e1) + "\n"
                + descripcionSalario(e2);
        JOptionPane.showMessageDialog(null, mensaje, TITULO, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String descripcionSalario(Empleado empleado) {
        return String.format("%s %s: $%.2f",
                empleado.obtenerPrimerNombre(),
                empleado.obtenerApellidoPaterno(),
                empleado.obtenerSalarioAnual());
    }

    private static String leerTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(null, mensaje, TITULO, JOptionPane.QUESTION_MESSAGE);
        if (texto == null) {
            System.exit(0); // el usuario canceló
        }
        return texto.trim();
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", TITULO,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
