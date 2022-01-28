const sum = (a, b) => {
  while (b != 0) {
    const tmp = (a & b) << 1; 
    a = a ^ b;
    b = tmp;
  }
  return a;
}

module.exports = sum;
