package racingcar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class Reader {
    private Reader() {}

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String next() {
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return st.nextToken();
    }

    public static int nextInt() { return Integer.parseInt(next()); }
    public static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
