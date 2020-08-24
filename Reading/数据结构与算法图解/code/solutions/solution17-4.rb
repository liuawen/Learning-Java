#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def autocorrect(word)
  current_node = @root
  # Keep track of how much of the user's word we've found 
  # in the trie so far. We'll need to concatenate this with
  # the best suffix we can find in the trie.
  word_found_so_far = ""

  word.each_char do |char|
    # If the current node has child key with current character:
    if current_node.children[char] 
      word_found_so_far += char 
      # Follow the child node:    
      current_node = current_node.children[char]
    else
      # If the current character isn't found among
      # the current node's children, collect all the suffixes that 
      # descend from the current node and get the first one.
      # We concatenate the suffix with the prefix we've found so
      # far to suggest the word the user meant to type in:
      return word_found_so_far + collect_all_words(current_node)[0]
    end
  end

  # If the user's word is found in the trie:
  return word
end