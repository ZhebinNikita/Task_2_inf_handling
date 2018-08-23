package by.epam.text.handler;

import by.epam.text.handler.Element.CompoundElement;
import by.epam.text.handler.Element.Element;
import by.epam.text.handler.Element.Text;

import java.util.List;

public class TextEditor {


    private TextEditor(){
        // something
    }


    public static CompoundElement parseTextIntoParagraphs(Text element){

        CompoundElement paragraphs = new CompoundElement();

        StringBuilder text = element.get();

        int start = 0;
        int finish = 0;
        int size = -1;

        for(int i = 0; i < text.length() - 1; i++){
            if(text.charAt(i) == ' ' && text.charAt(i+1) == ' '){ // Start Paragraph
                size++;
            }
        }


        for(int i = 0; i < text.length() - 1; i++){
            if(text.charAt(i) == ' ' && text.charAt(i+1) == ' '){ // Start Paragraph
                //
            }
        }

        return paragraphs;

    }


    public StringBuilder removeSubstring(StringBuilder text, String a, String b) {

        String buf = text.toString();

        text = new StringBuilder(buf.replaceAll(a + ".*" + b, ""));

        return text;
    }


}
