package parse

import storage.Record

interface Parser {
    fun canParse(line: String): Boolean

    fun parseLine(line: String): Record
}