
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

//    문제
//    하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.
//
//        3 : 3 (한 가지)
//        41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
//        53 : 5+7+11+13+17 = 53 (두 가지)
//    하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.
//
//    자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.
//
//        입력
//    첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)
//
//    출력
//    첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.

    // 1. 소수 구하기

    // 2.투포인터로 시작점과 끝점 설정
    // 3. 시작점의 인덱스부터 끝점의 인덱스까지의 소수 모두 합하기
    // 만약 포인터로 지정한 수들의 합이 N보다 작다면 끝점을 뒤로 보내기, 작다면 시작점을 뒤로 보내기
    // 같으면 시작점과 끝점 모두 뒤로 보내기

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //        Random random = new Random();
//        int N = random.nextInt(4000000) + 1;
//
//        System.out.println(N);
        // 소수 로직
        // 소수는 1과 자기자신만으로 나눌 수 있는 수.
        // i보다 작은 수로 나누어지는지 확인 시간 복잡도 n2 너무 오래걸림
        // 에라토스테네스의 체, nlog(logn),
        //
        // n=a*b일 때 둘중하나는 무조건 루트n보다 작음
        // 둘은 약수관계이기때문에 에라토스 테네스의 채에서 지울 때 더 큰수는 작은수에 의해 지워짐.

        boolean[] notPrime = new boolean[N + 1];// 전부 false로 초기화;
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        // nloglogn
        List<Integer> primearr = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!notPrime[i]) {
                primearr.add(i);
            }
        }
//n

        // 처음에 while 문으로 풂 end ;

        int count = 0;
        int start = 0;
        long sum = 0;   // 현재 구한 소수들의 합;

        for (int end = 0; end < primearr.size(); end++) {
            sum += primearr.get(end); //

            while (sum > N && start < end) {
                sum -= primearr.get(start);
                start++;
            }

            // 합이 N이면 카운트 증가
            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }


}










