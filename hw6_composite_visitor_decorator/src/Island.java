public class Island extends CompositeElements {
    public Island(String name, double diameter, String path) {
        super(diameter,diameter,path,name);
    }
    @Override
    public void accept(ElementVisitor v) {
        v.visit(this);
            for (Element element: elements)
            {      element.accept(v);   }

    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }
}
