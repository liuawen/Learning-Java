/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
// We've provided the basic Node and LinkedList classes in addition to the actual solution,
// which is the printList function

class Node {

  constructor(data, nextNode=null) {
    this.data = data;
    this.nextNode = nextNode;
  }

}

class LinkedList {
  constructor(firstNode) {
    this.firstNode = firstNode;
  }

  printList() {
    let currentNode = this.firstNode;

    while (currentNode) {
      console.log(currentNode.data);
      currentNode = currentNode.nextNode;
    }
  }
}