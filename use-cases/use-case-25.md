# USE CASE: 26 Provide a report on the population of people, people living in cities, and people not living in cities in each region

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee*, *I need to provide a report on the population of people, people living in cities, and people not living in cities in each region*, so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company. 

### Level

Primary task.

### Preconditions

Database provides data for population, city population and population outwidth cities for each region.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

Employee needs to provide report 

## MAIN SUCCESS SCENARIO

1. Organisation requests a population report for total population, city population and non-city population in each region.
2. Employee extracts population data of all regions.
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