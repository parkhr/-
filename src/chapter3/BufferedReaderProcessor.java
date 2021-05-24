package chapter3;

import java.io.BufferedReader;
import java.io.IOException;

// 3.3.2 2단계 : 함수형 인터페이스를 이용해서 전달
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
