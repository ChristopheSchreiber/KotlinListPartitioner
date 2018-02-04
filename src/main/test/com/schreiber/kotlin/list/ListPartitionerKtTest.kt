package com.schreiber.kotlin.list

import org.junit.Assert.assertEquals
import org.junit.Test

class ListPartitionerKtTest {

    @Test fun empty_list_should_return_an_empty_list() {
        assertEquals(emptyList<List<String>>(), emptyList<String>().myPartition())
    }

    @Test fun should_also_handle_integers() {
        assertEquals(emptyList<List<Int>>(), emptyList<Int>().myPartition())
    }

    @Test fun should_accept_different_partition_size() {
        assertEquals(emptyList<List<Int>>(), emptyList<Int>().myPartition(3))
    }

    @Test(expected = IllegalArgumentException::class) fun partition_size_should_not_be_negative() {
        emptyList<Int>().myPartition(-1)
    }

    @Test(expected = IllegalArgumentException::class) fun partition_size_should_be_strictly_greater_than_0() {
        emptyList<Int>().myPartition(0)
    }

    @Test fun given_list_smaller_than_partition_size_should_return_the_a_list_containing_source_list() {
        val list = listOf(1)
        assertEquals(listOf(list), list.myPartition(2))
    }

    @Test fun given_list_size_equals_to_partition_size_should_return_the_a_list_containing_source_list() {
        val list = listOf(1, 2)
        assertEquals(listOf(list), list.myPartition(2))
    }

    @Test fun given_1_2_3_and_partition_size_2_should_return_1_2_and_3() {
        val list = listOf(1, 2, 3)
        assertEquals(listOf(listOf(1, 2), listOf(3)), list.myPartition(2))
    }

    @Test fun given_1_2_3_4_and_partition_size_2_should_return_1_2_and_3_4() {
        val list = listOf(1, 2, 3, 4)
        assertEquals(listOf(listOf(1, 2), listOf(3, 4)), list.myPartition(2))
    }

    @Test fun given_1_2_3_4_5_and_partition_size_2_should_return_1_2_and_3_4_and_5() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(listOf(1, 2), listOf(3, 4), listOf(5)), list.myPartition(2))
    }

    @Test fun should_handle_big_lists() {
        val list = getListOfSize(1000)
        list.myPartition(2)
    }

    @Test fun should_handle_really_big_lists() {
        val list = getListOfSize(100000)
        list.myPartition(2)
    }

    private fun getListOfSize(size: Int): List<Int> {
        val range = 1..size
        var list = emptyList<Int>()
        for (i in range) list = list + i
        return list
    }
}
