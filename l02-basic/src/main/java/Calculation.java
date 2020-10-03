import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Сalculation {

    //Ввод данных + проверка на number и отрицательное значение:
    public static int inputPlusCheck() {
        int a;
        while (true) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                a = sc.nextInt();
                if (a < 0) {
                    System.out.println("Вы ввели значение меньше 0, просьба ввести корректное значение: ");
                } else {
                    break;
                }
            } else {
                System.out.println("Вы ввели не цифровое значение, повторите ввод: ");
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String typeOfShape;
        Shapes shape;
        int a, b, c;
        System.out.println("Из списка ниже выберите фигуру, для которой необходимо рассчитать периметр и площадь:");
        System.out.println("1. Треугольник;");
        System.out.println("2. Квадрат;");
        System.out.println("3. Прямоугольник;");
        System.out.println("Введите наименование фигуры: ");
        typeOfShape = reader.readLine();

//Квадрат:
        if (typeOfShape.equals("Квадрат") | typeOfShape.equals("квадрат")) {
            shape = new Square();
            System.out.println("Необходимо ввести длину любой стороны квадрата (a):");
            System.out.println("Введите сторону a:");
            a = inputPlusCheck();
            shape.calcPerimetr(a);
            shape.calcArea(a);
//Прямоугольник:
        } else if (typeOfShape.equals("Прямоугольник") | typeOfShape.equals("прямоугольник")) {
            shape = new Rectangle();
            System.out.println("Необходимо ввести длины 2-ух разных сторон прямоугольника (a, b):");
            System.out.println("Введите сторону a:");
            a = inputPlusCheck();
            System.out.println("Введите сторону b:");
            b = inputPlusCheck();
            shape.calcPerimetr(a, b);
            shape.calcArea(a, b);

//Треугольник:
        } else if (typeOfShape.equals("Треугольник") | typeOfShape.equals("треугольник")) {
            shape = new Triangle();
            System.out.println("Необходимо ввести длины каждой из сторон треугольник(a,b,c):");
            System.out.println("Введите сторону a:");
            a = inputPlusCheck();
            System.out.println("Введите сторону b:");
            b = inputPlusCheck();
            System.out.println("Введите сторону c:");
            c = inputPlusCheck();
            shape.calcPerimetr(a, b, c);
            shape.calcArea(a, b, c);
        } else {
            System.out.println("Вы ввели некорректное значение фигуры, попробуйте еще раз");
        }
    }


}
