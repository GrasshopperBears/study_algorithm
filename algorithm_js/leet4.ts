const assert = require('assert');

const findMedianSortedArrays = (nums1: number[], nums2: number[]) => {
  if (nums1.length > nums2.length) {
    const tmp = nums2;
    nums2 = nums1;
    nums1 = tmp;
  }
  const nums1Len = nums1.length;
  const nums2Len = nums2.length;
  let left = 0;
  let right = nums1Len;
  let i = 0;
  let j = 0;

  while (left <= right) {
    i = left;
    j = Math.floor((nums1Len + nums2Len) / 2) - i;

    if (nums1[i] < nums2[j - 1] && i < nums1Len) left = i + 1;
    else if (nums1[i - 1] > nums2[j] && i > 0) right = i - 1;
    else break;
  }
  const rightMin = i >= nums1Len ? nums2[j] : j >= nums2Len ? nums1[i] : Math.min(nums1[i], nums2[j]);

  if ((nums1Len + nums2Len) % 2) return rightMin;

  const leftMax = i === 0 ? nums2[j - 1] : j === 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]);

  return (leftMax + rightMin) / 2;
};

assert.deepEqual(findMedianSortedArrays([1, 3], [2]), 2);
assert.deepEqual(findMedianSortedArrays([1, 2], [3, 4]), 2.5);

console.log('All test passed');
