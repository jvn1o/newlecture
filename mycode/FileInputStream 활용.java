import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        //1번. binary 형태로 출력
        {
            FileInputStream f = new FileInputStream("res/data2.txt");
            int b = f.read();
            System.out.println(b);
            f.close();
        }

        //2번. 스캔하여 공백 이전까지 출력
        {
            FileInputStream f = new FileInputStream("res/data2.txt");
            Scanner scan = new Scanner(f);
            String w = scan.next();
            System.out.println(w);
            f.close();
        }

        //3번. 한 줄을 공백까지 포함하여 출력
        {
            FileInputStream f = new FileInputStream("res/data2.txt");
            Scanner scan = new Scanner(f);
            String l = scan.nextLine();       
            System.out.println(l);
            f.close();
        }

    }
}
