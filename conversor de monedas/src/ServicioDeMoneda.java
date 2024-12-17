import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicioDeMoneda {
    private final String apiKey = "4c5acccf7450cef1af9bfd6f";
    private final String baseUrl = "https://open.er-api.com/v6/latest/";

    public double getExchangeRate(String from, String to) throws IOException {
        String urlStr = baseUrl + from;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parsear el JSON para obtener la tasa de cambio
        String json = response.toString();
        int startIndex = json.indexOf("\"" + to + "\":") + to.length() + 3;
        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = json.indexOf("}", startIndex);
        }
        String rateStr = json.substring(startIndex, endIndex);
        return Double.parseDouble(rateStr);
    }
}
