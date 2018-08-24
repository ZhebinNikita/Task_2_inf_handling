package by.epam.text.handler;

import by.epam.text.handler.Element.*;

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
        boolean exit = false;


        // "  " - Start Paragraph

        for(;;) {
            for (int i = start; i < text.length() - 1; i++) { // Got Start
                if (text.charAt(i) == ' ' && text.charAt(i + 1) == ' ') {
                    start = i + 2;
                    break;
                }
            }
            for (int i = start; i < text.length() - 1; i++) { // Got Finish
                if (i == text.length() - 2) {
                    finish = text.length() - 1;
                    exit = true;
                    break;
                }
                if (text.charAt(i) == ' ' && text.charAt(i + 1) == ' ') {
                    finish = i - 1;
                    break;
                }
            }
            Paragraph paragraph = new Paragraph(new StringBuilder(text.substring(start, finish+1)));
            paragraphs.add(paragraph);
            start = finish;
            if (exit) break;
        }


        return paragraphs;
    }


    public static CompoundElement parseParagraphIntoSentences(Paragraph element){

        CompoundElement sentences = new CompoundElement();

        StringBuilder text = element.get();

        int start = 0;
        int finish = 0;
        boolean exit = false;

        for(;;) {
            for (int i = start; i < text.length(); i++) {
                if(i == text.length()-1){
                    finish = text.length()-1;
                    exit = true;
                    break;
                }
                if (text.charAt(i) == CompletionSigns.DOT
                        || text.charAt(i) == CompletionSigns.QuestionMark
                        || text.charAt(i) == CompletionSigns.ExclamationMark) {
                    finish = i;
                    break;
                }
            }
            Sentence sentence = new Sentence(new StringBuilder(text.substring(start, finish+1)));
            sentences.add(sentence);
            start = finish + 2;
            if(exit) break;
        }

        return sentences;
    }


    public static CompoundElement parseSentenceIntoWords(Sentence element){

        CompoundElement words = new CompoundElement();

        StringBuilder text = element.get();

        int start = 0;
        int finish = 0;
        boolean exit = false;

        for(;;) {
            for (int i = start; i < text.length(); i++) {
                if (i == text.length() - 1) {
                    finish = text.length() - 1;
                    exit = true;
                    break;
                }
                if (text.charAt(i) == ' ') {
                    finish = i-1;
                    break;
                }
            }

            Word word = new Word( new StringBuilder(text.substring(start, finish+1)) );
            words.add(word);
            start = finish+2;
            if(exit)break;
        }

        return words;
    }


    public static CompoundElement parseTextIntoSymbols(Text element){

        CompoundElement symbols = new CompoundElement();

        StringBuilder text = element.get();

        for(int i = 0; i < text.length(); i++){
            Symbol symbol = new Symbol( new StringBuilder(String.valueOf(text.charAt(i))) );
            symbols.add(symbol);
        }

        return symbols;
    }
    public static CompoundElement parseParagraphIntoSymbols(Paragraph element){

        CompoundElement symbols = new CompoundElement();

        StringBuilder text = element.get();

        for(int i = 0; i < text.length(); i++){
            Symbol symbol = new Symbol( new StringBuilder(String.valueOf(text.charAt(i))) );
            symbols.add(symbol);
        }

        return symbols;
    }
    public static CompoundElement parseSentenceIntoSymbols(Sentence element){

        CompoundElement symbols = new CompoundElement();

        StringBuilder text = element.get();

        for(int i = 0; i < text.length(); i++){
            Symbol symbol = new Symbol( new StringBuilder(String.valueOf(text.charAt(i))) );
            symbols.add(symbol);
        }

        return symbols;
    }
    public static CompoundElement parseWordIntoSymbols(Word element){

        CompoundElement symbols = new CompoundElement();

        StringBuilder text = element.get();

        for(int i = 0; i < text.length(); i++){
            Symbol symbol = new Symbol( new StringBuilder(String.valueOf(text.charAt(i))) );
            symbols.add(symbol);
        }

        return symbols;
    }




    public static Element combineSymbolsIntoElement(CompoundElement compoundElement){

        Element element;

        List<Element> symbols = compoundElement.get();
        StringBuilder text = new StringBuilder();

        for(int i = 0; i < symbols.size(); i++){
            text.append( ((Symbol)symbols.get(i)).get() );
        }

        element = new Text(text);

        return element;
    }


    public static Element combineWordsIntoSentence(CompoundElement compoundElement){

        Element element;

        List<Element> words = compoundElement.get();
        StringBuilder sentence = new StringBuilder();

        for(int i = 0; i < words.size(); i++){
            sentence.append( ((Word)words.get(i)).get() ).append(' ');
        }
        sentence.append('.');

        element = new Sentence(sentence);

        return element;
    }


    public static Element combineSentencesIntoParagraph(CompoundElement compoundElement){

        Element element;

        List<Element> sentences = compoundElement.get();
        StringBuilder paragraph = new StringBuilder();

        for(int i = 0; i < sentences.size(); i++){
            paragraph.append( ((Text)sentences.get(i)).get() );
        }

        element = new Paragraph(paragraph);

        return element;
    }


    public static Element combineParagraphsIntoText(CompoundElement compoundElement){

        Element element;

        List<Element> paragraphs = compoundElement.get();
        StringBuilder text = new StringBuilder();

        text.append("  ");
        for(int i = 0; i < paragraphs.size(); i++){
            text.append( ((Paragraph)paragraphs.get(i)).get() ).append("\n  ");
        }

        element = new Text(text);

        return element;
    }


}
