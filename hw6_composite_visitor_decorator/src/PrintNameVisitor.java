public class

PrintNameVisitor implements  ElementVisitor{

    @Override
    public void visit(Lake lake) {
        System.out.println(lake.getName());
    }

    @Override
    public void visit(Kite kite) {
        System.out.println(kite.getName());
    }

    @Override
    public void visit(Boat boat) {
        System.out.println(boat.getName());
    }

    @Override
    public void visit(Flag flag) {
        System.out.println(flag.getName());
    }

    @Override
    public void visit(Tree tree) {
        System.out.println(tree.getName());
    }

    @Override
    public void visit(Kid kid) {
        System.out.println(kid.getName());
    }

    @Override
    public void visit(Island island) {
        System.out.println(island.getName());
    }
}
