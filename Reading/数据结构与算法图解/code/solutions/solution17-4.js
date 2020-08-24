/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
autocorrect(word) {
  let currentNode = this.root;
  // Keep track of how much of the user's word we've found 
  // in the trie so far. We'll need to concatenate this with
  // the best suffix we can find in the trie.
  let wordFoundSoFar = "";

  for (const char of word) {
    // If the current node has child key with current character:
    if (currentNode.children[char]) {
      wordFoundSoFar += char;
      // Follow the child node:    
      currentNode = currentNode.children[char];
    } else {
      // If the current character isn't found among
      // the current node's children, collect all the suffixes that 
      // descend from the current node and get the first one.
      // We concatenate the suffix with the prefix we've found so
      // far to suggest the word the user meant to type in:
      return wordFoundSoFar + this.collectAllWords(currentNode)[0];
    }
  }
  // If the user's word is found in the trie:
  return word;
}