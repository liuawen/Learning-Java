#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def greatest_product(array)
  greatest_number = -Float::INFINITY
  second_to_greatest_number = -Float::INFINITY

  lowest_number = Float::INFINITY
  second_to_lowest_number = Float::INFINITY

  array.each do |number|
    if number >= greatest_number
      second_to_greatest_number = greatest_number
      greatest_number = number
    elsif number > second_to_greatest_number
      second_to_greatest_number = number
    end

    if number <= lowest_number
      second_to_lowest_number = lowest_number
      lowest_number = number
    elsif number > lowest_number &&
      number < second_to_lowest_number
      second_to_lowest_number = number
    end
  end

  greatest_product_from_two_highest =
    greatest_number * second_to_greatest_number

  greatest_product_from_two_lowest =
    lowest_number * second_to_lowest_number

  if greatest_product_from_two_highest > greatest_product_from_two_lowest
    return greatest_product_from_two_highest
  else
    return greatest_product_from_two_lowest
  end
end
