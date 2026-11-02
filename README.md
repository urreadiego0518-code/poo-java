# POO en Java

> Prácticas de Programación Orientada a Objetos — herencia, polimorfismo,
> abstracción, encapsulamiento y colecciones propias — reorganizadas como un
> proyecto Maven con pruebas unitarias de verdad.

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org)
[![JUnit](https://img.shields.io/badge/JUnit-5.10-25A162?logo=junit5&logoColor=white)](https://junit.org)
[![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apache-maven&logoColor=white)](https://maven.apache.org)
[![Licencia](https://img.shields.io/badge/Licencia-MIT-green.svg)](LICENSE)

---

## Qué hay aquí

Cada carpeta es un ejercicio de la materia, agrupado por el concepto de POO que
practica, no por la sesión de clase en la que se hizo:

| Paquete | Ejercicio | Concepto |
|---|---|---|
| `herencia` | `FiguraGeometrica` → `Cuadrado` → `Cubo` | Herencia de 2 niveles, abstracción |
| `herencia` | `Empleado` → `Gerente` → `GerenteRegional` | Herencia, sobrescritura de método |
| `polimorfismo` | `Animal` → `Vaca` | Método abstracto, polimorfismo |
| `polimorfismo` | `Vehiculo` → `Automovil` → `Deportivo` | Herencia + polimorfismo |
| `colecciones` | `MiArrayList<E>` | Colección propia genérica con capacidad máxima |
| `banco` | `CuentaBancaria` + `Principal` | Encapsulamiento, separación de responsabilidades |
| `facturacion` | `Producto` + `Factura` | Composición, cálculo de totales |
| `biblioteca` | `Libro` + `Biblioteca` | Colecciones, búsqueda |
| `geometria` | `Triangulo` | Modelo de dominio, validaciones |
| `modelo` | `Alumno`, `Perro`, `Mesero`, `Coche` | Clases básicas, constructores, getters |

---

## Qué se mejoró respecto a la versión de clase

El código original mezclaba la lógica con la interfaz gráfica: `CuentaBancaria`
tenía `JOptionPane` dentro de sus métodos, lo que hacía imposible probarlo.
Estos son los cambios que apliqué:

| Antes | Ahora |
|---|---|
| `JOptionPane` dentro del modelo de negocio | La lógica vive en la clase; los mensajes los muestra la interfaz |
| `System.out.println` para depurar | Los métodos devuelven valores o lanzan excepciones (`IllegalArgumentException`, `IllegalStateException`) |
| `private ArrayList libros = new ArrayList()` (sin genéricos) | `List<Libro>` con tipo seguro y copia defensiva al devolver |
| Sin validación de entradas | Validación en el constructor y en los setters |
| Sin pruebas | 30 pruebas unitarias con JUnit 5 |
| `String.format` dependiente del locale del sistema | `String.format(Locale.US, ...)` → el separador decimal siempre es `.` |
| Todo en el paquete por defecto | Paquetes reales `com.urreadiego.poo.<tema>` |

> El último punto vale la pena: sin `Locale.US`, en un sistema en español el
> saldo se imprimía como `$500,00` en vez de `$500.00`. Una prueba unitaria lo
> detectó.

---

## Pruebas

```
[        30 tests found           ]
[         0 tests skipped         ]
[        30 tests started         ]
[         0 tests aborted         ]
[        30 tests successful      ]
[         0 tests failed          ]
```

Cubren: capacidad de `MiArrayList`, depósitos y retiros de la cuenta,
polimorfismo de figuras y vehículos, totales de factura, área y perímetro del
triángulo, y el catálogo de la biblioteca.

### Ejecutar con Maven

```bash
git clone https://github.com/urreadiego0518-code/poo-java.git
cd poo-java
mvn test
```

### Ejecutar sin Maven (solo JDK)

```bash
javac --release 17 -encoding UTF-8 -d out $(find src/main/java -name "*.java")
javac --release 17 -encoding UTF-8 -cp out -d out-test $(find src/test/java -name "*.java")
java -jar junit-platform-console-standalone.jar \
     -cp "out:out-test" execute --scan-class-path --details=tree
```

Descarga el JAR de JUnit desde
[Maven Central](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/).

---

## Ejecutar los ejemplos

```bash
# Triángulo por consola
java -cp out com.urreadiego.poo.geometria.TrianguloCMD

# Factura de ejemplo
java -cp out com.urreadiego.poo.facturacion.Principal

# Manejo de arreglos y ArrayList
java -cp out com.urreadiego.poo.colecciones.ManejoArrays
```

Los ejemplos con interfaz gráfica (`banco.Principal`, `biblioteca.Principal`,
`geometria.TrianguloPane`) usan Swing, así que necesitan escritorio.

---

## Estructura

```
poo-java/
├── pom.xml                          # Maven + JUnit 5
├── src/
│   ├── main/java/com/urreadiego/poo/
│   │   ├── herencia/                # FiguraGeometrica, Cuadrado, Cubo, Empleado, Gerente…
│   │   ├── polimorfismo/            # Animal, Vaca, Vehiculo, Automovil, Deportivo
│   │   ├── colecciones/             # MiArrayList, ManejoArrays
│   │   ├── banco/                   # CuentaBancaria (modelo) + Principal (Swing)
│   │   ├── facturacion/             # Producto, Factura, Principal
│   │   ├── biblioteca/              # Libro, Biblioteca, Principal
│   │   ├── geometria/               # Triangulo, TrianguloCMD, TrianguloPane
│   │   └── modelo/                  # Alumno, Perro, Mesero, Coche, CrearArchivo
│   └── test/java/com/urreadiego/poo/
│       ├── MiArrayListTest.java
│       ├── CuentaBancariaTest.java
│       ├── HerenciaTest.java
│       ├── PolimorfismoTest.java
│       ├── FacturaTest.java
│       ├── TrianguloTest.java
│       └── BibliotecaTest.java
├── LICENSE
└── README.md
```

---

## Conceptos que se practican

- **Abstracción** — `FiguraGeometrica` y `Animal` obligan a las subclases a
  implementar lo que cambia (`calcularArea()`, `comer()`).
- **Encapsulamiento** — atributos privados con accessors; `nombre` en `Empleado`
  es `protected` porque las subclases lo necesitan.
- **Herencia** — niveles de 2 y 3: `Cubo → Cuadrado → FiguraGeometrica`.
- **Polimorfismo** — un arreglo de `FiguraGeometrica[]` con `Cuadrado` y `Cubo`
  se recorre sin saber de qué tipo es cada elemento.
- **Composición** — una `Factura` está hecha de `Producto[]`.
- **Colecciones propias** — `MiArrayList<E>` extiende `ArrayList` y le añade un
  límite de capacidad.
- **Generics** — `MiArrayList<E>` acepta cualquier tipo sin perder seguridad.
- **Excepciones** — `IllegalArgumentException` para entradas inválidas,
  `IllegalStateException` para operaciones imposibles por el estado del objeto.
- **Pruebas unitarias** — cada concepto anterior verificado con JUnit 5.

---

## Licencia

MIT. Úsalo, modifícalo y compártelo. Ver [LICENSE](LICENSE).

---

<div align="center">
  <sub>Hecho por <a href="https://github.com/urreadiego0518-code">Diego Urrea Albores</a></sub>
</div>
