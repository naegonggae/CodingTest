package programmers.level1;

public class 문제2016년 {

	public static void main(String[] args) {

		int a = 5;
		int b = 24;

		Solution solution = new Solution();
		String result = solution.solution(a, b);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(int a, int b) {
			String answer = "";

			int day = allDay(a, b);
			if (day % 7 == 1) {
				answer = "FRI";
			} else if (day % 7 == 2) {
				answer = "SAT";
			} else if (day % 7 == 3) {
				answer = "SUN";
			} else if (day % 7 == 4) {
				answer = "MON";
			} else if (day % 7 == 5) {
				answer = "TUE";
			} else if (day % 7 == 6) {
				answer = "WED";
			} else if (day % 7 == 0) {
				answer = "THU";
			}

			return answer;
		}

		private int allDay(int a, int b) {
			if (a == 1) {
				return b;
			}
			else if (a == 2) {
				return 31 + b;
			}
			else if (a == 3) {
				return 31 + 29 + b;
			}
			else if (a == 4) {
				return 31 + 29 + 31 + b;
			}
			else if (a == 5) {
				return 31 + 29 + 31 + 30 + b;
			}
			else if (a == 6) {
				return 31 + 29 + 31 + 30 + 31 + b;
			}
			else if (a == 7) {
				return 31 + 29 + 31 + 30 + 31 + 30 + b;
			}
			else if (a == 8) {
				return 31 + 29 + 31 + 30 + 31 + 30 + 31 + b;
			}
			else if (a == 9) {
				return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + b;
			}
			else if (a == 10) {
				return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + b;
			}
			else if (a == 11) {
				return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + b;
			}
			else if (a == 12) {
				return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + b;
			}
			return 0;

		}
	}

}
