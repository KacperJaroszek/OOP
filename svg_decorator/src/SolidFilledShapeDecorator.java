public class SolidFilledShapeDecorator extends ShapeDecorator {
    private String color;

    public SolidFilledShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String inputSvg) {
        return super.toSvg(String.format("fill=\"%s\" %s", color, inputSvg));
    }
}