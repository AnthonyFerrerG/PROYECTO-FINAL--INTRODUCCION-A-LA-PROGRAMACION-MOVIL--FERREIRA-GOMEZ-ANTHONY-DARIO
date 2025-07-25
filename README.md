# PROYECTO-FINAL--INTRODUCCION-A-LA-PROGRAMACION-MOVIL--FERREIRA-GOMEZ-ANTHONY-DARIO


# 📚 BookTracker

Aplicación Android desarrollada con Jetpack Compose para registrar libros leídos, en progreso o pendientes de leer. Funciona sin backend ni base de datos, almacenando los datos en memoria durante la sesión.

---

## 📋 Resumen del Proyecto

**BookTracker** es una aplicación Android desarrollada como trabajo final de la materia Programación Android. Permite al usuario gestionar una lista personal de libros, registrando información básica como título, autor y estado (por leer, en progreso o terminado). 

Está diseñada para funcionar sin conexión, utilizando memoria RAM para almacenar los datos mientras se usa la aplicación.

---

## 🎯 Objetivo

Aplicar los conocimientos adquiridos en clase en un proyecto completo que demuestre dominio de:

- Jetpack Compose para interfaces modernas
- Patrón MVVM (ViewModel + UIState)
- Navegación con Navigation Compose
- Validaciones de entrada
- Manejo básico de errores
- Arquitectura limpia por capas

---

## 🔍 Funcionalidades Principales

- Inicio de sesión simulado
- Listado de libros con estado
- Agregado de nuevos libros
- Edición y eliminación de libros existentes
- Vista detallada de cada libro

---

## 🏗️ Estructura de la Aplicación

MainActivity.kt
Book.kt
BookViewModel.kt
Navigation.kt
ui/
├── LoginScreen.kt
├── HomeScreen.kt
├── AddBookScreen.kt
├── EditBookScreen.kt
└── DetailScreen.kt


---

## 🖥️ Manual de Uso

### 🔑 Inicio de Sesión

1. Al abrir la app, aparecerá la pantalla de **login**.
2. Ingrese:
   - Usuario: `admin`
   - Contraseña: `1234`
3. Presione **Ingresar**.

### 📚 Pantalla Principal

- Se muestra la lista de libros cargados.
- Presione `+` para agregar uno nuevo.
- Toque un libro para ver detalles.

### ➕ Agregar Libro

- Ingrese **título**, **autor** y seleccione un **estado**.
- Presione **Guardar**.

### 🔍 Ver Detalles

- Muestra la información del libro.
- Opciones:
  - **Editar**: modifica datos.
  - **Eliminar**: borra el libro.

### ✏️ Editar Libro

- Cambie el título, autor o estado.
- Presione **Actualizar**.

### 🗑️ Eliminar Libro

- Desde la pantalla de detalle, presione **Eliminar**.

🛑 **Nota:** Los datos se pierden al cerrar la aplicación (no se guardan).

---

## ⚙️ Validaciones

- **Título:** mínimo 3 caracteres.
- **Autor:** obligatorio.
- **Estado:** debe seleccionarse de opciones válidas.

---

## 💥 Manejo de Errores

- Login incorrecto muestra mensaje de error.
- Campos inválidos no permiten continuar.
- La navegación previene accesos nulos.

---

## 📊 Diagrama de Componentes

```plaintext
MainActivity
   ↓
Navigation (NavHostController)
   ├── LoginScreen
   ├── HomeScreen ←→ DetailScreen
   │                    ↑       ↓
   └──── AddBookScreen   ←→  EditBookScreen
ViewModel (BookViewModel): controla el estado global de los libros.

UI Layer: Composables para cada pantalla.

No hay Data Layer persistente: solo lista en memoria.

🛠️ Tecnologías Utilizadas
Lenguaje: Kotlin

Framework: Jetpack Compose

Arquitectura: ViewModel + State

Navegación: Navigation Compose

Estilo: Material3

👤 Autor
Alumno: Anthony Dario Ferreira Gomez

Carrera: Ingeniería en Informática – 5to semestre

Materia: Introduccion a la Programacion Movil

Año: 2025
