package practice;

public class Test {

	public static void main(String[] args) {

		int[] esya= {1, 2, 3, 4, 5, 6, 7, 8};
		int[] weight= {3, 4, 1, 6, 5, 8, 3, 8};
		int capacity=10;
		int item1=esya[0];
		int item2=esya[1];
		
		for(int i=0; i<weight.length-1; i++) {
			for(int j=i+1; j<weight.length; j++) {
				if(weight[i]+weight[j]==capacity) {
					item1=esya[i];
					item2=esya[j];
					break;
				}
			}
		}
		
		System.out.println("Item1 : " + item1);
		System.out.println("Item2 : " + item2);
	}
}
