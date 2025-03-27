import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator{
    private String transform;

    private TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String toSvg(String inputSvg) {
        return super.toSvg(String.format("transform=\"%s\" %s", transform,inputSvg));
    }

    public static class Builder{
        private String transform ="";
        public Builder translate(Vec2 translation){
            this.transform += String.format(Locale.ENGLISH,
                    " translate(&f %f) ",
                    translation.x(), translation.y());
            this.transform = this.transform.trim();
            return this;
        }

        public TransformationDecorator build(Shape shape){
            TransformationDecorator decorator = new TransformationDecorator(shape);
            decorator.transform = this.transform;
            return decorator;
        }
    }
}
