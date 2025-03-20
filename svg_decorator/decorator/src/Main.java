
public class Main {
    public static void main(String[] args){
        Coffee coffee = new Coffee();
        SugarDecorator sugarCoffee = new SugarDecorator(coffee);
        MilkDecorator milkSugarCoffee = new MilkDecorator(sugarCoffee);
        System.out.println(milkSugarCoffee.serve());

        Beverage tea = new Tea();
        tea = new SugarDecorator(tea);
        System.out.println(tea.serve());
    }
}