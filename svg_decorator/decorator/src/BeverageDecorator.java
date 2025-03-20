public abstract class BeverageDecorator implements Beverage {
    protected Beverage decoratedBeverage;

    public BeverageDecorator(Beverage decoratedBeverage) {
        this.decoratedBeverage = decoratedBeverage;
    }

    @Override
    public String serve() {
        if(decoratedBeverage == null)
            return "";
        return decoratedBeverage.serve();
    }
}
