package programmers.level1;

public class 햄버거_만들기 {

	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

		Solution solution = new Solution();
		int result = solution.solution(ingredient);
		System.out.println("result = " + result);

		Solution2 solution2 = new Solution2();
		int result2 = solution2.solution(ingredient);
		System.out.println("result = " + result2);
	}

	static class Solution {
		public int solution(int[] ingredient) {
			// 인덱스로 활용할 배열 선언
			int[] stack = new int[ingredient.length];
			int answer = 0;
			int idx = 0;

			// 배열에 반복문 한번만 타면서 저장
			for (int i : ingredient) {
				//System.out.println(idx);
				stack[idx++] = i; // stack[0] 으로 저장하고 idx 는 1되고 / 실제 저장할때 idx == 변수 idx + 1
				//System.out.println(idx);
				//2 1 1 2 3 1
				//0,1,2,3,4,5
				//idx=6
				if (idx>=4 && stack[idx-1] == 1 // 5
						&& stack[idx-2] == 3 // 4
						&& stack[idx-3] == 2 // 3
						&& stack[idx-4] == 1) { // 2
					answer++;
					idx -= 4;
					// 인덱스를 조절해서 마치 삭제한거처럼 쓰고 있다.
					// 순서대로 햄버거가 만들어지는 것이 가능하다. // 문자열에서는 전부 replace 해서 바꾸니까 순서대로 반영이 잘안됐던 문제를 잘 해결함
					// 자꾸 "1231"을 "" 으로 바꾸려는 시도를 했는데 인덱스를 조절해서 덮어 씌우는 방법으로 해결했다.
				}
			}

			return answer;
		}
	}

	static class Solution2 {

		public int solution(int[] ingredient) {
			int answer = 0;

			StringBuilder sb = new StringBuilder();
			for (int i : ingredient) {
				sb.append(i); // 문자열로 저장됨
				int idx = sb.indexOf("1231");
				while (idx != -1) {
					answer++;
					// 여기서도 replace 로 "" 바꿀생각만하고 지울생각은 못함
					sb.delete(idx, idx+4);
					// 지우고 나서 새로운 변수 대입
					idx = sb.indexOf("1231");
				}
			}
			return answer;
		}
	}

}
