# Conversor de monedas

Desafío de **Alura Latam + Oracle Next Education (ONE)** hecho en Java. Es un programa de consola que convierte
valores entre monedas consultando las tasas de cambio actuales por internet.

## Qué hace

Menú de conversiones listas:

- Dólar ⇄ Peso argentino
- Dólar ⇄ Real brasileño
- Dólar ⇄ Peso colombiano
- Conversión personalizada entre cualquier par de monedas (con su código, por ejemplo `EUR` y `JPY`)

## Cómo lo ejecuto

Necesito JDK 17 o superior y conexión a internet.

```bash
cd "conversor de monedas"
javac -d out src/*.java
java -cp out Main
```

## Cómo funciona por dentro

- `Main`: el menú y la lectura de opciones.
- `ConvertidorDeMoneda`: hace la multiplicación con la tasa de cambio.
- `ServicioDeMoneda`: consulta las tasas a [open.er-api.com](https://www.exchangerate-api.com/docs/free), un servicio gratuito sin clave.

---
Desarrollado por Henry Polo.
