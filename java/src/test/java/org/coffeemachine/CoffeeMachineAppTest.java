package org.coffeemachine;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CoffeeMachineAppTest {

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
    goldenMaster() {
        String [] inputs = new String [] { "q\n",
                "1\nq\n",
                "3\nr\nq\n",
                "\nq\n",
                "999\nq\n",
                "3\n3\n3\n3\n3\nq\n"
        };
        Approvals.verifyAll(inputs, CoffeeMachineAppTest::runCoffeeMachine);
    }

    private static String runCoffeeMachine(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CoffeeMachineApp.main(new String []{});

        return output.toString();
    }
}