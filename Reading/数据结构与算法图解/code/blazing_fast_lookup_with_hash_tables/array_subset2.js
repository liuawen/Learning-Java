/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
function isSubset(array1, array2) {
  let largerArray;
  let smallerArray;
  let hashTable = {};

  // Determine which array is smaller:
  if(array1.length > array2.length) {
    largerArray = array1;
    smallerArray = array2;
  } else {
    largerArray = array2;
    smallerArray = array1;
  }

  // Store all items from largerArray inside hashTable:
  for(const value of largerArray) {
    hashTable[value] = true;
  }

  // Iterate through each item in smallerArray and return false
  // if we encounter an item not inside hashTable:
  for(const value of smallerArray) {
    if(!hashTable[value]) { return false; }
  }

  // If we got this far in our code without returning false,
  // it means that all the items in the smallerArray
  // must be contained within largerArray:
  return true;
}
