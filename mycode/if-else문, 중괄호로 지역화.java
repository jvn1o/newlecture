package ch03.ex03print;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

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
        
            Scanner scan = new Scanner(System.in);
            System.out.print("메뉴 번호 입력:");
            int menu = Integer.parseInt(scan.nextLine());
            System.out.print(menu);


            
            scan.close();
        }
        
        FileInputStream fis = new FileInputStream("res/data.csv"); //data.csv의 파일을 읽어온다
        Scanner scan = new Scanner(fis);
        scan.nextLine();             

        {
            System.out.println("┌─────────────────────────────────────────────┐");
            System.out.println("│                 성적 목록                   │");
            System.out.println("└─────────────────────────────────────────────┘");
            System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");
        }
                                while(scan.hasNextLine()) {     
                                    
                                    int num, kor, eng, math, total;
                                    String name, grade;
                                    double avg;
                                    
                                    String line = scan.nextLine();
                                    String[] tokens = line.split(",");

                                    num = Integer.parseInt(tokens[0]);
                            
                                    name = tokens[1];
                                    
                                    // 문자열 토큰 값을 숫자로 변경
                                    if(!isNumeric(tokens[2]))
                                        kor = -1;   

                                    else    
                                        kor = Integer.parseInt(tokens[2]);  
                                    
                                    if(!( 0<=kor && kor<=100 ))
                                        kor = 0; // if와 else를 교환한 것, 유효성 검사
                                    

                                    // if문이 스페셜한 로직
                                    if(!isNumeric(tokens[3])) 
                                        eng = -1;    
                                                                      
                                    else // else문이 기본 로직
                                        eng = Integer.parseInt(tokens[3]);  

                                    if(!( 0<=eng && eng<=100 ))
                                        eng = 0;
                                        

                                    
                                    if(!isNumeric(tokens[4]))
                                        math = -1;
                                      
                                    else 
                                        math = Integer.parseInt(tokens[4]);

                                    if(!( 0<=math && math<=100 ))
                                        math = 0;

                                     
                                        
                                    total = kor+eng+math;
                                    avg = total/3.0;
                            
                                    //if문으로만 구성되어 덧대어주는 방법                                    
                                    if(90<=avg)
                                    grade = "A";

                                    else if(80<=avg)
                                    grade = "B"; 
                                    
                                    else if(70<=avg)
                                    grade = "C";
                                    
                                    else if(60<=avg)
                                    grade = "D";

                                    else
                                    grade = "F";
                                    
                                                                                
                                    
                            System.out.printf("%d.\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", num,name,kor,eng,math,total,avg,grade);
                         
                                }        
                scan.close();
                fis.close();
            
        }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}