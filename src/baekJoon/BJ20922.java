package baekJoon;

import java.util.*;
import java.io.*;

public class BJ20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l=0, r=0, max=0, cnt=0;
		Map<Integer, Integer> map = new HashMap<>();
		while (r<n) {
			if (cnt == 0) {
				map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
				r++;
				cnt++;
			}
			map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
			if (map.get(arr[r]) <= k) {
				cnt++;
				r++;
				if (max < cnt) max = cnt;
			} else {
				while (arr[l] != arr[r]) { // 첫번째로 arr[r]을 만날때까지
					map.put(arr[l], map.get(arr[l])-1);
					cnt--;
					l++;
				}
				map.put(arr[l], map.get(arr[l])-1);
				l++;
				r++;
			}
		}
		System.out.println(max);
	}
}
