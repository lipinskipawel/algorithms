/**
* @param nums { Array }
*/
const con = (nums) => {
  let lPointer = 0;
  let rPointer = nums.length - 1;
  let area = 0;
  while (lPointer < rPointer) {
    let left = nums[lPointer];
    let right = nums[rPointer];
    const smaller = pickSmaller(left, right);
    const currentArea = smaller * (rPointer - lPointer);
    if (currentArea > area) {
      area = currentArea;
    }
    if (right > left) {
      lPointer++;
    } else {
      rPointer--;
    }
  }
  return area;
}

const pickSmaller = (l, r) => {
  if (r > l) {
    return l;
  }
  return r;
};

module.exports = con;
