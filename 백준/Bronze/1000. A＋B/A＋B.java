import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        int A = in.nextInt();
        int B = in.nextInt();

        System.out.println(A+B);

        //https://solved.ac/problems
    }
}

class InputReader {
    private BufferedReader br;
    private StringTokenizer st;

    public InputReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    // 다음 토큰을 int로 읽음
    public int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine(), " ");
        }
        return Integer.parseInt(st.nextToken());
    }

    // 한 줄 전체를 문자열로 읽음
    public String nextLine() throws IOException {
        return br.readLine();
    }

    // BufferedReader 직접 접근이 필요한 경우
    public BufferedReader getReader() {
        return br;
    }
}
