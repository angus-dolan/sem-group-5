# USE CASE: 23 Provide a report of the top N populated capital cities in a continent where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee*, I need to *provide a report of the top N populated capital cities in a continent where N is provided by the user*, so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company. 

### Level

Primary task.

### Preconditions

**N** will need to be provided as an integer with no decimal point.

Database schema contains a `country` table
- `country.Capital` contains the capital id pointing to `city` table.

Database schema contains a `city` table
- `city.Population` contains the population of the city.

`country.Capital` will need to be joined on `city.ID`. GROUPED BY country.Continent ORDER BY DESC will provide largest to smallest results. Then LIMIT **N** will paginate results depending on how many the user requests with **N**.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

Employee needs to provide report 

## MAIN SUCCESS SCENARIO

1. Organisation requests a population report on all capital cities in a continent.
2. N is provided by user
3. Data for all capital cities is extracted from database.
4. Data is organised from largest to smallest, as requested using LIMIT N.
5. Employee has a produced report.

## EXTENSIONS

2. **Invalid N provided**
    1. Validation fails
    2. Employee provides new input with respect to validation message(s)
3. **Data is incomplete**
    1. Employee requests the data is updated.
4. **Data not sorted correctly**
    1. Employee requests the system is updated.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0