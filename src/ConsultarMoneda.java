import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Monedas buscarMoneda(String monedaBase, String monedaTarget){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7a3b5f419285383269b51d2e/pair/"+monedaBase+"/"+monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            //Enviar la solicitud HTTP y obtener la respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Desearializar la respuesta en un objeto de la clase Monedas
            return new Gson().fromJson(response.body(), Monedas.class);
        }
        catch (Exception e) {
            throw  new RuntimeException("No encontré la Moneda.");
        }

    }
}
