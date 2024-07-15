import static java.lang.Math.*;
public class AreaVisitor implements ElementVisitor{
    private double totalArea=0;
    @Override
    public void visit(Boat boat) {
        totalArea+= ((boat.getLength() - boat.getWidth()/2) * boat.getWidth()) + ((boat.getWidth()/2)*(boat.getWidth()/2)* Math.PI)/2;
    }

    @Override
    public void visit(Flag flag) {
        totalArea+=flag.getLength() * flag.getWidth();
    }

    @Override
    public void visit(Island island) {
        totalArea += (island.getWidth() / 2) * (island.getWidth() / 2) * Math.PI;
    }

    @Override
    public void visit(Kid kid) {
        totalArea += ((kid.getLength() - kid.getWidth()) * kid.getWidth()) + (kid.getWidth() / 2) * (kid.getWidth() / 2) * Math.PI;
    }

    @Override
    public void visit(Kite kite) {
        totalArea+= kite.getLength() * kite.getWidth()/2;
    }

    @Override
    public void visit(Lake lake) {
        totalArea += (lake.getWidth() / 2) * (lake.getWidth() / 2) * Math.PI;
    }

    @Override
    public void visit(Tree tree) {
        totalArea+= (tree.getLength() * tree.getWidth())/2;
    }

    public int getArea() {
        return (int)round(totalArea);
    }
}
