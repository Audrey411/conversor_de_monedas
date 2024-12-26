import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura){
        double cantidad;
        double cantidadConvertida;

        //Obtener los datos de la moneda
        Monedas monedas = consulta.buscarMoneda(monedaBase, monedaTarget);

        //Mostrar la tasa de conversión
        System.out.println("La Tasa de conversión para hoy\n1 "+monedaBase+ " = "+monedas.conversion_rate()+" "+monedaTarget);

        //Pedir la cantidad a convertir
        System.out.println("Ingrese la cantidad de " + monedaBase);
        cantidad = Double.parseDouble(lectura.nextLine());

        //Realizar la comversión
        cantidadConvertida = cantidad * monedas.conversion_rate();

        //Mostrar el resultado de la conversión
        System.out.println(cantidad+" "+monedaBase +" = "+cantidadConvertida + " " + monedas.target_code());

        //Crear un objeto Conversion con la información
        Conversion conversion = new Conversion(monedaBase, monedaTarget, cantidad, monedas.conversion_rate(), cantidadConvertida);

        //Guardar la conversión en un archivo JSON
         guardarConversionEnArchivo(conversion);

    }



    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura) {

        //Pedir al usuario a los códigos de las monedas a convertir
        System.out.println("Ingrese el codigo de la moneda base: ");
        String monedaBase = lectura.nextLine();
        System.out.println("Ingrese la moneda que desea convertir: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();

        //Realizar la conversión con los datos proporcionados
        convertir(monedaBase, monedaObjetivo, consulta, lectura);
    }


    public static void guardarConversionEnArchivo(Conversion conversion) {
        try (FileWriter file = new FileWriter("conversiones.json", true)) {
            //Objeto Gson con formato "Pretty Printing"
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            //Convertir el objeto a formato JSON formateado
            String json = gson.toJson(conversion);

            //Escribir el JSON formateado al archivo
            file.write(json + "\n");
            System.out.println("Conversión guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la conversión: " + e.getMessage());
        }
    }
}
