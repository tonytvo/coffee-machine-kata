package org.coffeemachine;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CoffeeMachineTest {

    private InputStream in;
    private PrintStream out;

    @AfterEach
    void tearDown() {
        System.setOut(out);
        System.setIn(in);
    }

    @BeforeEach
    void setUp() {
        in = System.in;
        out = System.out;
    }

    @Test
    public void
    givenQuitChoice_shouldQuit() {
        String input = "q\n";
        String displayText = runCoffeeMachine(input);
        Approvals.verify(displayText);
    }

    private static String runCoffeeMachine(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CoffeeMachine.main(new String []{});

        String displayText = output.toString();
        return displayText;
    }
}