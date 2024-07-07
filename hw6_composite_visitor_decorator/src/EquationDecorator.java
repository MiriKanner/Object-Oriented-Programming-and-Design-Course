public class EquationDecorator extends PaperDecorator{
   public EquationDecorator(Paper paper) {
       super(paper);
   }
   @Override
   public String write() {
       return super.write()+" Equation";
   }
}
