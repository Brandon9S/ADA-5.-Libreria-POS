# Libreria POS

Sistema de punto de venta de escritorio para una librería (Java, arquitectura MVC por capas).
Proyecto de Construcción de Software, Equipo 9.

## Estructura
- `src/main/java/libreria/modelo`: clases de dominio (Libro, Cliente, Venta, DetalleVenta)
- `src/main/java/libreria/vista`: interfaz (pendiente)
- `src/main/java/libreria/Main.java`: punto de entrada de demostración

## Compilar y ejecutar
```
javac -d out $(find src -name "*.java")
java -cp out libreria.Main
```
