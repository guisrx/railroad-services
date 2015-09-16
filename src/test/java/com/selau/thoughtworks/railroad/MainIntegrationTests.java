package com.selau.thoughtworks.railroad;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;


/**
 * Integration tests to prone for bugs in the interaction of the internal components through end-to-end tests.
 * @author selau
 *
 */
public class MainIntegrationTests {

    @Test
    public void shouldProcessRailBIReportCorrectly() throws FileNotFoundException {
        // given
        final URL inputURL = this.getClass().getResource("/input-1.txt");
        final Main subject = new Main();

        // when
        final List<String> answers = subject.processAnswers(new String[] {inputURL.getFile()});

        // then
        final URL outputURL = this.getClass().getResource("/output-1.txt");
        final Scanner outputScanner = new Scanner(new FileInputStream(outputURL.getFile()));

        for (final String answer : answers) {
            assertEquals(outputScanner.nextLine(), answer);
        }
        outputScanner.close();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowExceptionWithInvalidFile() throws FileNotFoundException {
        // given
        final Main subject = new Main();

        // when then
        subject.processAnswers(new String[] {"input-fake.txt"});
    }

}
