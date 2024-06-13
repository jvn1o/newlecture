package ch02.ex01print;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    public static void main(String[] args) throws IOException {

        // // ConsoleOutputStream cos = new ConsoleOutputStream(); 콘솔은 필수요소이므로 런타임 환경이 자동 지원한다. 고로 생성하지 않음
        // // PrintStream out = new PrintStream(System.out); 이렇게 사용하기보다는
        // System.out.println("Hello"); // 이렇게 사용한다.
        // // Run할 때 나타나는 결과



        // //fos 이름의 FileOutputStream 객체 생성
        // FileOutputStream fos = new FileOutputStream("res/data.txt"); // 경로 설정은 '\\' or '/'로 가능하다.
        
        // //fout 이름의 PrintStream 객체 생성
        // PrintStream fout = new PrintStream(fos);
        // fout.println("Hello HaHa");

        // fout.close();
        // fos.close();
        // // data.txt에 저장되는 내용

        // System.out.write(65); // 아스키코드 출력함수
        // System.out.print(50); // 숫자 그대로 출력함수
        // System.out.println("99.15"); // 문자열 출력하고 다음 줄 내림
        // System.out.println("ab\bcd\tfg\nhi\\\""); // 이스케이프 문자 활용 \b: 백스페이스, \t: 탭, \n: 다음 줄, \\: \출력, \": "출력
        

        int 국어;
        int 수학;
        int 영어;
        int 총점;
        double 평균;

        국어 = 50;
        수학 = 15;
        영어 = 80;
        총점 = 국어 + 수학 + 영어;
        평균 = 총점/3.0;

        // System.out.printf("수학1 : %d\n", 국어1); // print format 함수, 내가 형식을 지정하며 출력할 수 있다. %d: 정수, %f: 실수, %x: 16진법, %o: 8진법 - 기본형을 지정하고 작성해야함
        
        FileOutputStream fos = new FileOutputStream("res/data.txt");
        PrintStream fout = new PrintStream(fos);
        
        fout.printf("[시험 성적]\n");
        fout.printf("국어: %d 점",국어);
        fout.printf("\n수학: %d 점",수학);
        fout.printf("\n영어: %d 점",영어);
        // 이때 총점과 평균은 성적에 따라 계속 변화하기에 디스크에 넣지는 않는다. 복잡해지기 때문
        
        fout.close(); // 안쪽에서부터 close해주어야 사용중인게 닫히지 않는다.
        fos.close();
        
        System.out.print("┌─────────────┐\n");
        System.out.print("│  성적 출력  │\n");
        System.out.print("└─────────────┘\n");
        System.out.printf(" 국어: %-3d 점",국어);
        System.out.printf("\n 수학: %-3d 점",수학);
        System.out.printf("\n 영어: %-3d 점",영어);
        System.out.printf("\n\n 총점: %-4d 점",총점);
        System.out.printf("\n 평균: %.2f점",평균);
    }
}

