package by.epam.text.handler;

import by.epam.text.handler.Element.Sentence;


/**
 * 11.	В каждом предложении текста исключить подстроку максимальной длины,
 * начинающуюся и заканчивающуюся заданными символами.
 * */
public class TaskHandler {

    private StringBuilder text;


    public TaskHandler(){
        this.text = new StringBuilder();
    }
    public TaskHandler(StringBuilder text) {
        this.text = text;
    }


    /**
     * Разбор текста на предложения.
     * */
    public Sentence[] parseText(){

        Sentence[] sentences;
        int[] indexes;


        // Count the number of sentences in the text
        int number = 0;

        for(int i = 0; i < this.text.length(); i++){
            if(this.text.charAt(i) == CompletionSigns.DOT
                    || this.text.charAt(i) == CompletionSigns.QuestionMark
                    || this.text.charAt(i) == CompletionSigns.ExclamationMark){
                number++;
            }
        }


        // define sentences & indexes
        sentences = new Sentence[number];
        indexes = new int[number];


        // Initializing indexes
        int indexIterator = 0;
        for(int i = 0; i < this.text.length(); i++){
            if(this.text.charAt(i) == CompletionSigns.DOT
                    || this.text.charAt(i) == CompletionSigns.QuestionMark
                    || this.text.charAt(i) == CompletionSigns.ExclamationMark){
                indexes[indexIterator] = i;
                indexIterator++;
            }
        }


        // Initializing sentences
        for(int i = 0; i < number; i++){
            if(i == 0) {
                sentences[i] = new Sentence(new StringBuilder(this.text.substring(0, indexes[i]+1)));
            }
            else{
                sentences[i] = new Sentence(new StringBuilder(this.text.substring(indexes[i-1]+2, indexes[i]+1)));
            }
        }



        return sentences;
    }


    /**
     * Восстановление текста из предложений.
     * */
    public String combineSentences(Sentence[] sentences){
        StringBuilder text = new StringBuilder();

        for(int i = 0; i < sentences.length; i++){
            text.append(sentences[i].get());
            text.append(" ");
        }

        return text.toString();
    }


    public void setText(StringBuilder text) {
        this.text = text;
    }


}
