 
public class Lake extends CompositeElements {
    public Lake(String name, double diameter, String path) {
        super(diameter,diameter,path,name);
    }
    public void accept(ElementVisitor v) {

        for (Element element: elements) {
            element.accept(v);
        }
        v.visit(this);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
}
