import random
import string

def generarContrasena(longitud, letras, numeros, simbolos):
    caracteres = ""
    if letras == "s":
        caracteres += string.ascii_letters
    if numeros == "s":
        caracteres += string.digits
    if simbolos == "s":
        caracteres += string.punctuation
    resultado=random.choices(caracteres, k=longitud)
    return "".join(resultado)
        
    pass

while True:
    print("=== Password Generator ===")
    print("1. Generar contraseña")
    print("2. Salir")
    print()

    eleccion = input("Elige una opcion: ")

    if eleccion == "1":
        longitud = int(input("Longitud: "))
        letras = input("¿Incluir letras? (s/n): ")
        numeros = input("¿Incluir numeros? (s/n): ")
        simbolos = input("¿Incluir simbolos? (s/n): ")
        print()
        print(f"resultado: {generarContrasena(longitud, letras, numeros, simbolos)}")
        print()
    elif eleccion == "2":
        break
    else:
        print("Opcion no valida")