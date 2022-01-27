/**
* @param nums { Array } of inputs
*/
const three = (nums) => {
  nums.sort();
  const result = [];

  for (let i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] == nums[i - 1]) {
      continue;
    }
    let leftPointer = i + 1;
    let rigthPointer = nums.length - 1;
    while (leftPointer < rigthPointer) {
      let sum = nums[i] + nums[leftPointer] + nums[rigthPointer];
      if (sum > 0) {
        rigthPointer--;
      } else if (sum < 0) {
        leftPointer++;
      } else {
        result.push([nums[i], nums[leftPointer], nums[rigthPointer]]);
        leftPointer++;
        while (nums[leftPointer] == nums[leftPointer - 1] && leftPointer < rigthPointer) {
          leftPointer++;
        }
      }
    }
  }
  return result;
};

module.exports = three;
