import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ProcesaLlamada muestraResultado = new ProcesaLlamada();
        int opcion = 0;
        double cantidad;
        Scanner teclado = new Scanner(System.in);
        LlamadaApi llamadaApi = new LlamadaApi();
        while (opcion != 7) {
            System.out.println("***************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("***************************************");
            System.out.println("1) Dolar =>> Peso Chileno"); // USD CLP
            System.out.println("2) Peso Chileno ==> Dolar");
            System.out.println("3) Euro =>> Peso Chileno");
            System.out.println("4) Peso Chileno =>> Euro");
            System.out.println("5) Dolar ==> Euro"); // USD EUR
            System.out.println("6) Euro ==> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida:");
            System.out.println("***************************************");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    muestraResultado.verResultado("USD", "CLP");
                    break;
                case 2:
                    muestraResultado.verResultado("CLP", "USD");
                    break;
                case 3:
                    muestraResultado.verResultado("EUR", "CLP");
                    break;
                case 4:
                    muestraResultado.verResultado("CLP", "EUR");
                    break;
                case 5:
                    muestraResultado.verResultado("USD", "EUR");
                    break;
                case 6:
                    muestraResultado.verResultado("EUR", "USD");
                    break;
                case 7:
                    System.out.println("Fin de la ejecucion");
                    break;
                default:
                    System.out.println("Opcion no Valida");

            }
        }

    }

}
