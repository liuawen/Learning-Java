/***
 * Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
***/
// The solution is the max function at the bottom, but we've
// added the basic TreeNode class and the insert function
// for your convenience as well.

class TreeNode {

  constructor(val, left=null, right=null) {
    this.value = val;
    this.leftChild = left;
    this.rightChild = right;
  }

}

function insert(value, node) {
  if (value < node.value) {

    // If the left child does not exist, we want to insert
    // the value as the left child:
    if (!node.leftChild) {
      node.leftChild = new TreeNode(value);
    } else {
      insert(value, node.leftChild);
    }

  } else if (value > node.value) {

    // If the right child does not exist, we want to insert
    // the value as the right child:
    if (!node.rightChild) {
      node.rightChild = new TreeNode(value);
    } else {
      insert(value, node.rightChild);
    }
  }
}

function max(node) {
  if (node.rightChild) {
    return max(node.rightChild);
  } else {
    return node.value;
  }
}