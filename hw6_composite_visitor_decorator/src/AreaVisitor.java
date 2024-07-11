import java.lang.Math.*;
public class AreaVisitor implements ElementVisitor{

    private int sum=0;

    @Override
    public void visit(Lake lake) {
        sum+=Math.pow(lake.getWidth()/2,2)*Math.PI ;
    }

    @Override
    public void visit(Kite kite) {
        sum+=(kite.getWidth()* kite.getLength())/2;

    }

    @Override
    public void visit(Boat boat) {
     sum+=(boat.getWidth()*boat.getLength()-Math.pow(boat.getWidth()/2,2)*Math.PI);
    }

    @Override
    public void visit(Flag flag) {
        sum+=(flag.getWidth()*flag.getLength());

    }

    @Override
    public void visit(Tree tree) {
     sum+=tree.getWidth()/2*tree.getLength();
    }

    @Override
    public void visit(Kid kid) {
        sum += kid.getWidth() * (kid.getLength() - kid.getWidth() + Math.pow(kid.getWidth() / 2, 2) * Math.PI);

    }

    @Override
    public void visit(Island island) {
        sum+=(Math.pow(island.getWidth()/2,2)*Math.PI);
    }


}
