Given `N` strings. Each string contains only lowercase letters from `a - j`(both inclusive). The set of `N` strings is said to be `GOOD SET` if no string is `prefix` of another string else, it is `BAD SET`. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is `BAD SET` because aab is prefix of aabcd.

Print `GOOD SET` if it satisfies the problem requirement.
Else, print `BAD SET` and the first string for which the condition fails.