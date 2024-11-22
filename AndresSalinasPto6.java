import java.util.Scanner;
import java.util.Stack;

public class AndresSalinasPto6 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        AndresSalinasPto6 accion = new AndresSalinasPto6();
        accion.menu();
    }

    public void menu() {
        AndresSalinasPto6 accion = new AndresSalinasPto6();
        Boolean contiuar = true;

        System.out.println("Ingrese la dimension 1 de la matriz: ");
        int dim1 = sc.nextInt();

        System.out.println("Ingrese la dimension 2 de la matriz: ");
        int dim2 = sc.nextInt();

        int[][] matriz1 = accion.llenarMatriz(dim1, dim2);
        int[][] matriz2 = accion.llenarMatriz(dim1, dim2);

        while (contiuar) {

            System.out.println("---SELECCIONE UNA OPCIÓN---\n"
                    + "1. Mostrar Matriz\n"
                    + "2. Mostrar Pilas\n"
                    + "3. Multiplicaión Matrices\n"
                    + "4. Salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    accion.mostrarMatriz(matriz1, dim1, dim2);
                    break;
                case 2:
                    System.out.println("---PROMEDIO FILAS--");
                    Stack<Double> pila = sumaFilas(matriz1, dim1, dim2);
                    accion.mostrarPila(pila);
                    System.out.println();
                    System.out.println("---RAIZ CUADRADA COLUMNAS---");
                    Stack<Double> pila2 = sumaColumnas(matriz1, dim1, dim2);
                    accion.mostrarPila(pila2);
                    System.out.println();
                    break;
                case 3:
                    Stack<Integer> pila3 = multiMatrices(matriz1, matriz2, dim1, dim2);
                    System.out.println("Matriz a:");
                    accion.mostrarMatriz(matriz1, dim1, dim2);
                    System.out.println();
                    System.out.println("Matriz b:");
                    accion.mostrarMatriz(matriz2, dim1, dim2);
                    System.out.println();
                    System.out.println("---MULTIPLICACIÓN---");
                    pila3 = accion.multiMatrices(matriz1, matriz2, dim1, dim2);
                    System.out.println(pila3);
                    System.out.println();
                    break;
                case 4:
                    contiuar = false;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }

    public int[][] llenarMatriz(int dim1, int dim2) {

        int[][] matriz1 = new int[dim1][dim2];

        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {

                matriz1[i][j] = (int) (Math.random() * 100 + 1);
            }
        }
        return matriz1;
    }

    public void mostrarMatriz(int[][] matriz, int dim1, int dim2) {
        System.out.println();
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {

                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Stack<Double> sumaFilas(int[][] matriz1, int dim1, int dim2) {

        Stack<Double> pila = new Stack<>();
        Double suma = 0.0;
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                suma = suma + matriz1[i][j];
            }
            pila.push(suma / dim2);
        }
        return pila;
    }

    public Stack<Double> sumaColumnas(int[][] matriz1, int dim1, int dim2) {

        Stack<Double> pila = new Stack<>();
        Double suma = 0.0;

        for (int i = 0; i < dim2; i++) {
            for (int j = 0; j < dim1; j++) {
                suma = suma + matriz1[j][i];
            }
            pila.push(Math.sqrt(suma));
            suma = 0.0;
        }

        return pila;
    }

    public void mostrarPila(Stack<Double> pila) {
        System.out.println(pila);
    }

    public Stack<Integer> multiMatrices(int[][] matriz1, int[][] matriz2, int dim1, int dim2) {

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                pila.push(matriz1[i][j] * matriz2[i][j]);
            }
        }
        return pila;
    }
}