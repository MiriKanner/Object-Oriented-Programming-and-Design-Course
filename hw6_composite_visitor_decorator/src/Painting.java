 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;
    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }

    public void longPrint(){
        for(Element element: elementList){
            LongPrintVisitor printer = new LongPrintVisitor();
            element.accept(printer);
        }
    }

    public void Area(){
        AreaVisitor area = new AreaVisitor();
        for(Element element: elementList){

            element.accept(area);
        }
        System.out.println(area.getArea());
    }

    public void countVisitor(){
        int sum = 0;
        CountVisitor counter = new CountVisitor();
        for (Element element: elementList){
            element.accept(counter);
        }
        System.out.println(counter.getCount());
    }



public  void  shortPrint(){
    for(Element element: elementList){
        PrintNameVisitor print = new PrintNameVisitor();
        element.accept(print);
    }

}
    public void addElement(Element element){
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()){
            elementList.add(element);
        }
        else {
            CompositeElements containingElement = (CompositeElements) pathToElementMap.get(element.getPath());
            if(element.getHabitat() != containingElement.getHabitat())
                containingElement.addChild(element);
            else {
                System.out.println(containingElement.getName()+" cannot contain " + element.getName());
            }


        }
    }

    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }


}
