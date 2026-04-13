def mejor_puntuacion(partidas):
    mp=0
    for partida in partidas:
        if not partidas:
            print("No hay partidas registradas.")
            return
        elif int(partida['puntuacion'])>mp:
            mp=int(partida['puntuacion'])
            
    print(f"Mejor puntuación: {mp}")
    
def media_duracion(partidas):
    suma=0
    cp=0
    for partida in partidas:
        if not partidas:
            print("No hay partidas registradas.")
            return
        suma+=int(partida['duracion'])
        cp+=1
    media=suma/cp
    print(f"La media de duracion es: {media}")