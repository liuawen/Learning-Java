#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def bfs(starting_vertex, search_value, visited_vertices={})
  queue = Queue.new

  visited_vertices[starting_vertex.value] = true
  queue.enqueue(starting_vertex)

  while queue.read
    current_vertex = queue.dequeue

    return current_vertex if current_vertex.value == search_value

    current_vertex.adjacent_vertices.each do |adjacent_vertex|
      if !visited_vertices[adjacent_vertex.value]
        visited_vertices[adjacent_vertex.value] = true
        queue.enqueue(adjacent_vertex)
      end
    end
  end

  return nil
end