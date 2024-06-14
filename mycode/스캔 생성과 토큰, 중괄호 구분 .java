package ch03.ex01string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner; // 패키지명

public class App {
    public static void main(String[] args) throws IOException {

    FileInputStream fis = new FileInputStream("res/data.csv");
    Scanner scan = new Scanner(fis);

    scan.nextLine(); //"이름,국어,영어,수학"
    
        {
            String line = scan.nextLine(); //"강호동,90,80,30"
            // "강호동,90,80,30" -> ["강호동" "90" "80" "30"]    
            String[] tokens = line.split(",");
            // 문자열 -> 정수
            String name = tokens[0]; // "강호동"
            // 정수 -> 문자열
            int kor = Integer.parseInt(tokens[1]);
            int eng = Integer.parseInt(tokens[2]);
            int math = Integer.parseInt(tokens[3]);
        
            System.out.println(line);
            System.out.printf(
                "name: %s, kor: %d, eng: %d, math: %d",name,kor,eng,math);
                System.out.println();
        }

                {
                    String line = scan.nextLine();
                    String[] tokens = line.split(",");
                    String name = tokens[0];
                    int kor = Integer.parseInt(tokens[1]);
                    int eng = Integer.parseInt(tokens[2]);
                    int math = Integer.parseInt(tokens[3]);
                
                    System.out.println(line);
                    System.out.printf(
                        "name: %s, kor: %d, eng: %d, math: %d",name,kor,eng,math);
                        System.out.println();
                }

                        {
                            String line = scan.nextLine();
                            String[] tokens = line.split(",");
                            String name = tokens[0];
                            int kor = Integer.parseInt(tokens[1]);
                            int eng = Integer.parseInt(tokens[2]);
                            int math = Integer.parseInt(tokens[3]);
                        
                            System.out.println(line);
                            System.out.printf(
                                "name: %s, kor: %d, eng: %d, math: %d",name,kor,eng,math);
                        }
                scan.close();
                fis.close();

    }
}

 