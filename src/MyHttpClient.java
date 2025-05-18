import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    // Cliente HTTP reutilizable para evitar la creación de múltiples instancias.
    private static final HttpClient client = HttpClient.newHttpClient();

    public static String getResponseBody(String finalUrl) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(finalUrl))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
