import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConvertidorDeMoneda {
    private Map<String, Double> tasasDeCambioCache;
    private ServicioDeMoneda servicioDeMoneda;

    public ConvertidorDeMoneda() {
        tasasDeCambioCache = new HashMap<>();
        servicioDeMoneda = new ServicioDeMoneda();
    }

    public double convert(String from, String to, double cantidad) throws IOException {
        String parDeMonedas = from + "-" + to;
        double tasaDeCambio;

        if (tasasDeCambioCache.containsKey(parDeMonedas)) {
            tasaDeCambio = tasasDeCambioCache.get(parDeMonedas);
        } else {
            tasaDeCambio = servicioDeMoneda.getExchangeRate(from, to);
            tasasDeCambioCache.put(parDeMonedas, tasaDeCambio);
        }

        return cantidad * tasaDeCambio;
    }
}
