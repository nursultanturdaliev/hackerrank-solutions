## Hackerrank Solutions
 
 ### Problem: `Find the Running Median`
 
 Hackerrank Link - https://www.hackerrank.com/challenges/find-the-running-median/problem
 
 
 ### Description

The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:

If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set `{1, 2, 3}, 2` is the median.
If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set {1, 2 ,3, 4}, (2+3)/2 = 2.5  is the median.
Given an input stream of `n` integers, you must perform the following task for each `i'th`  integer:

- Add the `i'th` integer to a running list of integers.
- Find the median of the updated list (i.e., for the first element through the `i'th` element).
- Print the list's updated median on a new line. The printed value must be a double-precision number scaled to `1`  decimal place (i.e., `12.3` format).