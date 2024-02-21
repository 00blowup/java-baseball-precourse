package baseball.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void printHint_테스트() {
        ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        String testString = "abc";
        OutputView.printHint(testString);

        assertThat(outputMessage.toString()).isEqualTo(testString+"\n");

        System.setOut(System.out);
    }
}