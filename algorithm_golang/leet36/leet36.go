package leet36

func isValidSudoku(board [][]byte) bool {
	EMPTY_BYTE := byte('.')
	boxSet := make([]map[byte]bool, 9)
	rowSet := make([]map[byte]bool, 9)
	colSet := make([]map[byte]bool, 9)

	for row, rowNums := range board {
		for col, val := range rowNums {
			if val == EMPTY_BYTE { continue }
			if _, exist := rowSet[row][val]; exist {
				return false
			} else {
				rowSet[row][val] = true
			}
			if _, exist := colSet[col][val]; exist {
				return false
			} else {
				colSet[col][val] = true
			}
			boxIdx := 3 * (row / 3) + col / 3
			if _, exist := boxSet[boxIdx][val]; exist {
				return false
			} else {
				boxSet[boxIdx][val] = true
			}
		}
	}

	return true
}
