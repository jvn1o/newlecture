package ch03.ex03print;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        
        int num, kor, eng, math;
        String name;

        FileInputStream fis = new FileInputStream("res/data.csv"); //data.csv의 파일을 읽어온다
        Scanner scan = new Scanner(fis);
        scan.nextLine();

                {
                System.out.println("┌─────────────────────────────────────┐");
                System.out.println("│             성적 출력               │");
                System.out.println("└─────────────────────────────────────┘");
                System.out.println("번호\t이름\t국어\t영어\t수학");
                }
                        while(scan.hasNextLine()) {            
                            String line = scan.nextLine();
                            String[] tokens = line.split(",");

                            num = Integer.parseInt(tokens[0]);
                            
                            name = tokens[1];
                                    
                                    if(!isNumeric(tokens[2]))
                                        kor = -1; // kor이 숫자 형태가 아니라면 0을 대입
                                        else {// 조건은 if문에서 검증하고 else문은 형식만 갖춘다. 즉 if와 else는 한몸 
                                            kor = Integer.parseInt(tokens[2]);
                                            if(!( 0<=kor && kor<=100 ))
                                               kor = 0; // kor이 0~100 유효범위가 아니라면 0을 대입
                                        }
                                    
                                    if(!isNumeric(tokens[3]))
                                        eng = -1;
                                        else {
                                            eng = Integer.parseInt(tokens[3]);
                                            if(!( 0<=eng && eng<=100 ))
                                                eng = 0;
                                        }

                                    
                                    if(!isNumeric(tokens[4]))
                                        math = -1;
                                        else {
                                            math = Integer.parseInt(tokens[4]);
                                            if(!( 0<=math && math<=100 ))
                                                math = 0;
                                        }
                                   
                            System.out.printf("%d.\t%s\t%d\t%d\t%d\n", num,name,kor,eng,math);
                        } 
                        
                scan.close();
                fis.close();
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e)
        {
            return false;
        }
    }
}