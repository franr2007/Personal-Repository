import storage
import stats

partidas = storage.cargar_partidas()

while True:

    #menu
    print()
    print("=== Game Stats Tracker ===")
    print()
    print("1. Registrar partida")
    print("2. Ver Historial")
    print("3. Ver estadísticas")
    print("4. salir")
    print()

    eleccion = input("Elige una opcion: ")

    if eleccion=="1":
        nomJuego= input("Nombre del juego: ")
        puntuacion=input("Puntuacion: ")
        duracion=input("Duracion: ")
        resultado=input("Resultado: ")
        partida = {
            "juego": nomJuego,
            "puntuacion": puntuacion,
            "duracion": duracion,
            "resultado": resultado
        }
        partidas.append(partida)
        storage.guardar_partidas(partidas)
    elif eleccion=="2":
        for partida in partidas:
            print()
            print(f"Juego: {partida['juego']}")
            print(f"Puntuacion: {partida['puntuacion']}")
            print(f"Duracion: {partida['duracion']}")
            print(f"Resultado: {partida['resultado']}")
            print()
    elif eleccion=="3":
        print()
        stats.mejor_puntuacion(partidas)
        stats.media_duracion(partidas)
    elif eleccion=="4":
        break
    else: print("Eleccion erronea")