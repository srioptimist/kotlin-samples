package sri.nl.sample.basics

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 */

fun main() {
    println(SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 5))
    println(SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 2))
    println(SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 7))

    println(SearchInsertPosition().optimizedSolution(intArrayOf(1,3,5,6), 5))
    println(SearchInsertPosition().optimizedSolution(intArrayOf(1,3,5,6), 2))
    println(SearchInsertPosition().optimizedSolution(intArrayOf(1,3,5,6), 7))
}

class SearchInsertPosition {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var t = target
        if( nums.indexOf(target) == -1)
        {
            if(target < nums[0]) {
                return 0
            }

            if(target > nums[nums.size-1]) {
                return nums.size
            }

            while(nums.indexOf(t) == -1) {
                t += 1
            }

            return nums.indexOf(t)
        }
        return nums.indexOf(target)
    }

    fun optimizedSolution(nums: IntArray, target: Int): Int {

        var start = 0
        var end = nums.size - 1

        while(start <= end) {
            val mid  = (start + end) / 2
            if(nums[mid] == target){
                return mid
            }
            if(nums[mid] < target) start = mid + 1
            else end = mid -1
        }
        return start

    }
}