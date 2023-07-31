package programmers.level1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

	public static void main(String[] args) {

		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		Solution solution = new Solution();
		int result = solution.solution(board, moves);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int[][] board, int[] moves) {
			int answer = 0;

			// 스택만들어서 peek과 같은게 들어오면 pop인가 remove인가 해버리기 그리고 카운트
			// board에서 moves에 해당하는 번호인덱스 최상단은 0으로 표시 [i][moves]

			Stack<Integer> stack = new Stack<>();
			for (int m : moves) {
				//System.out.println(stack);
				for (int i = 0; i<board.length; i++) {
					if (board[i][m-1] != 0) {
						if (!stack.isEmpty()) {
							int s = stack.peek();
							if (s == board[i][m-1]) {
								answer+=2;
								stack.pop();
								board[i][m-1] = 0;
								break;

							} else {
								stack.add(board[i][m-1]);
								board[i][m-1] = 0;
								break;

							}
						}
						else {
							stack.add(board[i][m-1]);
							board[i][m-1] = 0;
							break;

						}
						//System.out.print(board[i][m-1]+" ");
					}
				}
			}
			//00000
			//00103
			//02501
			//42442
			//35131
			// 4 3 1 1 3 2 0 4

			return answer;
		}
	}

}
