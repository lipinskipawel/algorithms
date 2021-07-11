# Version number

Version number is data structure designed to be useful under the concurrent
workloads in distributed systems. This data structure is a simplification of
the [dotted version vector].

In distributed system the concurrent update on the same object will result in
data conflict thus there is a need for conflictless data structure. Version
number will guarantee that any update that is concurrent will not be lost. It
holds this guarantee by maintaining separate versions of the given object.

[dotted version vector]: https://arxiv.org/abs/1011.5808
