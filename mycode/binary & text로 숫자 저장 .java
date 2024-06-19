package ch03.ex00;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Sample	
{
	public static void main(String[] args) throws IOException
	// {//1번
	// 	int x = 10;
	// 	int y = 20;

	// 	FileOutputStream fos = new FileOutputStream("res/data1.txt");
	// 	fos.write(x);
	// 	fos.write(y);
	// }	
		// {//2번
			
			// int x = 10;
			// int y = 20;
			
			// FileOutputStream fos = new FileOutputStream("res/data2.txt");
			// PrintStream ps = new PrintStream(fos);
			// ps.print(x);
			// ps.print(y);
		// }
			// {//3번
			// int x = 127;
			// int y = 256;
				
			
			// FileOutputStream fos = new FileOutputStream("res/data3.txt");
			// PrintStream ps = new PrintStream(fos);
			// ps.print(x);
			// ps.print(y);
			// }
				{//4번 char 형식으로
				int x = 128;
				int y = 256;
				
				FileOutputStream fos = new FileOutputStream("res/data3.txt");
				// DataOutputStream dos = new DataOutputStream(fos);
				// dos.writeChar(x);
				// dos.writeChar(y);
				fos.write(x);
				fos.write(y);
				System.out.println(x);
				System.out.println(y);

				// FileInputStream fis = new FileInputStream("res/data3.txt");
				// int i = fis.read();
				// System.out.print(i);
				}
}