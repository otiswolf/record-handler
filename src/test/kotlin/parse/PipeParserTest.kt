package parse

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import storage.Record
import exceptions.RecordParseException
import java.time.LocalDate

internal class PipeParserTest {
    val validLine = "Wolf | Otis | Male | Green | 11-07-1996"
    val invalidLine = "This is not valid"

    val exampleRecord = Record("Wolf", "Otis", "Male", "Green", LocalDate.parse("1996-11-07"))

    @Test
    fun `test canParse returns true when given valid line`() {
        assertTrue(PipeParser.canParse(validLine))
    }

    @Test
    fun `test canParse returns false when given invalid line`() {
        assertFalse(PipeParser.canParse(invalidLine))
    }

    @Test
    fun `test parseLine returns valid record when given valid line`() {
        val testResult = PipeParser.parseLine(validLine)
        assertEquals(exampleRecord, testResult)
    }

    @Test
    fun `test parseLine throws RecordParseException when given invalid line`() {
        assertThrows(RecordParseException::class.java) {
            PipeParser.parseLine(invalidLine)
        }
    }
}