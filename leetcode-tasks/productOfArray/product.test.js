const product = require("./product.js");

test("should pass 1", () => {
  const result = product([1, 2, 3, 4]);

  expect(result).toEqual(expect.arrayContaining([24, 12, 8, 6]));
})

test("should pass 2", () => {
  const result = product([-1, 1, 0, -3, 3]);

  expect(result).toEqual(expect.arrayContaining([0, 0, 9, 0, 0]));
})
