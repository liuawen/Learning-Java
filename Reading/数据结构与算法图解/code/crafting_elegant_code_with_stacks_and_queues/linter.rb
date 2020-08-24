#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
class Linter

  def initialize
    # We use a simple array to serve as our stack:
    @stack = Stack.new
  end

  def lint(text)
    # We start a loop which reads each character in our text:
    text.each_char do |char|

      # If the character is an opening brace:
      if is_opening_brace?(char)

        # We push it onto the stack:
        @stack.push(char)

      # If the character is a closing brace:
      elsif is_closing_brace?(char)

        # Pop from stack:
        popped_opening_brace = @stack.pop

        # If the stack was empty, so what we popped was nil,
        # it means that an opening brace is missing:
        if !popped_opening_brace
          return "#{char} doesn't have opening brace"
        end

        # If the popped opening brace doesn't match the 
        # current closing brace, we produce an error:
        if is_not_a_match(popped_opening_brace, char)
          return "#{char} has mismatched opening brace"
        end
      end
    end

    # If we get to the end of line, and the stack isn't empty:
    if @stack.read

      # It means we have an opening brace without a
      # corresponding closing brace, so we produce an error:
      return "#{@stack.read} does not have closing brace"
    end

    # Return true if line has no errors:
    return true
  end

  private

  def is_opening_brace?(char)
    ["(", "[", "{"].include?(char)
  end

  def is_closing_brace?(char)
    [")", "]", "}"].include?(char)
  end

  def is_not_a_match(opening_brace, closing_brace)
    closing_brace != {"(" => ")", "[" => "]", "{" => "}"}[opening_brace]
  end
end