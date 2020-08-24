/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
class Stack {
  constructor() {
    this.data = [];
  }

  push(element) {
    this.data.push(element);
  }

  pop() {
    return this.data.pop();
  }

  read() {
    return this.data[this.data.length - 1];
  }
}

function reverse(string) {
  stack = new Stack();

  for(let i = 0; i < string.length; i++) {
    stack.push(string[i]);
  }

  let newString = "";

  while(stack.read()) {
    newString += stack.pop();
  }

  return newString;
}