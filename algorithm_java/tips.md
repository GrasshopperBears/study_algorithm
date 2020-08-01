버퍼를 사용한 input
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

2차원 배열에서 첫 번째 원소 기준 정렬 #7568
Arrays.sort(info, (a, b)->Integer.compare(a[0], b[0]));

