package by.epam.text.handler.Element;

public class Paragraph implements Element {

    private StringBuilder paragraph;


    public Paragraph(StringBuilder paragraph){
        this.paragraph = paragraph;
    }


    public StringBuilder get() {
        return paragraph;
    }

    public void set(StringBuilder paragraph) {
        this.paragraph = paragraph;
    }


    @Override
    public void print() {
        System.out.print(paragraph);
    }


}
