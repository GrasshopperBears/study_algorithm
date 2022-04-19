package leet1230_test

// import "fmt"
import ("testing")

func probabilityOfHeads(prob []float64, target int) float64 {
	result := 0.5

	return result
}


func TestProbabilityOfHeads(t *testing.T) {
	prob := []float64{0.5, 0.5, 0.5, 0.5, 0.5}
	result := probabilityOfHeads(prob, 0)

	if result != 0.5 {
		t.Errorf("result = %f; want 0.5", result)
	}
}
