public class SolidFieldPolygon extends Polygon{
    private String color;

    public SolidFieldPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toSvg(String inputSvg){
        return super.toSvg(String inputSvg.format(
                "fill=\"%s\" %s",
                color, inputSvg
        ));
    }
}
