package ex1.test;

public class IfTest {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			if (i == 4) {
				System.out.printf("%c", '○');
			} else if (i % 2 != 0) { //수열로도 가능 - How?? 2n-1 을 이용해서 출력하는 방법?
				System.out.printf("%c", '☆');
			} else // 기본출력이 else
				System.out.printf("%c", '┼');

		}

	}
}
