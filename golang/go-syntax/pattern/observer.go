package main

import "fmt"

// 观察者
type observer interface {
	update(string)
	getID() string
}

// 具体观察者
type customer struct {
	id string
}

// consumer实现observer的方法
func (c *customer) update(subjectName string) {
	fmt.Printf("Sending email to customer %s for subject %s\n", c.id, subjectName)
}

func (c *customer) getID() string {
	return c.id
}

// 具体主体
type subject struct {
	observerList []observer
	name         string
	inStock      bool
}

func newSubject(name string) *subject {
	return &subject{
		name: name,
	}
}
func (i *subject) updateAvailability() {
	fmt.Printf("subject %s is now in stock\n", i.name)
	i.inStock = true
	i.notifyAll()
}
func (i *subject) register(o observer) {
	i.observerList = append(i.observerList, o)
}

func (i *subject) deregister(o observer) {
	i.observerList = removeFromslice(i.observerList, o)
}

func (i *subject) notifyAll() {
	for _, observer := range i.observerList {
		observer.update(i.name)
	}
}

func removeFromslice(observerList []observer, observerToRemove observer) []observer {
	observerListLength := len(observerList)
	for i, observer := range observerList {
		if observerToRemove.getID() == observer.getID() {
			observerList[observerListLength-1], observerList[i] = observerList[i], observerList[observerListLength-1]
			return observerList[:observerListLength-1]
		}
	}
	return observerList
}
