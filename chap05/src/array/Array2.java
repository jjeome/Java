package array;

public class Array2 {

	public static void main(String[] args) {
		/*
		//일차원배열
		int [] arr = new int[2];

		//3개의 배열이 2줄로
		//int[2]총 3개 존재하는 2차원배열 -> 3열 2행 [3][2]
		int [][] arr2 = new int[3][2];
		
		
		//일차원배열
		for(int i=0; i< arr.length; i++) {
			System.out.println("arr["+i+"] : " + arr[i]);
		}
		
		
		//이차원배열
		for(int i=0; i<arr2.length;i++) {
			int[] tempAry = arr2[i];
			for(int j=0; j<tempAry.length; j++) {
				System.out.println("tempAry["+j+"] : "+tempAry[j]);
			}
		}
		
		//위(2차원배열)와 동일
		for(int i = 0; i<arr2.length; i++) {
			for(int j =0; j<arr2[i].length; j++) {
				System.out.println("arr2["+j+"]:"+arr2[i][j]);
			}
		}
		
		
		//크기만 지정하고 2차원배열이 가지는 1차원배열들의 크기 각각 다르게 초기화시킴
		System.out.println();
		int[][] arr3 = new int[2][];
		arr3[0] = new int[3];//3개 0 1 2
		arr3[1] = new int[5];//5개 0 1 2 3 4
		
		for(int i=0; i<arr3.length;i++) {
			for(int j = 0; j<arr3[i].length;j++) {
				System.out.println("arr3["+i+"]["+j+"]:"+arr3[i][j]);
			}
		}
		
		*/
		System.out.println();
		int[][] javaScores = { {95,80} , {92,96,80} };
		for(int i=0; i<javaScores.length; i++) {
			for(int j=0; j<javaScores[i].length; j++) {
				System.out.println(javaScores[i][j]);
			}
		}
		
		//향상된 for문
		/*tempAry에 javaScores의 모든 값이 저장
		javaScores[0]번째 95, 80이 먼저 tempAry에 저장
		그다음 temp에도 95, 80이 저장
		다음 javaScores[1]번째에 92,96,80이 tempAry에 저장
		그다음 temp에도 92, 96, 80이 저장
		*/
		System.out.println();
		for(int[] tempAry : javaScores) {
			for(int temp : tempAry) {
				System.out.println(temp);
			}
		}
		
		
	}

}
