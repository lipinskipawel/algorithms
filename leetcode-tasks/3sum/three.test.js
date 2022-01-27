const three = require("./three.js");

test("should pass 1", () => {
  const result = three([-1, 0, 1, 2, -1, -4]);

  expect(result).toEqual(expect.arrayContaining([[-1, -1, 2], [-1, 0, 1]]));
});
