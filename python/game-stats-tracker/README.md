# Game Stats Tracker

Herramienta de consola para registrar y consultar estadísticas de tus partidas. Los datos se guardan localmente en un archivo JSON y persisten entre sesiones.

---

## Cómo ejecutarlo

Requiere **Python 3.12 o superior**. No necesita dependencias externas.

```bash
python main.py
```

---

## Opciones del menú

| Opción | Descripción |
|--------|-------------|
| 1. Registrar partida | Introduce los datos de una nueva partida (juego, puntuación, duración y resultado) |
| 2. Ver historial | Muestra todas las partidas registradas |
| 3. Ver estadísticas | Muestra la mejor puntuación y la media de duración |
| 4. Salir | Cierra la aplicación |

---

## Estructura del proyecto

```
game-stats-tracker/
├── main.py        # Menú y flujo principal
├── stats.py       # Lógica de estadísticas
├── storage.py     # Lectura y escritura del JSON
├── data/
│   └── partidas.json   # Datos generados automáticamente
└── README.md
```

---

## Tecnologías

- Python 3.12
- Módulos de la stdlib: `json`, `os`

---

## Sobre el proyecto

Proyecto personal desarrollado para practicar Python partiendo de una base de Java. Cubre manejo de ficheros, estructuras de datos (listas y diccionarios) y organización modular del código.