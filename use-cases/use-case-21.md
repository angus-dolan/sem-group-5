# USE CASE: 21 Provide a report of all the capital cities in a region organised by largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee*, I need to *provide a report of all the capital cities in a region organised by largest to smallest*, so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company. 

### Level

Primary task.

### Preconditions

Database schema contains a `country` table
- `country.Capital` contains the capital id pointing to `city` table.
- `country.Region` contains the region the country and subsequent capital resides in.

`country.Capital` will need to be joined on `city.ID`. Then grouped by `country.Region` before being ordered by DESC using `city.Population`.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

Employee needs to provide report 

## MAIN SUCCESS SCENARIO

1. Organisation requests a population report on all capital cities in a region. 
2. Data for all capital cities in a region is extracted from database.
3. Data is organised from largest to smallest, as requested.
4. Employee has a produced report.

## EXTENSIONS

1. **Data is incomplete**
    1. Employee requests the data is updated.
2. **Data not sorted correctly**
    1. Employee requests the system is updated.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0