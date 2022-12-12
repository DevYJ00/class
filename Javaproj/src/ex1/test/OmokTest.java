package ex1.test;

public class OmokTest {

	public static void main(String[] args) {

		System.out.printf("%c", '┌');
		for (int i = 1; i <= 10; i++)

			System.out.printf("%c", '┬');

		System.out.printf("%c", '┐');
		System.out.println();

		for (int y = 1; y <= 10; y++) {

			System.out.printf("%c", '├');

			for (int x = 1; x <= 10; x++) {

				if (x == 3 && y == 3)
					System.out.printf("%c", '○');
				else
					System.out.printf("%c", '┼');

			}
			// 오른쪽 테두리
			System.out.printf("%c", '┤');

			System.out.println(); // 끌낼 때

		}
		
		System.out.printf("%c", '└');
		for (int i = 1; i <= 10; i++)

			System.out.printf("%c", '┴');

		System.out.printf("%c", '┘');
	}

}
