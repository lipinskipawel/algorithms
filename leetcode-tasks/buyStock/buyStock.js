/**
 * @param {number[]} prices
 * @return {number}
 */
const buy = (prices) => {
  let highestProfit = 0;
  let lowestSeenValue = 0;
  for (let i = 0; i < prices.length; i++) {
    if (i == 0) {
      lowestSeenValue = prices[i];
      continue;
    }
    if (prices[i] > lowestSeenValue) {
      const diff = prices[i] - lowestSeenValue;
      if (diff > highestProfit) {
        highestProfit = diff;
      }
    } else {
      lowestSeenValue = prices[i];
    }
  }
  return highestProfit;
};

module.exports = buy;
