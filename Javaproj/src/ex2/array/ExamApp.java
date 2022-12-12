package ex2.array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExamApp {
	public static void main(String[] args) throws IOException {

		int[] kors = new int[3];
		int total;
		double avg;
		int anw;
		int menu;

		// 초기화
//		total = kor1 + kor2 + kor3;

		avg = 0;
		anw = 1;
		menu = 0;

		Scanner scan = new Scanner(System.in); // 사용자로부터 입력 받음. Scanner java.lang패키지라 import문 필요없음
		// System.in 은 닫으면 에러날 수 있음 닫지 말기
		// 메뉴

		// 1. 계속 2. 종료
		NEWLECT: while (anw == 1) {
			System.out.println("---------------------------------------------");

			System.out.println("프로그램을 시작합니다.");
			System.out.println("┌────────────────────┐");
			System.out.println("│       메인 메뉴      │");
			System.out.println("└────────────────────┘");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력 ");
			System.out.println("3. 파일 읽어오기");
			System.out.println("4. 파일 출력");
			System.out.println("5. 종   료");
			System.out.print(">");
			menu = scan.nextInt();

			switch (menu) {
			case 1: {
				// 콘솔 입력
				// -----------------------------------------------------------------------------------
				System.out.println("┌────────────────────┐");
				System.out.println("│       성적 입력      │");
				System.out.println("└────────────────────┘");

				// 0<kor1<100 벗어나면 재입력을 받고 싶다면?

				// do-while 문, do문 먼저 수행 후 while문 조건 체크
				for (int i = 0; i < kors.length; i++) {
					int kor;

					do {
						System.out.printf("국어 %d : ", i + 1);
						kor = scan.nextInt(); // the int scanned from the input

						if ((kor < 0 || kor > 100))
							System.out.println("0~100까지만 입력할 수 있습니다.");

					} while ((kor < 0 || kor > 100));

					kors[i] = kor;
				}

			}
				break;

			case 2: {
				// 콘솔 출력
				// -----------------------------------------------------------------------------------
//				total = kor1 + kor2 + kor3;

				System.out.println("┌────────────────────┐");
				System.out.println("│       성적 출력      │");
				System.out.println("└────────────────────┘");
				for (int i = 0; i < 3; i++) {
					{
						total = 0; // 초기화

						// total 구하기
						for (int j = 0; j < kors.length; j++) {
							total += kors[j];
						}

						avg = total / 3.0;

						System.out.printf("---------<%d>-------------\n", 3 - i);
						for (int j = 0; j < kors.length; j++) {
//							
							System.out.printf("국어%d : %3d\n", j, kors[j]);
						}

						System.out.printf("총점 : %3d\n", total);
						System.out.printf("평균 : %6.2f\n", avg); // 8자리 중 소숫점은 2자리만 표기
					}
				}
			}
				break;

			case 3: {
				// 파일 입력
				// -----------------------------------------------------------------------------------
				// 이제 또, 파일 입력(read)을 받으니까 콘솔 입력받은게 무효되겠지?
				FileInputStream fis = new FileInputStream("res/data2.csv");
				// fis 를 바로 사용하면 바이트단위로 읽게되니까 또 Scanner를 이용
				Scanner readScan = new Scanner(fis);
				String line = readScan.nextLine();
				String[] tokens = line.split(","); // 임시로 사용하는 지역변수니까 이름을 tokens로

				for (int i = 0; i < kors.length; i++) {
					kors[i] = Integer.parseInt(tokens[i]);

				}

				readScan.close();
				fis.close();

			}
				break;

			case 4: {
				// 파일 출력(write)
				// -----------------------------------------------------------------------------------
				System.out.println("-------- data2 값이 data.txt 파일에 출력 ------------");
				FileOutputStream fos = new FileOutputStream("res/data.txt");
				// fos 는 바이트단위니까 보조스트림 PrintStream이용
				PrintStream out = new PrintStream(fos);
//				
				// 0 1 2
				// 길이는 3
				for (int i = 0; i < kors.length; i++) {
					out.printf("%d", kors[i]);
					
				
					if (i == kors.length - 1)
						out.print("\n");
					else
						out.print(',');
				}
				System.out.println("작업 완료");

				out.flush(); // 이거 해줘야 하나?
				out.close();
				fos.close();

			}
				break;

			case 5: {

				System.out.println("프로그램 종료");
				System.out.println("-------------------------------");
				anw = 2;

			}
			default: {
				System.out.println("1~5 사이의 메뉴를 입력하세요.");
			}
				break NEWLECT; // 변수랑 혼동되니까 대문자로 표기

			}

		}
	}
}
