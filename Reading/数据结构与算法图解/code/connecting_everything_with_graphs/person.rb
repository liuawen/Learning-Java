#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
class Person
  
  attr_accessor :name, :friends, :visited

  def initialize(name)
    @name = name
    @friends = []
  end

  def add_friend(friend)
    @friends << friend
  end

  def display_network
    # We keep track of every node we ever visit, so we can reset
    # their 'visited' attribute back to false after our algorithm
    # is complete:
    to_reset = [self]

    # Create the queue. It starts out containing the root vertex:
    queue = [self]
    self.visited = true

    while queue.any?
      # The current vertex is whatever is removed from the queue
      current_vertex = queue.shift
      puts current_vertex.name

      # We add all adjacent vertices of the current vertex to the queue:
      current_vertex.friends.each do |friend|
        if !friend.visited
          to_reset << friend
          queue << friend
          friend.visited = true
        end
      end
    end

    # After the algorithm, is complete, we reset each node's 'visited'
    # attribute to false:
    to_reset.each do |node|
      node.visited = false
    end
  end

end

alice = Person.new("Alice")
bob = Person.new("Bob")
candy = Person.new("Candy")
derek = Person.new("Derek")
elaine = Person.new("Elaine")
fred = Person.new("Fred")
gina = Person.new("Gina")
helen = Person.new("Helen")
irena = Person.new("Irena")

alice.add_friend(bob)
alice.add_friend(candy)
alice.add_friend(derek)
alice.add_friend(elaine)
bob.add_friend(fred)
fred.add_friend(helen)
derek.add_friend(gina)
gina.add_friend(irena)

bob.add_friend(alice)
candy.add_friend(alice)
derek.add_friend(alice)
elaine.add_friend(alice)

fred.add_friend(bob)
helen.add_friend(fred)
gina.add_friend(derek)
irena.add_friend(gina)

alice.display_network
