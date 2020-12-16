package domino;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prueba {

    //metodo para leer entero por teclado
    public static int leerInt() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int num = 0;
        //loop para filtrar excepciones
        do {
            try {
                num = sc.nextInt();
                ok = true;
            } catch (InputMismatchException e) {
                System.out.println("Se ha producido un error. Intentalo de nuevo");
                sc.nextLine();
            }
        } while (!ok);
        return num;
    }

    //metodo para comprobar si es seis doble
    public static boolean esSeisDoble(FichaDomino ficha) {
        return ficha.getValorA() == 6 && ficha.getValorB() == 6;
    }

    public static void main(String[] args) {

        //pide f1
        System.out.println("Introduce valores para f1:");
        FichaDomino f1 = new FichaDomino();
        f1.setValorA(leerInt());
        f1.setValorB(leerInt());

        //pide f2
        System.out.println("Introduce valores para f2:");
        FichaDomino f2 = new FichaDomino();
        f2.setValorA(leerInt());
        f2.setValorB(leerInt());

        //Imprime f1 y f2
        System.out.println("f1= " + f1.toString() + " f2= " + f2.toString());

        //Crea e imprime un f3 con datos erroneos
        FichaDomino f3 = new FichaDomino(-542, 87);
        System.out.println("f3= " + f3.toString());

        //crea f4 sin parametros
        FichaDomino f4 = new FichaDomino();

        //imprime valores de f4 con los metodos get
        System.out.println("Los valores de f4 son: " + f4.getValorA() + " y " + f4.getValorB());
        
        //cambia los valores de f4 y lo imprime
        f4.setValorA(4);
        f4.setValorB(2);
        System.out.println("f4= " + f4.toString());
        
        //Muestra valor de la suma de fichas aleatoriamente hasta que encuentra un seis doble
        FichaDomino ficha;
        int acumulador = 0;
        do {
            ficha = FichaDomino.aleatoria();     
            acumulador++;
            System.out.println("Se ha generado "+ ficha.toString() + " con valor total: " + ficha.getValorTotal());
        } while (!esSeisDoble(ficha));
        System.out.println("Se ha encontrado la ficha seis doble tras generar " + acumulador + " fichas.");
    }
}
