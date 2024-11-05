Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

Cafe: Overloaded sellCoffee(), and made it a default order of a hazelnut latte which I've decided is the most popular for this cafe. Then I overloaded it again and made it so when sellCoffee(n) has one parameter, its the size of the coffee and they're ordering black coffee. I also overloaded the constructor so that you can initialize a cafe without putting in all the inventory and it defaults to a set inventory. I thought cafe's should have a default inventory, and honestly I really just didn't want to enter in a bunch of numbers every time I made one unless I had a specific reason for setting their inventory a certain way.

house: Overloaded moveOut(), when it has no parameters, it moves out all the residents (if there are residents) perhaps for an emergency or there's mold in the house and everybody needs to leave. Overloaded the constructor to build a house with no parameters. Assumes the house doesn't have a dining room or elevator by default. 

Library: overloaded addTitle() to add 5 titles to a library, maybe this is a default set of books that all library's get as a first shipment, or if nobody can decide which books to add to a library, these are the ones they get. 
Overloaded isAvailable() to just print all the titles that are available at a given time, just in case somebody only wants to browse through the books currently available.
I know it isn't the best/cleanest way to sort through a hashtable, and I can imagine some edge cases causing problems, but when I figured out a way to more or less sort through it and only print the titles associated with "true" using the string parsing stuff from A3 the chatbot, I was so excited. Actually was kicking my feet looking at my frankensteins monster of a method.

At first I was really confused how to overload my constructors, but I just kind of copied what was done with the building constructor and tweaked it a bit and I think it works fine? Honestly I just kept googling things about overloading and retrying until things seemed like they worked mostly fine.