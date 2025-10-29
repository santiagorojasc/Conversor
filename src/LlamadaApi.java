import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadaApi {
    public Moneda buscaConversion(String base_code, String target_code) throws IOException, JsonParseException {
        String url = "https://v6.exchangerate-api.com/v6/498863d3497942ac1bbd728d/pair/"
            + base_code + "/" + target_code;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return new Gson().fromJson(json, Moneda.class);


        } catch (Exception e) {
            throw new RuntimeException("Error, No encuentro la conversion");
        }

    }


}
