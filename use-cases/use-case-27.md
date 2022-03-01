# USE CASE: 28 Provide a report on the population of the world

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee*, I have to *provide a report on the population of the world*, so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company. 

### Level

Primary task.

### Preconditions

Database provides population data for each country in `country.Population`, this can simply be SUMMED and the result will be the world population.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

Employee needs to provide report 

## MAIN SUCCESS SCENARIO

1. Organisation requests a population report for entire world.
2. Employee extracts population data for world.
3. Employee organises the data as requested.
4. Employee has a produced report.

## EXTENSIONS

2. **Data is incomplete**
    1. Employee requests the data is updated.
    2. Otherwise, the employee produces an incomplete report.
   
## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0