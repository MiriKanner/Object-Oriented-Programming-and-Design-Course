public class

PrintNameVisitor implements  ElementVisitor{

    @Override
    public void visit(Lake lake) {
        System.out.println(lake.getPath());
    }

    @Override
    public void visit(Kite kite) {
        System.out.println(kite.getPath());
    }

    @Override
    public void visit(Boat boat) {
        System.out.println(boat.getPath());
    }

    @Override
    public void visit(Flag flag) {
        System.out.println(flag.getPath());
    }

    @Override
    public void visit(Tree tree) {
        System.out.println(tree.getPath());
    }

    @Override
    public void visit(Kid kid) {
        System.out.println(kid.getPath());
    }

    @Override
    public void visit(Island island) {
        System.out.println(island.getPath());
    }
}
