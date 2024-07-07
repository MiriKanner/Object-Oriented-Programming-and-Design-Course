public class DiagramDecorator extends PaperDecorator  {
    public DiagramDecorator(Paper paper) {
        super(paper);
    }
    @Override
    public String write() {
        return super.write()+" Diagram";
    }
}
