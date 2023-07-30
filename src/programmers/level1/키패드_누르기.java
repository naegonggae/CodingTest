package programmers.level1;

public class 키패드_누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";

		Solution solution = new Solution();
		String result = solution.solution(numbers, hand);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(int[] numbers, String hand) {
			String answer = "";
			int l = 10;
			int r = 12;

			for (int i = 0; i<numbers.length; i++) {
				if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
					l = numbers[i];
					answer+="L";
				}
				else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
					r = numbers[i];
					answer+="R";
				}
				else {
					// l과 r과 2480 사이를 비교해야됨
					int ll = leftMove(l, numbers[i]);
					int rr = rightMove(r, numbers[i]);

					//System.out.println(numbers[i] + " "+ l+" "+leftMove(l, numbers[i]));
					//System.out.println(numbers[i] + " "+ r+" "+rightMove(r, numbers[i]));
					if (ll > rr) {
						answer+="R";
						if (numbers[i] == 0) {
							numbers[i] = 11;
						}
						r=numbers[i];
					} else if (ll < rr) {
						answer+="L";
						if (numbers[i] == 0) {
							numbers[i] = 11;
						}
						l=numbers[i];
					} else {
						if (hand.equals("right")) {
							answer+="R";
							if (numbers[i] == 0) {
								numbers[i] = 11;
							}
							r=numbers[i];
						} else {
							answer+="L";
							if (numbers[i] == 0) {
								numbers[i] = 11;
							}
							l=numbers[i];
						}
					}
				}
			}

			return answer;
		}

		private int leftMove(int a, int b) {
			int num = 0;
			int k = b;
			if (k == 0) {
				k = 11;
			}
			if (a==k) {
				num = 0;
				return num;
			} else if (a < k) {
				while (a+1 != k) {
					a+=3;
					if (a == k) {
						return num+1;
					}
					num++;

				}
				return num+1;

			} else {
				while (a+1 != k) {
					a-=3;
					if (a == k) {
						return num+1;
					}
					num++;
				}
				return num+1;
			}

		}

		private int rightMove(int a, int b) {
			int num = 0;
			int k = b;
			if (k == 0) {
				k = 11;
			}
			if (a==k) {
				num = 0;
				return num;
			} else if (a < k) {
				while (a-1 != k) {
					a+=3;
					if (a == k) {
						return num+1;
					}
					num++;

				}
				return num+1;

			} else {
				while (a-1 != k) {
					a-=3;
					if (a == k) {
						return num+1;
					}
					num++;
				}
				return num+1;
			}

		}
	}

}
