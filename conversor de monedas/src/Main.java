import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConvertidorDeMoneda convertidor = new ConvertidorDeMoneda();
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "ARS", convertidor, scanner);
                    break;
                case 2:
                    convertirMoneda("ARS", "USD", convertidor, scanner);
                    break;
                case 3:
                    convertirMoneda("USD", "BRL", convertidor, scanner);
                    break;
                case 4:
                    convertirMoneda("BRL", "USD", convertidor, scanner);
                    break;
                case 5:
                    convertirMoneda("USD", "COP", convertidor, scanner);
                    break;
                case 6:
                    convertirMoneda("COP", "USD", convertidor, scanner);
                    break;
                case 7:
                    convertirMonedasPersonalizadas(convertidor, scanner);
                    break;
                case 8:
                    System.out.println("¡Gracias por usar el conversor! 🌟");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Inténtelo nuevamente.");
            }

            System.out.println(); // Espacio para claridad visual
        } while (opcion != 8);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("*************************************************");
        System.out.println("   ¡Bienvenido/a al Conversor de Moneda! 🪙");
        System.out.println("*************************************************");
        System.out.println("1) Dólar (USD) -> Peso argentino (ARS)");
        System.out.println("2) Peso argentino (ARS) -> Dólar (USD)");
        System.out.println("3) Dólar (USD) -> Real brasileño (BRL)");
        System.out.println("4) Real brasileño (BRL) -> Dólar (USD)");
        System.out.println("5) Dólar (USD) -> Peso colombiano (COP)");
        System.out.println("6) Peso colombiano (COP) -> Dólar (USD)");
        System.out.println("7) Convertir entre otras monedas");
        System.out.println("8) Salir");
        System.out.print("Elija una opción válida: ");
    }

    private static int obtenerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada no válida. Por favor, ingrese un número.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void convertirMoneda(String from, String to, ConvertidorDeMoneda convertidor, Scanner scanner) {
        try {
            System.out.print("Ingrese la cantidad en " + from + ": ");
            double cantidad = scanner.nextDouble();
            double resultado = convertidor.convert(from, to, cantidad);
            System.out.println("💱 Resultado: " + cantidad + " " + from + " = " + resultado + " " + to);
        } catch (IOException e) {
            System.out.println("❌ Error al realizar la conversión: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Entrada no válida. Inténtelo de nuevo.");
        }
    }

    private static void convertirMonedasPersonalizadas(ConvertidorDeMoneda convertidor, Scanner scanner) {
        System.out.print("Ingrese la moneda de origen (código, ej: USD): ");
        String monedaOrigen = scanner.next();
        System.out.print("Ingrese la moneda de destino (código, ej: EUR): ");
        String monedaDestino = scanner.next();
        convertirMoneda(monedaOrigen, monedaDestino, convertidor, scanner);
    }
}
