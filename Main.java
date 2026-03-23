import java.util.Scanner;

// Clase Nodo
class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}

// Clase Árbol Binario
class ArbolBinario {
    Nodo raiz;

    // Insertar
    public Nodo insertar(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        }

        if (dato < raiz.dato) {
            raiz.izquierdo = insertar(raiz.izquierdo, dato);
        } else {
            raiz.derecho = insertar(raiz.derecho, dato);
        }

        return raiz;
    }

    // Recorrido inorden
    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.print(raiz.dato + " ");
            inorden(raiz.derecho);
        }
    }

    // Buscar
    public boolean buscar(Nodo raiz, int dato) {
        if (raiz == null) {
            return false;
        }

        if (raiz.dato == dato) {
            return true;
        }

        if (dato < raiz.dato) {
            return buscar(raiz.izquierdo, dato);
        } else {
            return buscar(raiz.derecho, dato);
        }
    }
}

// Clase principal con menú
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion, dato;

        do {
            System.out.println("\n--- MENÚ ÁRBOL BINARIO ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número: ");
                    dato = sc.nextInt();
                    arbol.raiz = arbol.insertar(arbol.raiz, dato);
                    break;

                case 2:
                    System.out.println("Recorrido inorden:");
                    arbol.inorden(arbol.raiz);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Número a buscar: ");
                    dato = sc.nextInt();
                    if (arbol.buscar(arbol.raiz, dato)) {
                        System.out.println("El número SI existe");
                    } else {
                        System.out.println("El número NO existe");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }
}