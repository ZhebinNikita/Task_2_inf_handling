package by.epam.text.handler.Element;



public class Sentence implements Element {

    private StringBuilder sentence;


    public Sentence(StringBuilder sentence) {
        this.sentence = sentence;
    }


    public StringBuilder get(){
        return this.sentence;
    }
    public void set(StringBuilder sentence){
        this.sentence = sentence;
    }


    public void removeSubstring(String a, String b) {

        String buf = this.sentence.toString();

        this.sentence = new StringBuilder(buf.replaceAll(a + ".*" + b, ""));

    }


    @Override
    public void print(){
        System.out.print(sentence);
    }

}
