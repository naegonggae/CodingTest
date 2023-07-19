package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;

public class 개인정보_수집_유효기간 {

	public static void main(String[] args) {

		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

		Solution solution = new Solution();
		ArrayList<Integer> result = solution.solution(today, terms, privacies);
		System.out.println("result = " + result);

	}

	static class Solution {
		public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
			ArrayList<Integer> answer = new ArrayList<Integer>();

			//변수가 참 많네...
			String[] td = today.split("[.]"); // \\. 특수문자는 이러네... [.] 이거나

			// map 으로 유효기간 표시
			HashMap<String, Integer> map = new HashMap();
			for (int i = 0; i<terms.length; i++) {
				String[] ttt = terms[i].split(" ");
				map.put(ttt[0], Integer.valueOf(ttt[1]));
			}

			// 생일일 + 유효기간한 날짜 변수로 생성
			for (int i = 0; i<privacies.length; i++) {
				String[] ps = privacies[i].split(" ");

				String[] pd = ps[0].split("[.]");

				int dd = Integer.valueOf(pd[2])-1;
				int dddd = 0;
				if (dd > 28) {
					dddd = dd / 28;
					dd = dd % 28;
				}
				//System.out.println(dd);

				int mmmm = 0;
				int mm = Integer.valueOf(pd[1]) + map.get(ps[1]) + dddd;
				if (mm > 12) {
					if (mm % 12 == 0) {
						mmmm = mm / 12 - 1;
						mm = 12;

					} else {
						mmmm = mm / 12;
						mm = mm % 12;
					}

				}
				//System.out.println(mm);

				int yyyy = Integer.valueOf(pd[0]) + mmmm;
				//System.out.println(yyyy);


				// 년 월 일 현재날짜와 비교
				if (yyyy < Integer.valueOf(td[0])) {
					answer.add(i+1);
				} else if (yyyy == Integer.valueOf(td[0])) {
					if (mm < Integer.valueOf(td[1])) {
						answer.add(i+1);
					} else if (mm == Integer.valueOf(td[1])) {
						if (dd < Integer.valueOf(td[2])) {
							answer.add(i+1);
						}
					}
				}
			}

			return answer;
		}
	}

	// 년 월 일 비교를 각각해야 한다는 고정관념을 깬 아주 창의적인 방법이라 첨부함
	private int getDate(String today) {
		String[] date = today.split("\\.");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		return (year * 12 * 28) + (month * 28) + day; // 일수로 통일해서 합을 구한다.
	}

}
