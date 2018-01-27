package com.schreiber.kotlin.list

fun <T> List<T>.myPartition(partitionSize: Int = 2): List<List<T>> {
    validatePartitionSize(partitionSize)
    return myRecursivePartition(this, partitionSize, emptyList())
}

private tailrec fun <T> myRecursivePartition(list : List<T>, partitionSize: Int = 2, accumulator : List<List<T>>): List<List<T>> {
    return when {
        list.isEmpty() -> accumulator
        list.size <= partitionSize -> accumulator + listOf(list)
        else -> myRecursivePartition(list.takeLast(list.size - partitionSize),
                partitionSize,
                accumulator + listOf(list.take(partitionSize)))
    }
}

private fun validatePartitionSize(partitionSize: Int) {
    if (partitionSize < 1) throw IllegalArgumentException("Partition sizz should be strictly greater than 0, ${partitionSize} is invalid")
}