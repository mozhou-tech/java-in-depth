package main

import "testing"

func TestObserver(t *testing.T) {
	shirtSubject := newSubject("Nike Shirt")

	observerFirst := &customer{id: "abc@gmail.com"}
	observerSecond := &customer{id: "xyz@gmail.com"}

	shirtSubject.register(observerFirst)
	shirtSubject.register(observerSecond)

	shirtSubject.updateAvailability()
}
