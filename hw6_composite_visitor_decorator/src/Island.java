
public class Island extends CompositeElements {

    public Island(String name, double diameter, String path) {
        super(name,diameter,path);
    }

    @Override
    public void accept(ElementVisitor v) {
        v.visit(this);
        super.accept(v);
    }

    @Override
    public void addChild(Element child) {
        if(child instanceof Kite || child instanceof Flag || child instanceof Tree || child instanceof Kid || child instanceof Lake)
            this.elements.add(child);
        else
            System.out.println(this.getName() + " cannot contain " + child.getName());
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }
}
