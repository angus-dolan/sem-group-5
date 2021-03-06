# USE CASE: 2 Provide a report of all the capital cities in a continent organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee* I want *provide a report of all the capital cities in a continent organised by largest population to smallest* so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains population data on the given continent, its countries and their capital cities.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

A request to add this specific feature to the system is made.

## MAIN SUCCESS SCENARIO

1. Organisation requests a population report on a given continent. 
2. Employee extracts population data of the given continent.
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