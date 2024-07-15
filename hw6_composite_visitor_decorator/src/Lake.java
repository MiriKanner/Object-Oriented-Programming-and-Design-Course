

public class Lake extends CompositeElements {
    public Lake(String name, double diameter, String path) {
        super(name,diameter,path);
    }

    public void accept(ElementVisitor v) {
        v.visit(this);
        super.accept(v);
    }

    @Override
    public void addChild(Element child) {
        if(child instanceof Boat || child instanceof Kid || child instanceof Island)
            this.elements.add(child);
        else
            System.out.println(this.getName() + " cannot contain " + child.getName());
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
}
