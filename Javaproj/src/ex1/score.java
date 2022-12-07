package ex1;

public class score {

	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		double avg;

		kor1 = 90;
		kor2 = 80;
		kor3 = 100;
		total = kor1 + kor2 + kor3;
		avg = total / 3;

		System.out.println("┌──────────────────────┐");
		System.out.println("│         \"성적 출력\"     │");
		System.out.println("└──────────────────────┘");

		// decimal 10진수 , printf <- format 에서 유래
		// %f : 고정 소수점으로 표현한 실수 (소수점 이하 6자리까지 표현)
		System.out.printf("국어1 : %3d\n", kor1);
		System.out.printf("국어2 : %3d\n", kor2);
		System.out.printf("국어3 : %3d\n", kor3);
		System.out.printf("총점 : %d\n", total);
		System.out.printf("평균 : %6.2f\n", avg); //12자리를 표현하는데 소숫점은 2자리만 표현
		System.out.println("────────────────────────");
		
		
	}

}
