/**
* @param nums { Array }
*/
const product = (nums) => {
  // [1,  2,  3, 4 ] - nums
  // [1,  2,  6, 24] - prefix
  // [24, 24, 12, 4] - postfix
  // [24, 12, 8, 6 ] - result
  const prefix = [...nums].fill(1);
  const postfix = [...nums].fill(1);
  const result = [];
  for (let i = 0; i < nums.length; i++) {
    if (i == 0) {
      prefix[i] = nums[i] * 1;
    } else {
      prefix[i] = nums[i] * prefix[i - 1];
    }
  }
  for (let i = postfix.length - 1; i >= 0; i--) {
    if (i == postfix.length - 1) {
      postfix[i] = nums[i] * 1;
    } else {
      postfix[i] = nums[i] * postfix[i + 1];
    }
  }
  for (let i = 0; i < nums.length; i++) {
    if (i == 0) {
      result[i] = 1 * postfix[i + 1];
    } else if (i == nums.length - 1) {
      result[i] = prefix[i - 1] * 1;
    } else {
      result[i] = prefix[i - 1] * postfix[i + 1];
    }
  }
  return result;
};

module.exports = product;
