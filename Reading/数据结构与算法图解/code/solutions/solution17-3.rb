#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
class TrieNode
  attr_accessor :children

  def initialize
    @children = {}
  end
end

class Trie
  def initialize
    @root = TrieNode.new
  end

  def insert(word)
    current_node = @root

    word.each_char do |char|
      # If the current node has child key with current character:
      if current_node.children[char]
        # Follow the child node:    
        current_node = current_node.children[char] 
      else
        # If the current character isn't found among
        # the current node's children, we add
        # the character as a new child node:
        new_node = TrieNode.new
        current_node.children[char] = new_node
        # Follow this new node:
        current_node = new_node
      end
    end

    # When we inserted the entire word into the trie,
    # we add a * key at the end:
    current_node.children["*"] = nil
  end

  def traverse(node=nil)
    current_node = node || @root

    current_node.children.each do |key, child_node|
      puts key
      traverse(child_node) unless key == "*"
    end
  end
end