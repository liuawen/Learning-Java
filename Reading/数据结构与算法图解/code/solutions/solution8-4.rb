#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def first_non_duplicate(string)
  hash_table = {}

  string.each_char do |char|
    if hash_table[char]
      hash_table[char] += 1
    else
      hash_table[char] = 1
    end
  end

  string.each_char do |char|
    if hash_table[char] == 1
      return char
    end
  end

  return nil
end