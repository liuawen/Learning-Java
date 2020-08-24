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

  // Determine which array is smaller:
  if(array1.length > array2.length) {
    largerArray = array1;
    smallerArray = array2;
  } else {
    largerArray = array2;
    smallerArray = array1;
  }

  // Iterate through smaller array:
  for(let i = 0; i < smallerArray.length; i++) {

    // Assume temporarily that the current value from
    // smaller array is not found in larger array:
    let foundMatch = false;

    // For each value in smaller array, iterate through
    // larger array:
    for(let j = 0; j < largerArray.length; j++) {

      // If the two values are equal, it means the current
      // value in smaller array is present in the larger array:
      if(smallerArray[i] === largerArray[j]) {
        foundMatch = true;
        break;
      }
    }

    // If the current value in smaller array doesn't exist
    // in larger array, return false:
    if(foundMatch === false) { return false; }
  }

  // If we get to the end of the loops, it means that all
  // values from smaller array are present in larger array:
  return true;
}