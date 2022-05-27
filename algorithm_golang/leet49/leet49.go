package leet49_test

import (
	"fmt"
)

func count(str *string) map[rune]int {
	result := map[rune]int{}
	for _, char := range *str {
		if _, ok := result[char]; ok {
			result[char]++
		} else {
			result[char] = 1
		}
	}
	return result
}

func mapToStr(countMap *map[rune]int) string {
	result := ""
	// a = 97
	for i := 97; i < 123; i++ {
		result += "#"
		if count, ok := (*countMap)[rune(i)]; ok {
			result += string(count)
		} else {
			result += string(0)
		} 
	}

	return result
}

func groupAnagrams(strs []string) [][]string {
	countMaps := map[string][]string{}

	for _, str := range strs {
		countMap := count(&str)
		countStr := mapToStr(&countMap)
		if _, ok := countMaps[countStr]; ok {
			countMaps[countStr] = append(countMaps[countStr], str)
		} else {
			countMaps[countStr] = []string{str}
		}
	}

	result := [][]string{}
	for _, v := range countMaps {
		result = append(result, v)
	}
	return result
}

func Test() {
	result := groupAnagrams([]string{"eat","tea","tan","ate","nat","bat"})
	fmt.Println(result)
}
