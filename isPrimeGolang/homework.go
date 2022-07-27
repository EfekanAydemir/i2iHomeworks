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
		counter := 0
		line := scan.Text()
		number, err := strconv.Atoi(line)
		if err != nil {
			panic(err)
		}
		for i := 2; i < number; i++ {
			if number%i == 0 {
				counter++
			}
		}
		if counter < 1 && number >= 2 {
			fmt.Printf("%d is prime \n", number)
		} else {
			fmt.Printf("%d is not prime \n", number)
		}

	}
}
