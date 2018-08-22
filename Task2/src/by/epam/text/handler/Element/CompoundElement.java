package by.epam.text.handler.Element;

import java.util.ArrayList;
import java.util.List;


// Контейнер содержит операции добавления/удаления дочерних
// компонентов.
public class CompoundElement implements Element{

    private List<Element> elements;


    public CompoundElement(){
        elements = new ArrayList<>();
    }


    public void add(Element element){
        elements.add(element);
    }

    public void remove(Element element){
        elements.remove(element);
    }


    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<Element> getElements() {
        return elements;
    }


    @Override
    public void print() {
        for (Element element : this.elements) {
            element.print();
        }
    }


}
