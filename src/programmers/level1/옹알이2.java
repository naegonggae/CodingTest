package programmers.level1;

public class 옹알이2 {

	public static void main(String[] args) {
		String[] babblings = {"ayaayaaya"};

		Solution solution = new Solution();
		int result = solution.solution(babblings);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(String[] babbling) {
			int answer = 0;
			// 연속된 발음은 안됨, 멀리 떨어져있는건 괜찮다는말
			// indexOf 로 연속되어있는지 파악, 아니면 공백으로 변환
			// 최후에 빈칸이면 발음할수있는 단어로 치고 카운티 올림

			// 그냥 1, 2, 3, 4로 다 변환하고, 이외의 문자 있으면 탈락, 연속으로 문자 있으면 탈락
			String a = "aya";
			String b = "ye";
			String c = "woo";
			String d = "ma";

			for (int i = 0; i<babbling.length; i++) {
				babbling[i] = babbling[i].replace(a, "1");
				babbling[i] = babbling[i].replace(b, "2");
				babbling[i] = babbling[i].replace(c, "3");
				babbling[i] = babbling[i].replace(d, "4");
				//System.out.println("전체문자 "+babbling[i]);
			}

			for (int i = 0; i<babbling.length; i++) {
				if (babbling[i].length() == 1) {
					// 문자열의 길이가 1이므로 중복체크를 할 필요없이 바로 빈문자열 체크 들어간다.
					babbling[i] = babbling[i].replace("1", "");
					babbling[i] = babbling[i].replace("2", "");
					babbling[i] = babbling[i].replace("3", "");
					babbling[i] = babbling[i].replace("4", "");

					if (babbling[i].equals("")) {
						//System.out.println("카운트할게 " + babbling[i] + "--");
						answer++;
					}
				} else {
					// 문자가 연속되는지 체크
					for (int j = 0; j<babbling[i].length()-1; j++) {
						// 문자가 하나짜리는 인식을 못하네//

						//System.out.println("i번째문자"+babbling[i]);
						String n = String.valueOf(babbling[i].charAt(j));
						//System.out.println("첫번째 = "+ n);
						String m = String.valueOf(babbling[i].charAt(j+1));
						//System.out.println("두번째 = "+m);

						if (n.equals(m)) {
							// 연속된 문자가 나오면 "aaa"로 만들어서 조건에 만족하지 못하게 만듬

							//System.out.println("같은문자연속" +babbling[i]);
							babbling[i] = "aaa";
						}

					}
					// 중복체크 끝났으니 옹알이 할수있는말로 이뤄졌는지 체크
					babbling[i] = babbling[i].replace("1", "");
					babbling[i] = babbling[i].replace("2", "");
					babbling[i] = babbling[i].replace("3", "");
					babbling[i] = babbling[i].replace("4", "");

					if (babbling[i].equals("")) {
						//System.out.println("카운트할게 " + babbling[i] + "--");
						answer++;
					}
				}

			}
			return answer;
		}
	}


	static class Solution2 {
		public int solution(String[] babblings) {
			// "aya", "ye", "woo", "ma" 4가지 발음만 가능
			int answer = 0;
			for(int i = 0; i < babblings.length; i++) {
				// 두개이상 연속된게 나오면 다음거 보자 ... 너무 인상적이다
				if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
					continue; // 뒤에 타지 않고 i++ 해서 다음거 실행
				}

				babblings[i] = babblings[i].replace("aya", " ");
				babblings[i] = babblings[i].replace("ye", " ");
				babblings[i] = babblings[i].replace("woo", " ");
				babblings[i] = babblings[i].replace("ma", " ");
				babblings[i] = babblings[i].replace(" ", "");

				if(babblings[i].length()  == 0) answer++;

			}
			return answer;
		}
	}

}
