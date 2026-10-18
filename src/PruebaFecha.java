import java.util.Scanner;

/**
 * Aplicación de prueba de la clase Fecha (ingreso de datos con Scanner).
 */
public class PruebaFecha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== EJERCICIO 3.14 - FECHA ===");
        System.out.print("Mes: ");
        int mes = Integer.parseInt(entrada.nextLine().trim());
        System.out.print("Día: ");
        int dia = Integer.parseInt(entrada.nextLine().trim());
        System.out.print("Año: ");
        int anio = Integer.parseInt(entrada.nextLine().trim());

        Fecha fecha = new Fecha(mes, dia, anio);
        System.out.print("\nFecha ingresada: ");
        fecha.mostrarFecha();

        System.out.println("\n--- Probando los métodos establecer ---");
        fecha.establecerMes(12);
        fecha.establecerDia(25);
        fecha.establecerAnio(2026);
        System.out.println("Mes: " + fecha.obtenerMes()
                + ", Día: " + fecha.obtenerDia()
                + ", Año: " + fecha.obtenerAnio());
        System.out.print("Fecha modificada: ");
        fecha.mostrarFecha();

        entrada.close();
    }
}
