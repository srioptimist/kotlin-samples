package sri.nl.sample.basics

/***
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */


fun main() {
    println(MedianOfTwoSortedArrays().findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    println(MedianOfTwoSortedArrays().findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
    println(MedianOfTwoSortedArrays().optimizedSolution(intArrayOf(1,3), intArrayOf(2)))
}

class MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
      val c = nums1.plus(nums2).sortedArray()
        return if(c.size%2!=0) {
            c[(c.size/2)].toDouble()
        } else {
            ((c[(c.size/2)].toDouble() + c[(c.size/2)-1].toDouble())/2)
        }
    }

    fun optimizedSolution(nums1: IntArray, nums2: IntArray): Double {
        var current = 0.0
        var previous = 0.0
        val mid = ((nums1.size+nums2.size)/2) + 1
        var nums1Index = 0
        var nums2Index = 0
        var sortedNumCount = 0
        while(sortedNumCount<mid){
            previous = current
            if(nums2Index !in nums2.indices || (nums1Index in nums1.indices && nums1[nums1Index] <= nums2[nums2Index])){
                current = nums1[nums1Index].toDouble()
                nums1Index++
            } else {
                current = nums2[nums2Index].toDouble()
                nums2Index++
            }
            sortedNumCount++
        }
        if((nums1.size+nums2.size)%2 == 0){
          return  (previous + current) / 2.0
        }
        return current
    }
}