import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ProcesaLlamada {
    double cantidad;
    Scanner teclado = new Scanner(System.in);
    LlamadaApi llamadaApi = new LlamadaApi();

    public void verResultado(String base_code,
                             String target_code) {
        System.out.println("Ingrese el monto que desee convertir : ");
        cantidad = teclado.nextDouble();
        if (cantidad > 0) {
            try {
                Moneda moneda = llamadaApi.buscaConversion(base_code, target_code);
                if (moneda.result().equals("success")) {

                    System.out.println(String.format("El valor de %.2f [%s] corresponde al valor final de %.2f [%s]",
                            cantidad,
                            moneda.base_code(),
                            cantidad * moneda.conversion_rate(),
                            moneda.target_code()));
                } else {
                    System.out.println("Error, en la llamada a la url");
                }
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Error, debe ingresar Cantidad");
        }


    }
}


