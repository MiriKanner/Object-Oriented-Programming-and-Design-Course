
public class LongPrintVisitor implements ElementVisitor{

    @Override
    public void visit(Boat boat) {
        System.out.print("A boat made of "+ boat.getMaterial() +" material. ");
    }

    @Override
    public void visit(Flag flag) {
        System.out.print("A flag with color: "+flag.getColor() +" of height: "+flag.getCarrierHeight()+". " );
    }

    @Override
    public void visit(Island island) {
        if(island.elements.isEmpty())
            System.out.print("An empty island named "+island.getName()+". ");
        else
            System.out.print("An island named "+island.getName()+" containing: ");
    }

    @Override
    public void visit(Kid kid) {
//        int year = Year.now().getValue() - kid.getBirthYear();
        int year = 2023 - kid.getBirthYear();
        System.out.print("A "+ year +" year old kid with "+kid.getHairColor()+" hair. ");
    }

    @Override
    public void visit(Kite kite) {
        System.out.print("A kite of color: " + kite.getColor()+ ". ");
    }

    @Override
    public void visit(Lake lake) {
        if(lake.elements.isEmpty())
            System.out.print("An empty lake named "+lake.getName()+". ");
        else
            System.out.print("A lake named "+lake.getName()+" containing: ");
    }

    @Override
    public void visit(Tree tree) {
        System.out.print("A tree with an amount of " +tree.getLeavesAmount()+" leaves. ");
    }
}
