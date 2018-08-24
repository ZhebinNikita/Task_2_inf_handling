package by.epam.text.handler;

import by.epam.text.handler.Element.*;


public class Main {

    public static void main(String[] args) {


        /**
         * 11.	В каждом предложении текста исключить подстроку максимальной длины,
         * начинающуюся и заканчивающуюся заданными символами.
         * */

        ////////////////////////  Task Example, Variant 11  ////////////////////////

        StringBuilder text = new StringBuilder("Создать программу обработки фрагмента текста учебника по " +
                "программированию с использованием составных элементов текста. Приложение должно осуществлять разбор текста на элементы с " +
                "обязательной возможностью восстановления текста в исходном виде. " +
                "Можно использовать шаблон Composite. Во всех задачах с формированием текста разрешено заменять " +
                "табуляции и последовательности пробелов одним пробелом. ");

        TaskHandler taskHandler = new TaskHandler(text);

        Sentence[] sentences = taskHandler.parseText();

        for(int i = 0; i < sentences.length; i++) {
            sentences[i].print();
            System.out.println();
        }
        System.out.println("\n");
        // completing task
        for(int i = 0; i < sentences.length; i++) {
            sentences[i].removeSubstring("о", "н"); // начинающуюся и заканчивающуюся заданными символами.
        }
        System.out.println(taskHandler.combineSentences(sentences));

        ////////////////////////  Task Example, Variant 11  ////////////////////////





        StringBuilder someText = new StringBuilder(
                "  Книга разбита на четыре логические части. В первой части даны фундаментальные основы " +
                        "языка Java и концепции объектно-ориентированного программирования." +

                        "  Во второй части изложены наиболее важные аспекты применения языка, в частности коллекции " +
                        "и базы данных, многопоточность и взаимодействие с XML." +

                        "  В третьей части приведены основы программировании распределенных " +
                        "информационных систем с применением сервлетов, JSP." +

                        "  В четвертой даны основы применения " +
                        "шаблонов проектирования."
        );

        Text textObject = new Text(someText);

        CompoundElement paragraphs = TextEditor.parseTextIntoParagraphs(textObject);

        System.out.println("\n4 Paragraphs: \n\n");

        paragraphs.print();


        ///////////////////////////////////////////////////////////////////////////////////////////////


        StringBuilder someParagraph = new StringBuilder(
                "Книга разбита на четыре логические части. В первой части даны фундаментальные основы " +
                        "языка Java и концепции объектно-ориентированного программирования. " +
                        "Во второй части изложены наиболее важные аспекты применения языка, в частности коллекции " +
                        "и базы данных, многопоточность и взаимодействие с XML. В третьей части приведены основы " +
                        "программировании распределенных информационных систем с применением сервлетов, JSP. " +
                        "В четвертой даны основы применения шаблонов проектирования."
        );

        Paragraph pObject = new Paragraph(someParagraph);

        CompoundElement compountSentences = TextEditor.parseParagraphIntoSentences(pObject);

        System.out.println("\n 5 Sentences: \n\n");

        compountSentences.print();


        ///////////////////////////////////////////////////////////////////////////////////////////////


        StringBuilder someSentence = new StringBuilder(
                "Книга разбита на четыре логические части."
        );

        Sentence sObject = new Sentence(someSentence);

        CompoundElement words = TextEditor.parseSentenceIntoWords(sObject);

        System.out.println("\n 6 Words: \n\n");

        words.print();


        ///////////////////////////////////////////////////////////////////////////////////////////////


        StringBuilder someSymbols = new StringBuilder(
                "123."
        );

        Word wObject = new Word(someSymbols);

        CompoundElement symbols = TextEditor.parseWordIntoSymbols(wObject);

        System.out.println("\n 4 Symbols: \n\n");

        symbols.print();


        ///////////////////////////////////////////////////////////////////////////////////////////////

    }
}
