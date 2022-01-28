const sum = require("./sum.js");

test("should pass 1", () => {
  const result = sum(1, 2);

  expect(result).toBe(3);
});

test("should pass 2", () => {
  const result = sum(9, 11);

  expect(result).toBe(20);
});
