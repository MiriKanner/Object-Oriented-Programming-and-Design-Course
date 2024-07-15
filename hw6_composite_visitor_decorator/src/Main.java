
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose from the following options:
                a: Art
                p: Papers""");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }
    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();

        Files.lines(Paths.get(path))
                .map(str -> ElementDetailsFactory.getPaintingElement(str))
                .forEach(painting::addElement);
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path=scanner.nextLine();
        Painting root= readElementDetails(path);
        System.out.println("""
                Choose from the following options:
                q: quit
                c: count elements
                lp: long print
                sh: short print
                ta: total area""");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    CountVisitor elementsCountVisitor=new CountVisitor();
                    root.elementList.forEach(e->e.accept(elementsCountVisitor));
                    System.out.println(elementsCountVisitor.getCount());
                    break;
                case "sh":
                    root.elementList.forEach(e->e.accept(new PrintNameVisitor()));
                    break;
                case "ta":
                    AreaVisitor totalAreaVisitor=new AreaVisitor();
                    root.elementList.forEach(e->e.accept(totalAreaVisitor));
                    System.out.println(totalAreaVisitor.getArea());
                    break;
                case "lp":
                    root.elementList.forEach(e->e.accept(new LongPrintVisitor()));
                    break;
            }
        }
    }

    public static void paperMenu(Scanner scanner){
        System.out.println("Choose from the following paper:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "jr: journal article\n" +
                "bk: book");
        Paper paper = PaperFactory.createPaper(scanner.nextLine());
        String choice="";
        while (!choice.equals("s")) {
            System.out.println("""
                    Choose from the following options:
                    a: add element
                    s: submit""");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());
            }
        }

    }
    public static Paper paperElementMenu(Scanner scanner, Paper paper){
        System.out.println("""
                Choose from the following elements:
                tb: table
                eq: equation
                d: diagram
                nt: note""");
        return DecoratorFactory.createDecoratorPaper(scanner.nextLine(), paper);
    }
}
