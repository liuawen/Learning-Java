#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def find_shortest_path(first_vertex, second_vertex, visited_vertices={})
  queue = Queue.new

  # As in Dijkstra's algorithm, we keep track in a table of each vertex
  # immediately preceding vertex.
  previous_vertex_table = {}

  # We employ breadth-first search:
  visited_vertices[first_vertex.value] = true
  queue.enqueue(first_vertex)

  while queue.read
    current_vertex = queue.dequeue
    current_vertex.adjacent_vertices.each do |adjacent_vertex|
      if !visited_vertices[adjacent_vertex.value]
        visited_vertices[adjacent_vertex.value] = true
        queue.enqueue(adjacent_vertex)

        # We store in the previous_vertex table the adjacent_vertex
        # as the key, and the current_vertex as the value. This 
        # indicates that the current_vertex is the immediately 
        # preceding vertex that leads to the adjacent_vertex.
        previous_vertex_table[adjacent_vertex.value] =
          current_vertex.value
      end
    end
  end

  # As in Dijkstra's algorithm, we work backwards through the
  # previous_vertex_table to build the shortest path;
  shortest_path = []
  current_vertex_value = second_vertex.value

  while current_vertex_value != first_vertex.value
    shortest_path << current_vertex_value
    current_vertex_value = previous_vertex_table[current_vertex_value]
  end
  shortest_path << first_vertex.value
  return shortest_path.reverse
end