package by.epam.text.handler.Element;

public class Text implements Element {

    private StringBuilder text;


    public Text(StringBuilder text){
        this.text = text;
    }


    public StringBuilder get() {
        return text;
    }

    public void set(StringBuilder text) {
        this.text = text;
    }


    @Override
    public void print() {
        System.out.print(text);
    }


}
