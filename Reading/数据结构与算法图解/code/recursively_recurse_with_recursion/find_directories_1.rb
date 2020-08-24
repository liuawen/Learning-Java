#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def find_directories(directory)
  # Inspect each file within the directory. Some of these "files" may
  # actually be subdirectories.
  Dir.foreach(directory) do |filename|

    # If the current file is itself a subdirectory:
    if File.directory?("#{directory}/#{filename}") && 
    filename != "." && filename != ".."

      # Print out the full path name:
      puts "#{directory}/#{filename}"
    end
  end
end