# USE CASE: 18 Provide a report of all the capital cities in the world organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee*, I need to *provide a report of all the capital cities in the world organised by largest population to smallest*, so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company. 

### Level

Primary task.

### Preconditions

Database schema contains a `country` table which stores the capital id of the country in the `country.Capital` column. 

`country.Capital` will need to be joined on `city.ID`. Then ordered by descending order using `city.Population` **NOT** Country.Population as we are targeting capital city populations.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

Employee needs to provide report 

## MAIN SUCCESS SCENARIO

1. Organisation requests a population report on all capital cities. 
2. Data for all capital cities is extracted from database.
3. Data is organised from largest to smallest, as requested.
4. Employee has a produced report.

## EXTENSIONS

*put here the extensions, one at a time, each referring to the step of the main scenario*

2. **Data is incomplete**
    1. Employee requests the data is updated.
3. **Data not sorted correctly**
    1. Employee requests the system is updated.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0