package ex1.test;

public class OmokTest {

	public static void main(String[] args) {

//		for (int i = 0; i < 10; i++) {
//
//			for (int j = 0; j < 10; j++) {
//				if (i == 2 && j == 2) {
//					System.out.print('○');
//				} else
//					System.out.print('┼');
//			}
//			System.out.println();
//
//		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
