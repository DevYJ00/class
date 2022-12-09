package ex1.test;

public class ForTest {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {

//			if (i == 2) 
//				continue;
			
//			if (i == 3)
//				break;
			
			if( i < 2)
				continue;
			
				System.out.print("☆");
				System.out.printf("%d", i + 1);

				if (i != 4) // if(마지막이 아닐 때)
					System.out.print(",");
				
		
		}
	}

}
