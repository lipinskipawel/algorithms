const buy = require("./buyStock.js");

test("should pass 1", () => {
  const result = buy([7,1,5,3,6,4]);

  expect(result).toBe(5);
});

test("should pass 2", () => {
  const result = buy([7, 6, 4, 3, 1]);

  expect(result).toBe(0);
});
