package programmers;

public class 조건_문자열 {

	public int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		if (ineq.equals(">") && eq.equals("=") && n >= m) {
			return 1;
		}
		else if (ineq.equals("<") && eq.equals("=") && n<=m) {

			return 1;
		}
		else if (ineq.equals(">") && eq.equals("!") && n > m) {
			return 1;
		}
		else if (ineq.equals("<") && eq.equals("!") && n < m) {
			return 1;
		}
		return answer;

	}
}
