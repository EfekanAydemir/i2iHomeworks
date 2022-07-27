package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	file, ferr := os.Open("numbers.txt")
	if ferr != nil {
		panic(ferr)
	}
	scan := bufio.NewScanner(file)

	for scan.Scan() {
		line := scan.Text()
		number, err := strconv.Atoi(line)
		if err != nil {
			panic(err)
		}
		if isPrime(number) {
			fmt.Printf("%d is prime \n", number)
		} else {
			fmt.Printf("%d is not prime \n", number)
		}

	}
}
func isPrime(number int) bool {
	if number < 2 {
		return false
	}
	for i := 2; i < number; i++ {
		if number%i == 0 {
			return false
		}
	}
	return true
}
