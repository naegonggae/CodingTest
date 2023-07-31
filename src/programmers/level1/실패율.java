package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 실패율 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

		Solution2 solution2 = new Solution2();
		int[] result = solution2.solution(N, stages);
		System.out.println("result = " + Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(int N, int[] stages) {
			int[] answer = new int[N];

			// 스테이지마다 머무는 인원수
			int n = stages.length;

			// 각 스테이지에 도달했지만 클리어 못한 유저
			int[] arr = new int[N+1];
			for (int i = 0; i<stages.length; i++) {
				arr[stages[i]-1]++;
			}
			//System.out.println(Arrays.toString(arr));

			// 스테이지에 도달한사람
			int[] l = new int[N+1];
			for (int i = 0; i<arr.length; i++) {
				if (i == 0) {
					l[i] = n;
				} else {
					l[i] = n-arr[i-1];
					n -= arr[i-1];
				}
			}
			//System.out.println(Arrays.toString(l));

			Double[] f = new Double[N+1];
			HashMap<Double, Integer> m = new HashMap<>();

			for (int i = 0; i<arr.length-1; i++) {
				// 도달했지만 클러못한 사람이 없다면 실패율 0퍼
				if (arr[i] == 0) {
					f[i] = 0.0-((double)i/1000000000);
					m.put(f[i], i);
					//System.out.println(arr[i]+" "+l[i] +" "+i + " " + f[i]);
				}
				else if (l[i] == 0) {
					f[i] = 0.0-((double)i/1000000000);
					m.put(f[i], i);
					//System.out.println(arr[i]+" "+l[i] +" "+i + " " + f[i]);
				}
				else {
					f[i] = (double)arr[i]*100/l[i]-((double)i/1000000000);
					m.put(f[i], i);
					//System.out.println(arr[i]+" "+l[i] +" "+i + " " + f[i]);
				}
			}
			f[N] = 110.0;
			Arrays.sort(f, Collections.reverseOrder());
			//System.out.println(Arrays.toString(f));

			int s = 0;
			for (int i = 1; i<f.length; i++) {
				answer[s++] = m.get(f[i])+1;
			}
			//System.out.println((double)10.00-(double)2/10000);
			return answer;
		}
	}

	static class Solution2 {
		public int[] solution(int N, int[] lastStages) {
			int nPlayers = lastStages.length;
			int[] nStagePlayers = new int[N + 2];
			for (int stage : lastStages) {
				nStagePlayers[stage] += 1;
			}

			int remainingPlayers = nPlayers;
			List<Stage> stages = new ArrayList<>();
			for (int id = 1 ; id <= N; id++) {
				double failure = (double) nStagePlayers[id] / remainingPlayers;
				remainingPlayers -= nStagePlayers[id];

				Stage s = new Stage(id, failure);
				stages.add(s);
			}
			// Comparable 인터페이스의 compareTo 메서드를 정의해서 sorting 에 활용
			Collections.sort(stages, Collections.reverseOrder());

			int[] answer = new int[N];
			for (int i = 0; i < N; i++) {
				answer[i] = stages.get(i).id;
			}
			return answer;
		}

		class Stage implements Comparable<Stage> {
			public int id;
			public double failure;

			public Stage(int id_, double failure_) {
				id = id_;
				failure = failure_;
			}

			// 오름차순 정렬
			@Override
			public int compareTo(Stage o) {
				if (failure < o.failure ) {
					return -1;
				}
				if (failure > o.failure ) {
					return 1;
				}
				return 0;
			}
		}
	}


}
