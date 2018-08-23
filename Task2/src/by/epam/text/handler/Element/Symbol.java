package by.epam.text.handler.Element;

public class Symbol implements Element {

    private StringBuilder symbol;


    public Symbol(StringBuilder symbol){
        this.symbol = symbol;
    }


    public StringBuilder get() {
        return symbol;
    }

    public void set(StringBuilder symbol) {
        this.symbol = symbol;
    }


    @Override
    public void print() {
        System.out.print(symbol);
    }


}
