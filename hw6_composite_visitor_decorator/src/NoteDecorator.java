public class NoteDecorator extends PaperDecorator{
    public NoteDecorator(Paper paper)
    {
        super(paper);
    }
    @Override
    public String write() {
        return super.write()+" Note";
    }
}
