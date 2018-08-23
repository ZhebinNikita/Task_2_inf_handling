package by.epam.text.handler.Element;

public class Word implements Element {

    private StringBuilder word;


    public Word(StringBuilder word){
        this.word = word;
    }


    public StringBuilder get() {
        return word;
    }

    public void set(StringBuilder word) {
        this.word = word;
    }


    @Override
    public void print() {
        System.out.print(word);
    }


}
