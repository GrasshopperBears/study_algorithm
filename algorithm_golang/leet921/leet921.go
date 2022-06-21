package leet921

func minAddToMakeValid(s string) int {
  count := 0
  balance := 0
  
  for _, char := range s {
    if char == '(' {
      balance++
    } else if balance == 0 {
      count++
    } else {
      balance--
    }
  }
  
  if balance > 0 { count += balance }
  
  return count
}
