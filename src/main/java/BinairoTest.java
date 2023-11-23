import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinairoTest {

    private BinairoSolver sut;

    @BeforeEach
    void createBinairoSolver() {
        sut = new BinairoSolver();
    }

    @Test
    void ensureThatEmptyLineReturnEmptyLine() throws Exception {

        String result = sut.solve("....");

        assertEquals("....", result);
    }
    @Test
    void ensureAdjacentEqualNumbersHaveOppositeNumber() throws Exception {
        String resultWithOne = sut.solve(".11.");
        String resultWithZero = sut.solve(".00.");
        String resultWithFirstOnes = sut.solve("11....");
        String resultWithFirstZeros = sut.solve("00....");

        assertEquals("0110", resultWithOne);
        assertEquals("1001", resultWithZero);
        assertEquals("110...", resultWithFirstOnes);
        assertEquals("001...", resultWithFirstZeros);
    }
    @Test
    void ensureThatOppositeNumberIsPlacedBetweenTwoEqualNumbers() throws Exception {
        String resultOfTwoZeros = sut.solve("0.0...");
        String resultOfTwoOnes = sut.solve("1.1...");

        assertEquals("010...", resultOfTwoZeros);
        assertEquals("101...", resultOfTwoOnes);
    }


@Test

    void ensureSequenceOfSixHasEqualAmountOfNumbers() throws Exception {
        String resultWithThreeOnes = sut.solve("..1101");
        String resultWithThreeZeros = sut.solve("..0010");

        assertEquals("001101", resultWithThreeOnes);
        assertEquals("110010", resultWithThreeZeros);

    }

    @Test
    void ensureSequenceOfEvenAmountOfNumbersHasEqualAmountOfNumbers() throws Exception {
        String resultWithTenNumbersHalfOfOnes = sut.solve("1.1101..1.");
        String resultWithTenNumbersHalfOfZeros = sut.solve("..00100..0");
        String resultWithSixteenNumbersHalfOfOnes = sut.solve("1.1101..1..11.10");
        String resultWithSixteenNumbersHalfOfZeros = sut.solve("..00100..00..00.");

        assertEquals("1011010010", resultWithTenNumbersHalfOfOnes);
        assertEquals("1100100110", resultWithTenNumbersHalfOfZeros);
        assertEquals("1011010010011010", resultWithSixteenNumbersHalfOfOnes);
        assertEquals("1100100110011001", resultWithSixteenNumbersHalfOfZeros);
    }

    @Test
    void ensureASeriesOffOddNumberOfSpotsTrowsAnException() throws Exception {
        String expectedMessage = "the binairo string is odd";

        String resultWithASeriesOffOddNumberOfSpots1= sut.solve(".....10.1");
        String resultWithASeriesOffOddNumberOfSpots2 = sut.solve("110.1");

        assertEquals(expectedMessage, resultWithASeriesOffOddNumberOfSpots1);
        assertEquals(expectedMessage, resultWithASeriesOffOddNumberOfSpots2);


    }
}
