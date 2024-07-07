public class DecoratorFactory {
    public static Paper createDecoratorPaper(String code,Paper paper){
        switch (code) {
            case "tb" :
                return new TableDecorator(paper);
            case "eq" :
                return new EquationDecorator(paper);
            case "d":
                return new DiagramDecorator(paper);
            case "nt" :
                return  new NoteDecorator(paper);
            default : throw new RuntimeException("wrong ExtrasType");
        }
    }
}
