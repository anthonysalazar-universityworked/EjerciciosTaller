import java.util.Scanner;

/**
 * Aplicación de prueba de PerfilMedico (ingreso de datos con Scanner).
 */
public class PruebaPerfilMedico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== EJERCICIO 3.17 - PERFIL MÉDICO ===");
        String nombre = leerTexto(entrada, "Primer nombre: ");
        String apellido = leerTexto(entrada, "Apellido: ");
        String sexo = leerTexto(entrada, "Sexo: ");
        int dia = (int) leerNumero(entrada, "Día de nacimiento: ");
        int mes = (int) leerNumero(entrada, "Mes de nacimiento: ");
        int anio = (int) leerNumero(entrada, "Año de nacimiento: ");
        double altura = leerNumero(entrada, "Altura (cm): ");
        double peso = leerNumero(entrada, "Peso (kg): ");
        // Intento de creación del perfil médico y validación integral de la fecha de nacimiento
        PerfilMedico perfil;
        try {
            perfil = new PerfilMedico(nombre, apellido, sexo, dia, mes, anio, altura, peso);
            perfil.calcularEdad(); // valida que la fecha sea real
        } catch (java.time.DateTimeException e) {
            System.out.println("La fecha de nacimiento no es válida.");
            entrada.close();
            return;
        }

        mostrarDatos(perfil);
        mostrarResultados(perfil);
        mostrarTablaIMC();

        entrada.close();
    }

    private static void mostrarDatos(PerfilMedico perfil) {
        System.out.println("\n--- DATOS DEL PACIENTE ---");
        System.out.println("Nombre: " + perfil.obtenerPrimerNombre() + " " + perfil.obtenerApellido());
        System.out.println("Sexo: " + perfil.obtenerSexo());
        System.out.printf("Fecha de nacimiento: %d/%d/%d%n",
                perfil.obtenerDiaNacimiento(), perfil.obtenerMesNacimiento(), perfil.obtenerAnioNacimiento());
        System.out.printf("Altura: %.1f cm%n", perfil.obtenerAlturaCm());
        System.out.printf("Peso: %.1f kg%n", perfil.obtenerPesoKg());
    }

    private static void mostrarResultados(PerfilMedico perfil) {
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Edad: " + perfil.calcularEdad() + " años");
        System.out.printf("IMC: %.2f (%s)%n", perfil.calcularIMC(), perfil.clasificarIMC());
        System.out.println("Frecuencia cardiaca máxima: " + perfil.calcularFrecuenciaCardiacaMaxima() + " pulsos/min");
        System.out.printf("Frecuencia cardiaca esperada: %.1f - %.1f pulsos/min%n",
                perfil.calcularFrecuenciaEsperadaMinima(), perfil.calcularFrecuenciaEsperadaMaxima());
    }

    private static void mostrarTablaIMC() {
        System.out.println("\n--- VALORES DE BMI ---");
        System.out.println("Bajo peso: menos de 18.5");
        System.out.println("Normal:    entre 18.5 y 24.9");
        System.out.println("Sobrepeso: entre 25 y 29.9");
        System.out.println("Obeso:     30 o más");
    }

    private static String leerTexto(Scanner entrada, String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    private static double leerNumero(Scanner entrada, String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(entrada, mensaje).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}
