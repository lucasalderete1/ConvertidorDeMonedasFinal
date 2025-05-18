# Convertidor de Monedas

# Conversor de Monedas con API de ExchangeRate-API

## Descripción
Aplicación Java CLI para conversión monetaria en tiempo real usando [ExchangeRate-API](https://www.exchangerate-api.com/).

**Características principales**:
- Consulta tasas actualizadas
- Conversión entre 160+ divisas
- Interfaz intuitiva por consola

## Funcionalidades
| Función | Descripción |
|---------|-------------|
| Conversión en tiempo real | Usa tasas actualizadas de la API |
| Gestión de moneda base | Permite cambiar la moneda de referencia |
| Validación de inputs | Controla errores en entradas |
| Listado completo | Muestra todas las divisas disponibles |
| Historial | Muestra todas las conversiones hechas de cada sesión |

## Tecnologías Utilizadas
```java
// Stack técnico
- Java 11+
- Google Gson (JSON)
- Java HttpClient
```

## Requisitos del Sistema
- JDK 11 o superior
- API Key de ExchangeRate-API
- Conexión a internet
- IDE IntelliJ IDEA

## Instalación
```bash
# 1. Clonar repositorio
git clone https://github.com/WilmarDeML/currency-converter.git
cd currency-converter

# 2. Configurar API Key (en ExchangeService.java)
private static final String API_KEY = "tu-key-aquí";

# 3. Descargar el archivo JAR de Gson

    ° En IntelliJ IDEA:

    ° File > Project Structure > Modules > Dependencies

    ° Click en "+" > JARs or directories

    ° Seleccionar el archivo gson-2.X.X.jar
```

## Estructura del Código
| Archivo | Responsabilidad |
|---------|-----------------|
| `Main.java` | Punto de entrada |
| `MainService.java` | Lógica de UI y flujo |
| `ExchangeService.java` | Conexión con API |
| `MyHttpClient.java` | Cliente HTTP |

## API Externa
**Endpoint**: `https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{BASE_CODE}`

**Ejemplo de respuesta**:
```json
{
  "conversion_rates": {
    "USD": 1.0,
    "EUR": 0.92,
    "COP": 4100.0
    ...
  }
}
```

## Posibles Mejoras
1. Historial de conversiones
2. Interfaz gráfica
3. Cache local de tasas
4. Suite de pruebas unitarias

## Desarrollador

**Creado por**: lucasalderete1

[![GitHub](https://img.shields.io/badge/GitHub-Profile-blue?style=flat&logo=github)](https://github.com/lucasalderete1)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/lucas-covi/)
