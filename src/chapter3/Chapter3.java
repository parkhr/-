package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chapter3 {
    public static void main(String[] args) throws IOException {
        // 3.3.4 함수형 인터페이스를 이용한 4단계 람다 전달
        String oneLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(oneLine);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
}
