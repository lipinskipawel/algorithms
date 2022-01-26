const twoSum = require("./twoSum");

test("should pass 1", () => {
  const result = twoSum([1, 2, 3], 3)

  expect(result).toEqual([0, 1]);
});

test("should pass 2", () => {
  const result = twoSum([2, 7, 11, 15], 9)

  expect(result).toEqual([0, 1]);
});

test("should pass 3", () => {
  const result = twoSum([3, 2, 4], 6)

  expect(result).toEqual([1, 2]);
});

test("should pass 4", () => {
  const result = twoSum([3, 0, 2, 9], 9)

  expect(result).toEqual([1, 3]);
});

test("should pass 5", () => {
  const result = twoSum([3, 0, 2, 9], 8)

  expect(result).toEqual(undefined);
});
