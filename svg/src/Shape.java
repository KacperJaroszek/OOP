public abstract class Shape {
    //pozwala na dostep do klas dziedziczacych
    protected Style style;

    public Shape(Style style) {
        this.style = style;
    }

    public abstract String toSvg();
}
