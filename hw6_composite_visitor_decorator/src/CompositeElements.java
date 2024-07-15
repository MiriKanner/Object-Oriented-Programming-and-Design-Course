import java.util.ArrayList;
import java.util.List;

public abstract class CompositeElements extends Element {
    String name;
    List<Element> elements;
    public CompositeElements(String name, double diameter, String path) {
        super(diameter,diameter,path);
        this.name=name;
        this.elements=new ArrayList<>();
    }

    public void addChild(Element child) {
        this.elements.add(child);
    }
    @Override
    public String getName() {
        return name;
    }

    public void accept(ElementVisitor v) {
        this.elements.forEach(child -> child.accept(v));
    }
}
