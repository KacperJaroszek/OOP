import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon triangle = new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        });

        Polygon rectangle = new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        });

        Polygon pentagon = new Polygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        });

        SolidFilledShapeDecorator redPentagon =
                new SolidFilledShapeDecorator(pentagon, "red");
        StrokeShapeDecorator blueStrokeRedPentagon =
                new StrokeShapeDecorator(redPentagon, "blue", 3.0);
        TransformationDecorator transformBlueStrokeRedPentagon = new TransformationDecorator.Builder().build(blueStrokeRedPentagon);

        Shape ellipse = new Ellipse(new Vec2(500, 700), 400, 100);
        ellipse = new SolidFilledShapeDecorator(ellipse, "green");
        ellipse = new StrokeShapeDecorator(ellipse, "black", 5.0);

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(transformBlueStrokeRedPentagon);
        scene.addShape(ellipse);
        scene.save("result.svg");
    }
}