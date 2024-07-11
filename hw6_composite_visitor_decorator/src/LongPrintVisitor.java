public class LongPrintVisitor implements ElementVisitor{


    @Override
    public void visit(Lake lake) {
        if(lake.elements.isEmpty())
            System.out.println("An empty island named "+lake.getName()+". ");
        else
            System.out.println("  A lake named "+lake.getName() +" containing: ");

    }

    @Override
    public void visit(Kite kite) {
        System.out.println("A kite of color: "+kite.getColor() +". ");
    }

    @Override
    public void visit(Boat boat) {
        System.out.println("A boat made of timber "+boat.getMaterial() +" material. ");

    }

    @Override
    public void visit(Flag flag) {
        System.out.println("A flag with carrier height "+ flag.getCarrierHeight()+" and color: "+flag.getColor()+". " );

    }

    @Override
    public void visit(Tree tree) {
                System.out.println(" A tree with an amount of A "+ tree.getLeavesAmount()+" leaves." );
    }

    @Override
    public void visit(Kid kid) {
        System.out.println("A "+ kid.getBirthYear()+"year old kid with "+kid.getHairColor()+"hair." );
    }

    @Override
    public void visit(Island island) {
        if(island.elements.isEmpty())
            System.out.println("An empty island named "+island.getName()+". ");
        else
            System.out.println("An island named "+island.getName()+" containing: ");

    }
}
