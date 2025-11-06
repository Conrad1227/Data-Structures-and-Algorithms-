------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: River Ecosystem Simulator
PURPOSE OF PROJECT: 1st Project of CS150
VERSION or DATE: 2/17/2025
AUTHORS: Conrad Hahn
USER INSTRUCTIONS: Once you press run, follow the instructions in the console to simulate your own river ecosystem

There were a few major issues that I had to figure out along my way coding this project. The main issue I was having was when the animals would update more than once during a single cycle especially when the animal would move to the right so it was in the next spot being checked. To get around this, I implemented three specific methods in the Animal class that would keep track of if any given animal in the array was already updated and allow me to change this Boolean value depending on if it was updated in that cycle which allowed me to prevent each one from getting updated twice. Another issue I faced was getting each class to work together especially with an abstract class which was a new concept to me. Finally, using the get length method of the array java class gave me a lot of out of bounds errors if a null was placed in either the first or last slot of the array. I had to make a separate length variable that I would use instead of .length to fix this issue.

One small thing I could not figure out was when exiting the simulator after simulating any number of rivers it asked the user to exit twice before actually exiting which is a small bug but definitely noticeable when using my program. In addition to that, A lot of the unit-testing for the river class was very difficult and I could not figure out how to do it properly especially since most of the interactions happen randomly within the class. However, for some of them I was able to allow myself to add specific animals that I knew the stats of so I could test if the methods related to getting info about the animals worked properly.

I think coding this project really solidified my understanding of classes and how they interact with each other in java to create a more complex program. I think It also helped me practice my unit-testing especially in more unique ways. Also with this being the first lab, just learning the time management and process for creating such a big project in Bluej will be helpful in the future.





