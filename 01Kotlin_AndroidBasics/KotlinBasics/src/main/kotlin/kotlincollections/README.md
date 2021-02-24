# Collections in Kotlin #

Collections are primarily used to manage groups of different kinds of objects. Normally, a collection contains a number objects of the same type. Kotlin provides different collection types for different scenarios:
## Collection Types ##
1.	**Array** is the simplest Kotlin collection. Arrays store objects of the *same type* and have *fixed lengths*. When an array is created, memory slots are allocated depending on the array size. For that reason, elements cannot be removed or added to the array, but it is possible to change what is stored in it. Arrays are *immutable when it comes to size*, but *mutable when it comes to their elements*.
2.	**List** is an ordered collection with access to elements by indices – integer numbers that reflect their position. Elements can occur *more than once* in a list. An example of a list is a sentence: it's a group of words, their order is important, and they can repeat.
3.	**Set** is a collection of *unique elements*. It reflects the mathematical abstraction of set: a group of objects without repetitions. Generally, the order of set elements has no significance. For example, an alphabet is a set of letters.
4.	**Map (or dictionary)** is a set of *key-value pairs*. Keys are unique, and each of them maps to exactly one value. The values can be duplicates. Maps are useful for storing logical connections between objects, for example, an employee's ID and their position.

Furthermore, Kotlin collections come in two forms:

* **Immutable Collections** support read-only functionalities and elements cannot be modified. 
	* Eg.: listOf(), listOf<T>(), setOf(), mapOf(), arrayOf()
* **Mutable Collections** support read and write functionalities. 
	* Eg.: mutableListOf(). arrayListOf(), mutableSetOf(), hashSetOf(), mutableMapOf(), hashMapOf()

## Overview Kotlin Collections ##
| Array | List | Set | Map|
|--|--|--|--|
| Static collection with fixed size | Dynamic version of arrays. Store elements in specific order. | Store unique elements in no specific order (have no indices) | Maps store key value pairs and for that maps can consist of different object types |
| Allows duplicates | Allows duplicates | No duplicates | Keys are unique |
| Size is immutable, elements are mutable | Size and contents can be changed if mutable collection is used (eg.: mutableListOf() ) |  Size and contents can be changed if mutable collection is used (eg.: mutableSetOf () ) | Size and contents can be changed if mutable collection is used (eg.: mutableMapOf () ) | 
| Array usage: | List usage: | Set usage: when need to filter out duplicates, eg.: storing ids or users | Map usage: useful when trying to tie a value to a key, eg.: values to id or string identifiers | 


[Kotlin Lang Collections Overview](https://kotlinlang.org/docs/reference/collections-overview.html)
