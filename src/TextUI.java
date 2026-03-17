import java.util.Scanner;

public class TextUI {

    protected Scanner scanner = new Scanner(System.in);

    // kode der indsættes automatisk og usynligt hvis vi ikke selv laver en konstruktør
    public TextUI(){
        super();
    }

    public void sendMessage(String msg){
        printHashTags();
        System.out.println(msg);
        printHashTags();
    }

    public String promptString(String msg){
        printHashTags();
        System.out.println(msg);
        String input = scanner.nextLine();
        printHashTags();
        return input;
    }

    public int promptInt(String msg){
        printHashTags();
        System.out.println(msg);
        int input = scanner.nextInt();
        scanner.nextLine();
        printHashTags();
        return input;
    }

    public Boolean promptBoolean(String msg){
        printHashTags();
        System.out.println(msg);
        Boolean input = scanner.nextBoolean();
        printHashTags();
        return input;
    }

    private void printHashTags(){
        System.out.println("###############");
    }

}