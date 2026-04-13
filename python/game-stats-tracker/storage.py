import json
import os

def cargar_partidas():
    if os.path.exists("data/partidas.json"):
        with open("data/partidas.json", "r") as f:
            contenido = f.read()
            if contenido:
                return json.loads(contenido)
            else:
                return []
    else: return[]
    
def guardar_partidas(partidas):
    os.makedirs("data", exist_ok=True)
    with open("data/partidas.json", "w") as f:
        json.dump(partidas, f, indent=4)