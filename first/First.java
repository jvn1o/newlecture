import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class First {

	public static void main(String[] args) {
		{
			boolean run = true;
			
			while(run) {
				int mainMenu;
				{
					Scanner scan = new Scanner(System.in);
					
					System.out.println("┌─────────────────────────────────────┐");
					System.out.println("│                                     │ ");
					System.out.println("│    집으로 가는 길 Cafe! 메뉴 관리   │ ");
					System.out.println("│                                     │ ");
					System.out.println("└─────────────────────────────────────┘");
					System.out.println();
					System.out.println("\t[1].메뉴목록");
					System.out.println("\t[2].메뉴추가");
					System.out.println("\t[3].종료");
					System.out.print("\t> ");
					mainMenu = scan.nextInt();	
					System.out.println();					
				}
								
				switch(mainMenu) {
				case 1:
					{
						List<Menu> list = new ArrayList<>();;
						{							
							try {
								FileInputStream fis = new FileInputStream("res/menu.csv");
								Scanner scan = new Scanner(fis);
								scan.nextLine();	
												
								while(scan.hasNextLine()) {
									Menu menu = new Menu();
									String line = scan.nextLine();
									String[] tokens = line.split(",");
									
									menu.setId(Integer.parseInt(tokens[0]));
									menu.setKorName(tokens[1]);
									menu.setEngName(tokens[2]);
									menu.setPrice(Integer.parseInt(tokens[3]));
									menu.setLike(Integer.parseInt(tokens[4]));
									menu.setImg(tokens[5]);
									
									list.add(menu);
								}							
								scan.close();
								fis.close();	
							} catch (IOException e) {
								e.printStackTrace();
							}
							finally {			
							}
						}
						int size = list.size();
						System.out.println();
						System.out.println("┌─────────────────────────────────────┐");
						System.out.println("│                                     │ ");
						System.out.println("│             카페 메뉴 목록          │ ");
						System.out.println("│                                     │ ");
						System.out.println("└─────────────────────────────────────┘");
						System.out.println();
						for(int i=0; i<size; i++) {
							Menu menu = list.get(i);
							System.out.printf(
									"[%d] %-40s \t %d 원 \t 좋아요(%d) | %s\n",
									menu.getId(),//menu.id, 
									menu.getKorName() + "(" + menu.getEngName() + ")", 
									menu.getPrice(), 
									menu.getLike(), 
									menu.getImg());
						}

						System.out.println();
						System.out.println("상위메뉴로 가려면 아무키나 누르세요.");
						try {
							System.in.read();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				case 2:
					{
						int nextId = -1;
						{							
							try {
								FileInputStream fis = new FileInputStream("res/menu.csv");
								Scanner scan = new Scanner(fis);
								scan.nextLine();	

								int count = 0;						
								while(scan.hasNextLine()) {										
									scan.nextLine();
									count++;
								}		
		
								nextId = count+1;
					
								scan.close();
								fis.close();	
							} catch (IOException e) {
								e.printStackTrace();
							}
							finally {			
							}
						}				

						Menu menu = new Menu();
						
						Scanner scan = new Scanner(System.in);
						
						System.out.println();
						System.out.println("┌─────────────────────────────────────┐");
						System.out.println("│                                     │ ");
						System.out.println("│             카페 메뉴 입력          │ ");
						System.out.println("│                                     │ ");
						System.out.println("└─────────────────────────────────────┘");
						System.out.println();

						menu.setId(nextId);
						System.out.printf("korName : ");
						menu.setKorName(scan.nextLine());
						System.out.printf("engName : ");
						menu.setEngName(scan.nextLine());
						System.out.printf("price : ");
						menu.setPrice(Integer.parseInt(scan.nextLine()));
						System.out.printf("img : ");
						menu.setImg(scan.nextLine());
						
						try {
							
							FileOutputStream fos = new FileOutputStream("res/menu.csv", true);
							PrintStream fout = new PrintStream(fos);
							
							fout.printf(
								"\n%d,%s,%s,%d,%d,%s",
								menu.getId(),//menu.id, 
								menu.getKorName(), 
								menu.getEngName(), 
								menu.getPrice(), 
								menu.getLike(), 
								menu.getImg());
							
							fout.close();
							fos.close();
						}
						catch(IOException e) {
							
						}
					}
					break;
				case 3:
					run = false;
					break;
				default:
				System.out.println();
				System.out.println("┌─────────────────────────────────────┐");
				System.out.println("│                                     │ ");
				System.out.println("│         앗~! 오류가 발생했어요      │ ");
				System.out.println("│                                     │ ");
				System.out.println("└─────────────────────────────────────┘");
				System.out.println();
				System.out.println("상위메뉴로 가려면 아무키나 누르세요.");
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
	}

}
