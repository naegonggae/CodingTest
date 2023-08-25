package codingTest.arraylist;

public class 가위바위보 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72720

	public static void main(String[] args) {
		int n = 5;
		int[] a = {2,3,3,1,3};
		int[] b = {1,1,2,2,3};

		Solution solution = new Solution();
		String result = solution.solution(n, a, b);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(int n, int[] a, int[] b) {
			String answer = "";
			for (int i = 0; i<n; i++) {
				if (a[i] == b[i]) answer+="D";
				else if (a[i]==1 && b[i]==3) answer+="A";
				else if (a[i]==2 && b[i]==1) answer+="A";
				else if (a[i]==3 && b[i]==2) answer+="A";
				else answer+="B";
			}

			return answer;
		}
	}

}
