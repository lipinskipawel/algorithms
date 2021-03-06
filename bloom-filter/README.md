# Bloom Filter

Bloom Filter is a space-efficient probabilistic data structure that is used to
check whether a value is present in a given set. False positive matches are
possible, but false negative are not. Meaning that it can return true asked
about specific element but in reality it should return false because given
element was never inserted into it (false positive). Bloom Filter data
structure can then efficiently answer the question whether element is definitely
not in the set.

Bloom Filter is used in databases. Imagine a situation where a database is
using an index like LSM tree. When a read request comes in and the data is not
in the index it will start to look at the merged files on a disk. This process
of looking at the filesystem could be expensive thus we need a way of
minimizing it. Bloom Filter will help to avoid going through the filesystem by
answering the question: have this data been saved on disk already?
