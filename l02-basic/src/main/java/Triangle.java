public class Triangle extends Shapes {

    //Треугольник
    int a, b, c,  triangleP, triangleHalfP;
    double triangleS;

    @Override
    public int calcPerimetr(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        //Расчет периметра(P) треугольника:
        triangleP = a + b + c;
        System.out.println("Периметр треугольника по введенным данным равен: " + triangleP);
        return triangleP;
    }

    @Override
    public double calcArea(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        //Расчет площади (S) треугольника:
        triangleHalfP = triangleP / 2;
        triangleS = Math.sqrt(triangleHalfP * (triangleHalfP - a) * (triangleHalfP - b) * (triangleHalfP - c));
        System.out.println("Площадь треугольника по введенным данным равна: " + triangleS);
        return triangleS;
    }
}