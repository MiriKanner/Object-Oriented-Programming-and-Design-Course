 
public class PaperFactory {
    public static Paper createPaper(String code){
        return switch (code) {
            case "ac" -> new AcademicPaper();
            case "cn" -> new Contract();
            case "jr" -> new JournalArticle();
            case "bk" -> new Book();
            default -> throw new RuntimeException("wrong PaperType");
        };
    }
}