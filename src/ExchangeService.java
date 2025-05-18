import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class ExchangeService {
    private static final String API_KEY = "[yourApiKey]";
    private static final String BASE_URI = "https://v6.exchangerate-api.com/v6/";
    private static String baseCode = "COP";
    private static JsonObject rates;

    public static void getRatesByBaseCode() throws IOException, InterruptedException {
        String uri = String.format("%s%s/latest/%s", BASE_URI, API_KEY, baseCode);

        String responseBody = MyHttpClient.getResponseBody(uri);
        JsonObject root = parseJsonResponse(responseBody);

        JsonObject conversionRates = root.getAsJsonObject("conversion_rates");
        if (conversionRates == null || conversionRates.isEmpty()) {
            throw new IOException("No se encontraron tasas de conversión para la base " + baseCode);
        }

        rates = conversionRates;
    }

    private static JsonObject parseJsonResponse(String responseBody) throws IOException {
        JsonElement parsed = JsonParser.parseString(responseBody);

        if (!parsed.isJsonObject()) {
            throw new IOException("Respuesta inválida del servidor: no es un objeto JSON");
        }

        return parsed.getAsJsonObject();
    }

    public static void setBaseCode(String newBaseCode) {
        baseCode = newBaseCode.trim().toUpperCase();
    }

    public static String getBaseCode() {
        return baseCode;
    }

    public static JsonObject getRates() {
        return rates;
    }

    public static boolean isInvalidRate(String currencyCode) {
        return rates == null || !rates.has(currencyCode.toUpperCase());
    }

    public static double convertAmountByCode(String targetCurrencyCode, double amount) {
        if (isInvalidRate(targetCurrencyCode)) {
            throw new IllegalArgumentException("Moneda no soportada: " + targetCurrencyCode);
        }
        double rate = rates.get(targetCurrencyCode.toUpperCase()).getAsDouble();
        return rate * amount;
    }
}
