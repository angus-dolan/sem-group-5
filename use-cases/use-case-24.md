# USE CASE: 25 Provide a report on the population of people, people living in cities, and people not living in cities on each continent

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee*, I need to *provide a report on the population of people, people living in cities, and people not living in cities on each continent*, so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company. 

### Level

Primary task.

### Preconditions

Database provides data for each continent and continent city populations.

The total population of each continent will need to be SUMMED (total_pop).
The total population of cities within each continent will need to be SUMMED (cities_pop).

For each continent ((total_pop) - (cities_pop)) will be performed, the remainer will be the total population not living in cities for each continent.

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
2. Population of continent and population of cities in the continent extracted from database.
3. Remainder calculation performed to give population outwidth cities.
4. Employee has a produced report.

## EXTENSIONS

2. **Data is incomplete**
    1. Employee requests the data is updated.
3. **Remainder is < 0**
   1. If remainder is negative, result is wrong. As city population cannot be greater than continent population.
   2. Employee requests the data is updated.
   
## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0