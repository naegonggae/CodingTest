package programmers.level1;

public class 기사단원의_무기 {

	public static void main(String[] args) {
		int number = 10;
		int limit = 3;
		int power = 2;

		Solution solution = new Solution();
		int result = solution.solution(number, limit, power);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int number, int limit, int power) {
			int answer = 0;

			// 약수의 갯수 = 공격력
			// 응용 : 소수구하기, 약수 구하기
			// 시간복잡도를 줄이기 위한 노력이 필요한 문제

			for (int i = 1; i<=number; i++) {
				//System.out.println(showPower(i));
				if (i == 1) {
					answer++;
				}
				else if (isPrime(i)) { // 소수인지 판별 시간복잡도 O(루트2);
					answer+=2;
				}
				else if (showPower(i) <= limit) { // 소수가 아닌수는 약수가 몇개인지 구한다. 시간복잡도 O(루트2);
					answer+=showPower(i);
				}
				else {
					answer+=power;
				}
			}

			return answer;
		}

		// 약수의 갯수 구하기 제곱근이 n 보다 작은 수만 판별해도 알 수 있다. 약수의 특징
		// (1 100), (2, 50), (4, 25), (5, 20), (10, 10) -> 1, 2, 4, 5, 10 만 보면 약수를 구할 수 있다.
		private int showPower(int n) {
			int sum = 0;
			for (int i = 1; i*i<=n; i++) {
				if (n%i == 0) {
					if (i == n/i) { // 이 경우는 n=4 일때 (2,2) 같은 경우다 / i=작은수=1, n/i=큰수=4
						sum++;
					} else {
						sum+=2;
					}
					//System.out.print(i+" "+n/i+" "+"/");// 같은 약수는 하나만 해줘야함
				}
			}
			return sum;
		}

		// 소수구하기
		private boolean isPrime(int n) {
			for (int i = 2; i*i<=n; i++) { //2부터 판별, 소수는 2부터 시작이기 때문
				if (n%i==0) {
					return false; // 소수는 자신이외에 나누어 떨어지는 수가 없다. 그래서 나누어 떨어지는 순간 시간도 아낄겸 false 로 바로 리턴한다.
				}
			}
			return true;

		}
	}

}
