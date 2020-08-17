package SingleExercisesEntities;

public class Rectangle {

    //Atributos do Objecto Rectangulo

    public double width;
    public double height;

    //Metodo de calculo da area

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return (width + height) * 2;
    }

    public double diagonal() {
        return Math.sqrt((width * width) + (height * height));
    }
}
