import random

simbolos = ["🍒", "🍋", "🍊", "🔔", "⭐", "💎", "7️⃣"]

premios = {
    "🍒": 2,
    "🍋": 3,
    "🍊": 4,
    "🔔": 5,
    "⭐": 10,
    "💎": 20,
    "7️⃣": 50
}

saldo = 10

primeraVez = True

if primeraVez:
    print("================================")
    print("   🎰 ¡BIENVENIDO A LA SLOT! 🎰")
    print("================================")
    print()
    print("¡Prepárate para probar tu suerte! (Te regalamos 10 € para empezar)")
    print()
else:
    print("========== MENÚ PRINCIPAL ==========")
    print()
    print(f"Saldo: {saldo}€")
    print()
    print("1. Jugar")
    print("2. Ingresar dinero")
    print("3. Retirar dinero")
    print("4. Premios")
    print("5. Salir")
    print()
    print("====================================")   

eleccion = input()

if eleccion == 1:
        apostando = True
        
        while apostando:
    
            apuesta = int(input("¿Cuánto quieres apostar? "))
            
            if apuesta > 0 and apuesta <= saldo:
                apostando = False
            else:
                print("La apuesta tiene que ser mayor que 0€ y no puede superar el saldo en su cuenta")
    
        jugar = True
        
        while jugar:    
    
            palanca = input("Pulsa 'Intro' para girar, X para volver")
            
            if palanca is "X":
                jugar = False
        
            rueda1 = random.choice(simbolos)
            rueda2 = random.choice(simbolos)
            rueda3 = random.choice(simbolos)
            
            giro = [rueda1,rueda2,rueda3]

            print()
            print(f"Giro: {giro}")
            print()
            
            if giro[0] == giro[1] == giro[2]:
                premio = premios[giro[0]]
                premio = premio*apuesta

            
            print(f"Premio:")