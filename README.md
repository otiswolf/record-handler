# record-service

### Requirements
- Step 1
  - Service should be able to read files of records in three different formants (comma delimited, pipe delimited, and space delimited) and parse into record objects
  - Store records in memory 
  - Display records on screen, organizing either by gender, birthdate, or last name
- Step 2
  - Build a REST API that can access record data
  - Add enpoints for:
    - Adding a single entry to record storage
    - Returning records by gender
    - Returning records by birthdate
    - Returning records by name

### Usage
- Step 1

  Step 1 can be demonstrated by runnig the following command: 
  ```
  java -jar build/libs/record-service.jar <DISPLAY_MODE> records/records-comma.txt records/records-pipe.txt records/records-space.txt
  ```
  Replace `<DISPLAY_MODE>` with either `gender`, `birthdate`, or `lastname` to choose the way you would like the records to be displayed. You may also replace any of the files with your own custom input files, provided they are in one of the three given formats (pipe, comma, or space delimited).
