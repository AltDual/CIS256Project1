## Introduction and Summary of Project

In this project we have designed a document search system with the goal to enforce our understanding of data structures.
Along with the document search system we have also implemented some expreiments to test the performance of our data structures and in this document (get it) we will be reporting our observations and summarize the results of our experiments.

* A side note any code involving the use of file paths (especially with the Tokenizer class should be adjusted to your file structure)
* Tests were ran on an i5-8350U, runtime may vary on other machines 
### Sorting and Searching Algorithims

For our sorting alogrithims I have decided to implement insertion sort and merge sort.
Insertion sort is a very slow sorting algorithm with a worst case time complexity of O(n^2^). Merge sort is a fast sorting algoritm with a worst case time complexity of O(nlogn).
This is reflected in our experiment testing the runtime of these 2 sorting algorithms where we timed these 2 algorithms sorting an array of 50,000 strings.
| Merge Sort Runtime (ms) | Insertion Sort Runtime (ms) |
| ----------------------- | --------------------------- |
| 123.5               | 21027.4                 |
| 134.6               | 22751.9                 |
| 121.4               | 22007.2                 |

As we can see by the data we collected we can see the difference the speed of these two algorithms as merge sort is close to 170x faster than insertion sort just empahsizing the difference between O(n^2^) and O(nlogn) on these big input sizes. 

Our searching algorithms we used were binary and linear search, each having a O(logn) and O(n) worst case time complexity respectively. We tested this using the same array with 50,000 strings, and choosing a random string that existed in the array to search for.
| Linear Search Runtime (ms) | Binary Search Runtime (ms) |
| -------------------------- | -------------------------- |
| 4.803989                   | 0.033811                   |
| 9.161694                   | 0.028461                   |
| 2.785971                   | 0.034398                   |

As we can see binary search is around 181.7x faster than linear search on average. We can also see that there is a lot of variance in linear search. This is the result of the position of the string to be searched and binary search is a little more consistent as O(logn) prevents the variance from getting too big.

## Map-Like Data Structures

Using our long_sorted.txt we tested the search time of our different data structures.
| AVL Tree (ms) | BST Map (ms) | HashMap (ms) | Red-Black Tree (ms) |
| ------------- | ------------ | ------------ | ------------------- |
| 0.074509      | 0.170731     | 0.012827     | 0.023197            |
| 0.079207      | 0.109363     | 0.012439     | 0.023807            |
| 0.155427      | 0.171207     | 0.011722     | 0.021375            |

As expected our BST is the slowed as there is no balancing mechanism so the tree is essentially a linked list having an O(n) worst case lookup. In the case of AVL Trees and Red-Black Trees they are balanced trees so they both have an O(logn) average lookup. However our AVL tree has a much slower lookup runtime than our Red-Black tree even though in theory our AVL tree should be more strictly balanced than our Red-Black tree. I believe that this is just due to having to the AVL tree just having more overhead and on a larger dataset the AVL trees lookup performance should in theory be better. As for our HashMap it is exactly as we expected as HashMap has an average O(1) lookup.