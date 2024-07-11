 
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
        for(Element element: elementList){
            AreaVisitor area = new AreaVisitor();
            element.accept(area);
        }
    }

    public void countVisitor(){
        int sum=0;
        for(Element element: elementList){
            CountVisitor count = new CountVisitor();
            element.accept(count);
            sum+=CountVisitor.getCount();
        }
        System.out.println(sum);
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
                containingElement.add(element);
            else {
                System.out.println(containingElement.getName()+" cannot contain " + element.getName());
            }


        }
    }

    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }


}
