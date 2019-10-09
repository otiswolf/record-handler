package parse

import exceptions.RecordParseException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import storage.Record
import java.time.LocalDate

internal class CommaParserTest {
    val validLine = "Wolf, Otis, Male, Green, 11-07-1996"
    val invalidLine = "This is not valid"

    val exampleRecord = Record("Wolf", "Otis", "Male", "Green", LocalDate.parse("1996-11-07"))

    @Test
    fun `test canParse returns true when given valid line`() {
        assertTrue(CommaParser.canParse(validLine))
    }

    @Test
    fun `test canParse returns false when given invalid line`() {
        assertFalse(CommaParser.canParse(invalidLine))
    }

    @Test
    fun `test parseLine returns valid record when given valid line`() {
        val testResult = CommaParser.parseLine(validLine)
        assertEquals(exampleRecord, testResult)
    }

    @Test
    fun `test parseLine throws RecordParseException when given invalid line`() {
        assertThrows(RecordParseException::class.java) {
            CommaParser.parseLine(invalidLine)
        }
    }
}