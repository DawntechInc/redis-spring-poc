# Spring Redis

__Author:__ Levindo Gabriel Taschetto Neto.


## How to use it

1.  Run the redis server in a separated terminal.

2.  In a second terminal:
```terminal
$ gradle clean build springBoot
```

## Rest API's endpoints
### Edit name by name
```terminal
/editName/{matriculationNumber}/{name}/
```
### Edit name by number of courses
```terminal
/editName/{matriculationNumber}/{numberOfCourses}/
```
### Save
```terminal
/save/{matriculationNumber}/{name}/{numberOfCourses}
```