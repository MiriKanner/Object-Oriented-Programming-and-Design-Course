public class PrintNameVisitor implements  ElementVisitor{
    @Override
    public void visit(Lake lake) {
        System.out.println(lake.getName());
        for (Element element : lake.elements) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Kite kite) {

    }

    @Override
    public void visit(Boat boat) {

    }

    @Override
    public void visit(Flag flag) {

    }

    @Override
    public void visit(Tree tree) {

    }

    @Override
    public void visit(Kid kid) {

    }

    @Override
    public void visit(Island island) {

    }
}
