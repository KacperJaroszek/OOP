public interface Shape {
    BoundingBox boundingBox();
    String toSvg(String inputString);
    default String toSvg(){
        return toSvg();
    }
}
