/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
function selectEven(array) {
  if(array.length === 0) {
    return [];
  }

  if(array[0] % 2 === 0) {
    return [array[0]].concat(selectEven(array.slice(1)));
  }
  else {
    return selectEven(array.splice(1));
  }
}