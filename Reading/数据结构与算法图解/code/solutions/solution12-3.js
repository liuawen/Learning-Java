/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
function uniquePaths(rows, columns, memo={}) {
  if(rows === 1 || columns === 1) {
    return 1;
  }

  if(!memo[[rows, columns]]) {
    memo[[rows, columns]] = uniquePaths(rows - 1, columns, memo) + 
    uniquePaths(rows, columns - 1, memo);
  }

  return memo[[rows, columns]];  
}