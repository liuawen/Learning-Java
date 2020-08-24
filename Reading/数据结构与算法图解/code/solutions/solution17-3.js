/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
// The solution is the 'traverse' function at the bottom, but for your 
// convenience, we supplied the basic classes and other functions as well.

class TrieNode {

  constructor() {
    this.children = {};
  }

}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  insert(word) {
    let currentNode = this.root;

    for (const char of word) {
      if(currentNode.children[char]) {
        currentNode = currentNode.children[char];
      } else {
        let newNode = new TrieNode();
        currentNode.children[char] = newNode;

        currentNode = newNode;
      }
    } 

    currentNode.children["*"] = null;
  }

  collectAllWords(node=null, word="", words=[]) {
    let currentNode = node || this.root;

    for (let [key, childNode] of Object.entries(currentNode.children)) {
      if (key === "*") {
        words.push(word);
      } else {
        this.collectAllWords(childNode, word + key, words)
      }
    }
    return words;
  }

  traverse(node=null) {
    let currentNode = node || this.root;

    for (let [key, childNode] of Object.entries(currentNode.children)) {
      console.log(key);
      if (key !== "*") {
        this.traverse(childNode);
      }
    }
  }
}