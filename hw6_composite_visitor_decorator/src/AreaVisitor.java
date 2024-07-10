import java.lang.Math.*;
public class AreaVisitor extends ElementVisitor{

    private int sum=0;

    @Override
    public void visit(Lake lake) {
        sum+=Math.pow(Math.PI,2)* lake.getWidth()/2;
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
