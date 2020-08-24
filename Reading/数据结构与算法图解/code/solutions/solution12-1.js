/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
function addUntil100(array) {
  if(array.length === 0) {
    return 0;
  }

  let sumOfRemainingNumbers = addUntil100(array.slice(1));

  if(array[0] + sumOfRemainingNumbers > 100) {
    return sumOfRemainingNumbers;
  } else {
    return array[0] + sumOfRemainingNumbers;
  }
}