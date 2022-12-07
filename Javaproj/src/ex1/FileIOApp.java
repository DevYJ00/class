package ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileIOApp {
	public static void main(String[] args) throws IOException {

		int kor1, kor2, kor3;
		int total;
		double avg;

		// 초기화
		kor1 = 0;
		kor2 = 0;
		kor3 = 0;

		Scanner scan = new Scanner(System.in); // 사용자로부터 입력 받음. Scanner java.lang패키지라 import문 필요없음
		// System.in 은 닫으면 에러날 수 있음 닫지 말기
		while (true) {
			{
				// 콘솔 입력
				// -----------------------------------------------------------------------------------
				System.out.println("프로그램을 시작합니다.");
				System.out.println("┌────────────────────┐");
				System.out.println("│       성적 입력      │");
				System.out.println("└────────────────────┘");

				System.out.println("국어1 : ");
				kor1 = scan.nextInt(); // the int scanned from the input
				System.out.println("국어2 : ");
				kor2 = scan.nextInt();
				System.out.println("국어3 : ");
				kor3 = scan.nextInt();
			}
			// 이제 입력값 받았으니까 밑에 콘솔 출력시 초기화값 위에 덮어씌워지겠지?

			// 콘솔 출력
			// -----------------------------------------------------------------------------------
			{
				total = kor1 + kor2 + kor3; // 연산도 출력에 해당됨
				avg = total / 3.0;

				System.out.println("┌────────────────────┐");
				System.out.println("│       성적 출력      │");
				System.out.println("└────────────────────┘");

				System.out.printf("국어1 : %3d\n", kor1);
				System.out.printf("국어2 : %3d\n", kor2);
				System.out.printf("국어3 : %3d\n", kor3);
				System.out.printf("총점 : %3d\n", total);
				System.out.printf("평균 : %6.2f\n", avg); // 8자리 중 소숫점은 2자리만 표기
				System.out.println("-------------------------------------------");
			}
			// 파일 입력
			// -----------------------------------------------------------------------------------
			// 이제 또, 파일 입력(read)을 받으니까 콘솔 입력받은게 무효되겠지?
			{
				FileInputStream fis = new FileInputStream("res/data2.csv");
				// fis 를 바로 사용하면 바이트단위로 읽게되니까 또 Scanner를 이용
				Scanner readScan = new Scanner(fis);
				String line = readScan.nextLine();
				String[] kors = line.split(",");

				kor1 = Integer.parseInt(kors[0]);
				kor2 = Integer.parseInt(kors[1]);
				kor3 = Integer.parseInt(kors[2]);

				System.out.println("data2 파일 데이터 읽은 값 출력");
				System.out.println("┌────────────────────┐");
				System.out.println("│       성적 출력      │");
				System.out.println("└────────────────────┘");

				System.out.printf("국어1 : %3d\n", kor1);
				System.out.printf("국어2 : %3d\n", kor2);
				System.out.printf("국어3 : %3d\n", kor3);
				System.out.printf("총점 : %3d\n", total);
				System.out.printf("평균 : %6.2f\n", avg);
				System.out.println("---------------------------------------------");
				readScan.close();
				fis.close();
			}
			// 파일 출력(write)
			// -----------------------------------------------------------------------------------
			{
				System.out.println("-------- data2 값이 data.txt 파일에 출력 ------------");
				FileOutputStream fos = new FileOutputStream("res/data.txt");
				// fos 는 바이트단위니까 보조스트림 PrintStream이용
				PrintStream out = new PrintStream(fos);
				out.printf("%d,%d,%d\n", kor1, kor2, kor3);
				System.out.println("작업 완료");

				out.flush(); // 이거 해줘야 하나?
				out.close();
				fos.close();

				System.out.println("계속 하시겠습니까? 1.계속 2.종료");
				int anw = scan.nextInt();
				if (anw == 2)
					break;
			}
		} // end of while
		System.out.println("프로그램 종료");
	}
}
