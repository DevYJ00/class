package ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		
//		ConsoleOutputStream out =  new ConsoleOutputStream();  //Stream객체를 얻고
		
		int kor1, kor2, kor3;
		int total;
		double avg;
		
		kor1 = 90;
		kor2 = 80;
		kor3 = 80;
		
		total = kor1 + kor2 + kor3;
		avg = total/3.0; //83.33333333333333
		
		System.out.print(total);
		System.out.print(avg);
		
		
		//콘솔 출력 스트림 
		//System.out : 이게 ConsoleOutputStream인 셈이지( FileOutputStream 에 비유하면)
		System.out.write('A');
		System.out.write('b');
		System.out.flush(); // 버퍼 비우기 - 이거 빼먹으니까 콘솔창에 출력안됨
		
		
		
		
		System.out.println("hello");
		
		
		
		 FileOutputStream fos =  new FileOutputStream("res/data2.txt");  //Stream객체를 얻고
		
		 PrintStream out = new PrintStream(fos); //out은 fos를 응용하는 객체
		 
		 out.print("Hello File");
		 
		//FileOutputStream 은  byte단위로 읽어서 "" 사용 불가
		fos.write('A');
		fos.write('C');
		fos.write(3); // 숫자는 못읽네??
		
		
		fos.flush(); //버퍼 비우기. 버퍼가 꽉 차지 않아도 내보내는 것
		fos.close(); 
		
		
		System.out.println("실행 종료"); 
		 
		 
		
		
	}

}
