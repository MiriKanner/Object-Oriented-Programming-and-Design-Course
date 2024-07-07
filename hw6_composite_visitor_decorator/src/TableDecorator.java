public class TableDecorator extends PaperDecorator{
    public TableDecorator(Paper paper) {
        super(paper);
    }
    @Override
    public String write() {
        return super.write() + " Table";
    }
}
