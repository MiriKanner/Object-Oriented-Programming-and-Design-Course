 
public class Lake extends CompositeElements {
    public Lake(String name, double diameter, String path) {
        super(diameter,diameter,path,name);
    }
    public void accept(ElementVisitor v) {
        v.visit(this);
        for (Element element: elements) { element.accept(v);   }
    }
    @Override
    public String getName() {
        return "Lake";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
}
