# ConversorDeMonedas
Desafio Alura Latam

🚀 Conversor de Monedas (Challenge Alura Latam - ONE)

Este proyecto es una aplicación de consola en Java que permite realizar conversiones de diferentes monedas utilizando tasas de cambio actualizadas en tiempo real a través de una API. Desarrollado como parte del desafío ONE (Oracle Next Education) de Alura Latam, con un enfoque en buenas prácticas de programación, modularidad y experiencia de usuario.


🌟 Características

Conversión en Tiempo Real: Obtiene tasas de cambio actualizadas de la API ExchangeRate-API.
Menú Interactivo: Interfaz de consola amigable con un menú de opciones claras.

Monedas Soportadas:
Dólar (USD)
Peso Argentino (ARS)
Peso Chileno (CLP)
Real Brasileño (BRL)
Peso Colombiano (COP)


Historial de Conversiones: Guarda y permite visualizar todas las conversiones realizadas durante la sesión.
Manejo de Errores: Valida la entrada del usuario y muestra mensajes claros en caso de errores.
Diseño Modular: Código estructurado en clases con responsabilidades específicas para facilitar la lectura y el mantenimiento.


🛠️ Tecnologías Utilizadas
Java 17+
Gson 2.10.1: Biblioteca de Google para serializar y deserializar objetos Java a/desde JSON.
API Externa: ExchangeRate-API (Free Tier)


⚙️ Estructura del Proyecto

El proyecto sigue una estructura modular para separar las diferentes capas de la aplicación:

.
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── aluracursos/
│                   └── conversor/
│                       ├── ApiClient.java               # Encargado de la comunicación con la API externa.
│                       ├── ExchangeRateApiResponse.java # Modelo de datos para la respuesta de la API (POJO).
│                       ├── ConversorLogica.java         # Contiene la lógica central de cálculo de conversiones.
│                       ├── ConversorMenu.java           # Gestiona la interfaz de usuario, el menú y el flujo de la aplicación.
│                       └── Principal.java               # Punto de entrada de la aplicación (método main).




🚀 Cómo Ejecutar el Proyecto

Requisitos Previos
Java Development Kit (JDK) 17 o superior instalado en tu computadora.
Conexión a internet (necesario para obtener las tasas de cambio de la API).
La biblioteca Gson 2.10.1 debe estar disponible en tu proyecto. S

Pasos para Ejecutar
Abre el proyecto en tu IDE (IntelliJ IDEA, Eclipse, VS Code):
Si descargaste los archivos, impórtalos como un proyecto Java existente.
Asegúrate de que todas las clases (.java) estén en la estructura de carpetas src/main/java/com/aluracursos/conversor.
Asegúrate de que Gson esté configurado:
Si no lo hiciste ya, descarga el archivo JAR de Gson (versión 2.10.1) desde su repositorio Maven Central o busca "gson 2.10.1 jar download".
Añade este archivo JAR a la ruta de compilación (Build Path) de tu proyecto en tu IDE. 


Ejecuta la aplicación:
Navega a la clase Principal.java dentro de tu IDE.
Busca el método main (generalmente tiene un icono de "play" o "ejecutar" al lado).
Haz clic en el icono para ejecutar el programa.


💡 Cómo Usar la Aplicación
Al ejecutar el programa, verás un menú de opciones en la consola:

**************************************************
¡Hola! Bienvenido/a al Conversor de Moneda =]
1) Peso Chileno >> Dólar
2) Dólar >> Peso Chileno
3) Peso Argentino >> Dólar
4) Dólar >> Peso Argentino
5) Real Brasileño >> Dólar
6) Dólar >> Real Brasileño
7) Peso Colombiano >> Dólar
8) Dólar >> Peso Colombiano
9) Mostrar Historial de Conversiones
S) Salir
Por favor, ingrese un número del 1 al 9 o 's' para elegir una opción:
**************************************************


Elige una opción de conversión (1-8): Ingresa el número correspondiente a la conversión deseada y presiona Enter.
Ingresa la cantidad: El programa te pedirá la cantidad de la moneda de origen que deseas convertir. Ingresa un número y presiona Enter.
Visualiza el resultado: La aplicación mostrará el monto convertido de manera clara y luego volverá a presentar el menú.
Ver historial (9): Ingresa 9 para ver un listado de todas las conversiones que has realizado en la sesión actual.
Salir (S): Ingresa S (mayúscula o minúscula) para finalizar la aplicación.


🤝 Contribuciones
¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar, encuentras algún error o quieres añadir más funcionalidades, no dudes en:
Hacer un "Fork" del repositorio (copiarlo a tu cuenta).
Crear una nueva rama (git checkout -b feature/nueva-funcionalidad).
Realizar tus cambios y asegurarte de que el código compile.
Abrir un "Pull Request" (solicitud de fusión) explicando tus cambios.
