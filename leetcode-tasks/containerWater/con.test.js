const con = require("./con.js");

test("should pass 1", () => {
  const result = con([1,8,6,2,5,4,8,3,7]);

  expect(result).toBe(49);
})
