import unittest


def subarrayBitwiseORs(self, arr):
  possibleBitSet = []
  prev = set([arr[0]])

  for i in range(1, len(arr)):
    possibleBitSet += list(prev)
    prev = set(map(lambda setEl: setEl | arr[i], prev))
    prev.add(arr[i])

  possibleBitSet += list(prev)
  return len(set(possibleBitSet))


class TestStringMethods(unittest.TestCase):
  def test(self):
    self.assertEqual(subarrayBitwiseORs(None, [0]), 1)
    self.assertEqual(subarrayBitwiseORs(None, [1,1,2]), 3)
    self.assertEqual(subarrayBitwiseORs(None, [1,2,4]), 6)


if __name__ == '__main__':
  unittest.main()