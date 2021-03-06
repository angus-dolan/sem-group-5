# USE CASE: 14 Provide a report of the top N populated cities in the world where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *organisation employee* I want *provide a report of the top N populated cities in the world where N is provided by the user* so that *I can design and implement a new system to allow easy access to this population information.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains population data for all cities in the world.

### Success End Condition

A report is available to the employee to work on the system.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

A request to add this specific feature to the system is made.

## MAIN SUCCESS SCENARIO

1. Organisation requests a report on the top N populated cities in the world.
2. Employee extracts population data of all the cities in the world, leaving the N specification to the user.
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