#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def find_missing_letter(string)
  # Store all encountered letters in hash table:
  hash_table = {}
  string.each_char do |char|
    hash_table[char] = true
  end

  # Report first unseen letter:
  alphabet = "abcdefghijklmnopqrstuvwxyz"
  alphabet.each_char do |char|
    if !hash_table[char]
      return char
    end
  end

  return nil
end