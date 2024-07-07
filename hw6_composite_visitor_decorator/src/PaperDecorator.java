public class PaperDecorator implements Paper{
    private Paper myPaper;
    PaperDecorator(Paper paper)
    {
        myPaper=paper;
    }
    @Override
    public String write() {
        return myPaper.write();
    }
}