package ch03.ex03print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in, "MS949");

        while_: while (true) {
            int menu;
            clear();
            {
                String menu_view = """

                        ┌───────────────────────────────┐
                        │            성적관리           │
                        └───────────────────────────────┘

                        1. 목록보기
                        2. 성적추가
                        3. 성적로드
                        4. 성적저장
                        5. 종료
                        """;

                System.out.print(menu_view);

                System.out.print("메뉴 번호 입력:");
                menu = Integer.parseInt(scan.nextLine());
            }
            switch (menu) {
                case 2: // 성적추가

                while(true)
                { 
                    clear();
                    {
                        System.out.println("성적 추가 메뉴");
                        System.out.println("───────────────────────────────");
                        System.out.print("성적 입력:");

                        String num, kor, eng, math, name;
                        // int num, kor, eng, math;

                        num = scan.nextLine();
                        name = scan.nextLine(); 
                        kor = scan.nextLine();
                        eng = scan.nextLine();
                        math = scan.nextLine();

                        // ******** do{ if() }while(); 써보기

                        FileOutputStream fos = new FileOutputStream("res/data.csv", true);
                        PrintStream ps = new PrintStream(fos);
                        ps.printf("\n%s,%s,%s,%s,%s", num, name, kor, eng, math);                        
                        }
                        System.out.println("종료하시겠습니까? 종료(quit):");
                        String ques = scan.nextLine();

                        if(ques.equals("quit"))
                            break;                            
                }   
                    break;    
                    // continue; // 반복문에서 밑을 생략하도록 해주는, 즉 반복문의 맨 처음으로 돌아간다
                    // break; // 자기 근처 반복문을 벗어나는 명령어

                case 3: // 성적로드

                    clear();

                {
                    System.out.println("성적 로드 메뉴");

                    System.out.println();
                    System.out.println("───────────────────────────────");
                    System.out.println("Press and key to continue");

                    scan.nextLine();
                }
                    break;

                case 4: // 성적저장

                    clear();

                {
                    System.out.println("성적 저장 메뉴");

                    System.out.println();
                    System.out.println("───────────────────────────────");
                    System.out.println("Press and key to continue");

                    scan.nextLine();
                }
                    break;

                case 5: // 종료

                    clear();

                {
                    System.out.println("종료");
                    // System.exit(0);
                }
                    break while_;

                case 1: // 목록

                    clear();

                {
                    FileInputStream fis = new FileInputStream("res/data.csv");
                    scan.nextLine();

                    int page = 1;

                    System.out.printf("%d page\n", page);
                    System.out.println("┌─────────────────────────────────────────────┐");
                    System.out.println("│ 성적 출력                                   │");
                    System.out.println("└─────────────────────────────────────────────┘");
                    System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");

                    // int i=0; // while() 반복시에 int를 바깥에 두는 이유 = 안에 넣으면 반복마다 i가 0이 됨
                    

                    for (int i = 0; scan.hasNextLine() && i < 6; i++) {

                        int num, kor, eng, math, total;
                        String name, grade;
                        double avg;

                        String line = scan.nextLine();
                        String[] tokens = line.split(",");

                        num = Integer.parseInt(tokens[0]);

                        name = tokens[1];

                        // 문자열 토큰 값을 숫자로 변경
                        if (!isNumeric(tokens[2]))
                            kor = -1;

                        else
                            kor = Integer.parseInt(tokens[2]);

                        if (!(0 <= kor && kor <= 100))
                            kor = 0; // if와 else를 교환한 것, 유효성 검사

                        // if문이 스페셜한 로직
                        if (!isNumeric(tokens[3]))
                            eng = -1;

                        else // else문이 기본 로직
                            eng = Integer.parseInt(tokens[3]);

                        if (!(0 <= eng && eng <= 100))
                            eng = 0;

                        if (!isNumeric(tokens[4]))
                            math = -1;

                        else
                            math = Integer.parseInt(tokens[4]);

                        if (!(0 <= math && math <= 100))
                            math = 0;

                        total = kor + eng + math;
                        avg = total / 3.0;

                        // if문으로만 구성되어 덧대어주는 방법
                        if (90 <= avg)
                            grade = "A";

                        else if (80 <= avg)
                            grade = "B";

                        else if (70 <= avg)
                            grade = "C";

                        else if (60 <= avg)
                            grade = "D";

                        else
                            grade = "F";

                        System.out.printf("%d.\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", num, name, kor, eng, math, total, avg,
                                grade);
                                
                                fis.close();
                            }
                        }
                        
                        default: {
                            {
                                System.out.print("오류: 범위를 벗어났습니다. 1~5번을 입력해주세요.\n");
                                System.out.print("메뉴 번호 입력:");
                                System.out.println();
                                System.out.println("───────────────────────────────");
                                System.out.println("Press and key to continue");
                                
                                scan.nextLine();
                            }
                            scan.close();
                            
                }
            }

            // System.out.println();
            // System.out.println("───────────────────────────────");
            // System.out.println("Press and key to continue");

            // scan.nextLine();
        }

    }

    public static void clear() {
        try {
            String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
