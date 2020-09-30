import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shapes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String typeOfShape;
        int triangleA,triangleB,triangleC, triangleP, triangleHalfP;
        double triangleS;
        int squareA, squareP, squareS;
        int rectangleA, rectangleB, rectangleP, rectangleS;
        System.out.println("Из списка ниже выберите фигуру, для которой необходимо рассчитать периметр и площадь:");
        System.out.println("1. Треугольник;");
        System.out.println("2. Квадрат;");
        System.out.println("3. Прямоугольник;");
        System.out.println("Введите наименование фигуры: ");
        typeOfShape = reader.readLine();
//Треугольник:
        if (typeOfShape.equals("Треугольник") | typeOfShape.equals("треугольник")) {
            System.out.println("Необходимо ввести длины каждой из сторон треугольник(a,b,c):");
            System.out.println("Введите сторону a:");
            triangleA = Integer.parseInt(reader.readLine());
            System.out.println("Введите сторону b:");
            triangleB = Integer.parseInt(reader.readLine());
            System.out.println("Введите сторону c:");
            triangleC = Integer.parseInt(reader.readLine());
            //System.out.println("triangleA: " + triangleA + " triangleB: " + triangleB + " triangleC: " + triangleC);
            //Расчет периметра(P) треугольника:
            triangleP = triangleA + triangleB + triangleC;
            System.out.println("Периметр треугольника по введенным данным равен: " + triangleP);
            //Расчет площади (S) треугольника:
            triangleHalfP = triangleP / 2;
            triangleS = Math.sqrt(triangleHalfP * (triangleHalfP - triangleA) * (triangleHalfP - triangleB) * (triangleHalfP - triangleC)) ;
            System.out.println("Площадь треугольника по введенным данным равна: " + triangleS);
//Квадрат:
        } else if (typeOfShape.equals("Квадрат") | typeOfShape.equals("квадрат")) {
            System.out.println("Необходимо ввести длину любой стороны квадрата (a):");
            System.out.println("Введите сторону a:");
            squareA = Integer.parseInt(reader.readLine());
            //Расчет периметра(P) квадрата:
            squareP = squareA * 4;
            System.out.println("Периметр квадрата по введенным данным равен: " + squareP);
            //Расчет площади (S) квадрата:
            squareS = squareA * squareA;
            System.out.println("Площадь квадрата по введенным данным равна: " + squareS);
//Прямоугольник:
        } else if (typeOfShape.equals("Прямоугольник") | typeOfShape.equals("прямоугольник")) {
            System.out.println("Необходимо ввести длины 2-ух разных сторон прямоугольника (a, b):");
            System.out.println("Введите сторону a:");
            rectangleA = Integer.parseInt(reader.readLine());
            System.out.println("Введите сторону b:");
            rectangleB = Integer.parseInt(reader.readLine());
            //Расчет периметра(P) квадрата:
            rectangleP = 2 * (rectangleA + rectangleB);
            System.out.println("Периметр прямоугольника по введенным данным равен: " + rectangleP);
            //Расчет площади (S) квадрата:
            rectangleS = rectangleA * rectangleB;
            System.out.println("Площадь прямоугольника по введенным данным равна: " + rectangleS);
        }
    }
}
