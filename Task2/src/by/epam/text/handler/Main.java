package by.epam.text.handler;

import by.epam.text.handler.Element.Sentence;

public class Main {

    public static void main(String[] args) {

        // EXAMPLE

        StringBuilder text = new StringBuilder("Создать программу обработки фрагмента текста учебника по " +
                "программированию с использованием элементов, например: Символ, Слово, Предложение, Текст, Абзац, " +
                "Листинг, Лексема, Знак препинания и др. Приложение должно осуществлять разбор текста на элементы с " +
                "обязательной возможностью восстановления текста в исходном виде. " +
                "Можно использовать шаблон Composite. Во всех задачах с формированием текста разрешено заменять " +
                "табуляции и последовательности пробелов одним пробелом. ");

        TextHandler textHandler = new TextHandler(text);

        Sentence[] sentences = textHandler.parseText();

        for(int i = 0; i < sentences.length; i++) {
            sentences[i].print();
        }
        System.out.println();
        // completing task
        for(int i = 0; i < sentences.length; i++) {
            sentences[i].removeSubstring("о", "н");
        }
        System.out.println(textHandler.combineSentences(sentences));



    }
}
