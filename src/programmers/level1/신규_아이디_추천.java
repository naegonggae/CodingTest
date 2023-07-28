package programmers.level1;

public class 신규_아이디_추천 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";

		Solution solution = new Solution();
		String result = solution.solution(new_id);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(String new_id) {
			String answer = "";

			// 소문자 변경
			new_id = new_id.toLowerCase();

			for (int i = 0; i<new_id.length(); i++) {
				String s = String.valueOf(new_id.charAt(i));
				// 알파벳 소문자 살려
				if (new_id.charAt(i)-'a' >=0 && new_id.charAt(i)-'a' <= 25) {
					answer+=s;
				}
				// _-. 살려
				else if(s.equals("-") || s.equals("_") || s.equals(".")) {
					answer+=s;
				}
				// 숫자 살려
				else if (new_id.charAt(i)-'0' >=0 && new_id.charAt(i)-'0' <= 9) {
					answer+=s;
				}
				// else {
				//     // 특수문자를 바꿔야함 [여기안에 문자넣고 그랬던거같은데] \\. 이렇게나
				//     new_id = new_id.replace(s, "");
				// }
			}
			// System.out.println(answer);

			while (answer.indexOf("..") != -1) {
				answer = answer.replace("..", ".");
			}
			// System.out.println(answer);

			// s들어가 주의 starts, ends
			if (answer.startsWith(".")) {
				answer = answer.substring(1, answer.length());
			}
			if (answer.endsWith(".")) {
				answer = answer.substring(0, answer.length()-1);
			}
			// System.out.println(answer);
			if (answer.equals("")) {
				answer = "a";
			}
			// System.out.println(answer);
			if (answer.length()>=16) {
				answer = answer.substring(0, 15);
				if (answer.startsWith(".")) {
					answer = answer.substring(1, answer.length());
				}
				if (answer.endsWith(".")) {
					answer = answer.substring(0, answer.length()-1);
				}
			}

			// System.out.println(answer);
			while (answer.length()<=2) {
				String s = String.valueOf(answer.charAt(answer.length()-1));
				answer+=s;
			}

			return answer;
		}
	}
	// replaceAll 사용
	static class Solution2 {
		public String solution(String new_id) {
			String answer = "";
			String temp = new_id.toLowerCase();

			temp = temp.replaceAll("[^-_.a-z0-9]","");
			// ˆ(opt + i) 제외하고 뜻 []안에 여러개를 콤마없이 넣을수 있음
			System.out.println(temp);
			temp = temp.replaceAll("[.]{2,}","."); // x{n,} : x의 n번 이상 반복
			temp = temp.replaceAll("^[.]|[.]$",""); // .이 맨앞이거나 뒤거나
			System.out.println(temp.length());
			if(temp.equals(""))
				temp+="a";
			if(temp.length() >=16){
				temp = temp.substring(0,15);
				temp=temp.replaceAll("^[.]|[.]$","");
			}
			if(temp.length()<=2)
				while(temp.length()<3)
					temp+=temp.charAt(temp.length()-1);

			answer=temp;
			return answer;
		}
	}

}
