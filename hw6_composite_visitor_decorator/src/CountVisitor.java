public class CountVisitor implements ElementVisitor{
    private int count=0;
    @Override
    public void visit(Boat boat) {
        count+=1;
    }

    @Override
    public void visit(Flag flag) {
        count+=1;
    }

    @Override
    public void visit(Island island) {
        count+=1;
    }

    @Override
    public void visit(Kid kid) {
        count+=1;
    }

    @Override
    public void visit(Kite kite) {
        count+=1;
    }

    @Override
    public void visit(Lake lake) {
        count+=1;
    }

    @Override
    public void visit(Tree tree) {
        count+=1;
    }

    public int getCount() {
        return count;
    }
}
