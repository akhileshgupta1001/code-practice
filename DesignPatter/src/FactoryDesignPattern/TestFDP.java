public class TestFDP {
    public static void main(String[] args) {
     ShapeFactory factory =  new ShapeFactory();
     Shape shape = factory.getShape("CIRCLE");
     shape.draw();
    }
}
