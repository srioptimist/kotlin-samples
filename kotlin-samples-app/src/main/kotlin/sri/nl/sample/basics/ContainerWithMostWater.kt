package sri.nl.sample.basics

/**
 * Example 1:
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */

fun main() {
println(ContainerWithMostWater().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
println(ContainerWithMostWater().maxArea(intArrayOf(1,1)))
println(ContainerWithMostWater().maxArea(intArrayOf(0,2)))
println(ContainerWithMostWater().optimizedSolution(intArrayOf(1,8,6,2,5,4,8,3,7)))
println(ContainerWithMostWater().optimizedSolution(intArrayOf(1,1)))
println(ContainerWithMostWater().optimizedSolution(intArrayOf(0,2)))
}

class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var area = 0
        for(i in height.indices) {
            val currentValue = height[i]
            for(j in i+1 until height.size) {
                val nextValue = height[j]
                val width = minOf(currentValue, nextValue)
                val length = j - i
                if((length * width) > area) {
                    area = length * width
                }
            }
        }
        return area
    }

    fun optimizedSolution(height: IntArray): Int {
        var area = 0
        var l = 0
        var r = height.size-1
        while(l!=r){
            val newArea = minOf(height[l], height[r]) * (r-l)
            area = maxOf(area, newArea)
            when {
                height[l] > height[r] -> r--
                height[l] <= height[r] -> l++
            }
        }
        return area
    }
}