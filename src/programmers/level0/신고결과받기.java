package programmers.level0;

import java.util.*;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		ArrayList<User> users = new ArrayList<>();
		HashMap<String, Integer> suspendedList = new HashMap<>();
		HashMap<String, Integer> idIdx = new HashMap<>();
		int idx = 0;

		for (String name : id_list) {
			idIdx.put(name, idx++);
			users.add(new User(name));
		}

		for (String re : report) {
			String[] str = re.split(" ");
			users.get(idIdx.get(str[0])).reportList.add(str[1]);
			users.get(idIdx.get(str[1])).reportedList.add(str[0]);
		}

		for (User user : users) {
			if (user.reportedList.size() >=k)
				suspendedList.put(user.name, 1);
		}

		for (User user : users) {
			for (String nameReport : user.reportList) {
				if (suspendedList.get(nameReport) != null) {
					answer[idIdx.get(user.name)]++;
				}
			}
		}
		return answer;
	}

	static class User {
		String name;
		HashSet<String> reportList;
		HashSet<String> reportedList;

		public User(String name) {
			this.name = name;
			reportList = new HashSet<>();
			reportedList = new HashSet<>();
		}
	}
}
