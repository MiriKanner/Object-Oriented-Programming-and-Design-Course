import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class CompositeElements extends Element {
    protected Set<Element> elements=new HashSet<>();

    public CompositeElements(double width, double length, String path,String name) {
        super(width, length, path);
        name=name;
    }
    public void add(Element component) {
        elements.add(component);
    }
    @Override
    public String getName() {
        return null;
        //return super.getName();
    }
    public void add(Element... components) {
        elements.addAll(Arrays.asList(components));
    }

    public void remove(Element child) {
        elements.remove(child);
    }

    public void remove(Element... components) {
        elements.removeAll(Arrays.asList(components));
    }

    public void clear() {
        elements.clear();
    }


}
