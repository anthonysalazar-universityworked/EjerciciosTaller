import java.util.Scanner;

/**
 * Aplicación de prueba de la clase Factura (ingreso de datos con Scanner).
 */
public class PruebaFactura {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== EJERCICIO 3.12 - FACTURA ===");
        System.out.print("Número de pieza: ");
        String numeroPieza = entrada.nextLine();

        System.out.print("Descripción: ");
        String descripcion = entrada.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(entrada.nextLine().trim());

        System.out.print("Precio por artículo: ");
        double precio = Double.parseDouble(entrada.nextLine().trim().replace(',', '.'));

        Factura factura = new Factura(numeroPieza, descripcion, cantidad, precio);
        mostrarFactura(factura);

        System.out.println("\n--- Probando los métodos establecer (valores inválidos) ---");
        factura.establecerCantidad(-5);
        factura.establecerPrecioPorArticulo(-2.50);
        mostrarFactura(factura);

        entrada.close();
    }

    private static void mostrarFactura(Factura factura) {
        System.out.println("\nNúmero de pieza: " + factura.obtenerNumeroPieza());
        System.out.println("Descripción:     " + factura.obtenerDescripcion());
        System.out.println("Cantidad:        " + factura.obtenerCantidad());
        System.out.printf("Precio unitario: $%.2f%n", factura.obtenerPrecioPorArticulo());
        System.out.printf("Monto factura:   $%.2f%n", factura.obtenerMontoFactura());
    }
}
