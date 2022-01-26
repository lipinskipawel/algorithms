/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  const numberWithIndex = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] <= target) {
      const checkInMap = target - nums[i];
      const isInMap = numberWithIndex.get(checkInMap);
      if (isInMap === undefined) {
        numberWithIndex.set(nums[i], i);
      } else {
        return [isInMap, i];
      }
    }
  }
  return undefined;
};

module.exports = twoSum;
