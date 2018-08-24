package by.epam.text.handler.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Контейнер содержит операции добавления/удаления дочерних
// компонентов.
public class CompoundElement implements Element{

    private List<Element> elements = new ArrayList<>();


    public CompoundElement(Element...components){
        add(components);
    }


    public void add(Element element){
        elements.add(element);
    }

    public void add(Element... element){
        elements.addAll(Arrays.asList(element));
    }


    public void remove(Element element){
        elements.remove(element);
    }

    public void remove(Element... element){
        elements.removeAll(Arrays.asList(element));
    }


    public void clear(){
        elements.clear();
    }


    public List<Element> get() {
        return elements;
    }

    public void set(List<Element> elements) {
        this.elements = elements;
    }


    @Override
    public void print() {
        for (Element element : this.elements) {
            element.print();
            System.out.println("\n");
        }
    }


}
