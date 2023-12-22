package baekJoon;

import java.io.*;
import java.util.*;

public class BJ5427 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int w, h;
	static char[][] map;
	static Queue<int[]> person;
	static Queue<int[]> fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int z = 0; z<n; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[h][w];
			fire = new LinkedList<>();
			person = new LinkedList<>();

			for (int i = 0; i<h; i++) {
				String tmp = br.readLine();
				for (int j = 0; j<w; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '@') {
						person.add(new int[] {j, i, 0});
					} else if (map[i][j] == '*') {
						fire.add(new int[] {j, i});
					}
				}
			}

			int result = -1;
			out : while (true) {
				int fSize = fire.size();
				for (int i = 0; i<fSize; i++) {
					int[] pos = fire.poll();
					int px = pos[0], py = pos[1];
					fireMarking(px, py);
				}

				int pSize = person.size();
				for (int i = 0; i<pSize; i++) {
					int[] pos = person.poll();
					int px = pos[0], py = pos[1], time = pos[2];
					result = escape(px, py, time);
					if (result != -1) {
						break out;
					}
				}
				if (person.isEmpty()) break;
			}

			if (result != -1) sb.append(result+"\n");
			else sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb.toString());
	}

	static int escape(int x, int y, int time) {
		for (int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx<0 || nx>w-1 || ny<0 || ny>h-1) {
				return time+1;
			}
			if (map[ny][nx] == '.') {
				map[ny][nx] = '@';
				person.add(new int[] {nx, ny, time+1});
			}
		}
		return -1;
	}

	static void fireMarking(int x, int y) {
		for (int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx<0 || nx>w-1 || ny<0 || ny>h-1) continue;

			if (map[ny][nx] == '.' || map[ny][nx] == '@') {
				map[ny][nx] = '*';
				fire.add(new int[] {nx, ny});
			}
		}
	}
}