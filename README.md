# The Exhausted Waiter Problem
The Foo Bar and Restaurant is unfortunately under-staffed. In fact, they can only 
afford to have one waiter and he is forced to work double-shifts in order to keep the 
place open.  The restaurant has only a single counter with 15 seats.
  Business at the restaurant is somewhat variable. There are times when there is a 
line out the door waiting to get one of the limited available seats. At other times of 
the day, there are no customers and the waiter takes the opportunity to try to get a 
little bit of sleep.
 
 If a customer arrives at the empty restaurant and finds the waiter sleeping then he 
wakes him up and the service begins. If the customer arrives and the waiter is 
active, then the customer will take an available seat (if one exists) and wait her turn 
for service. Finally, if the customer arrives and there are no available seats then she 
must wait outside the door for someone to exit and thus free up a counter seat.  
When the order is delivered it is quickly devoured and the customer leaves their 
payment and exits the establishment.
 
 The waiter provides service (takes an order and serves up the request) in the order 
that people are seated. If the restaurant is empty, then the waiter simply sits down 
and sleeps until awakened by an arriving customer. Being a strange little 
establishment, the waiter only waits on one customer at a time. This is because he is 
also the cook. So, if the waiter/cook is busy then only one customer is actively being 
serviced and the others (in chairs or possibly outside) are awaiting their turn.


Solution: A Semaphore-based Java solution will be implemented for this problem. The Java program will consist of two threaded classes – Customer and 
Waiter.  The programmed solution will avoid deadlock and starvation and 
livelock.
 The main program will create a single Waiter object/thread. It will also 
initially create 50 Customer objects/threads which will attempt to get lunch 
during the busy period. These 50 threaded objects will be placed into a 
ThreadGroup. Another 50 Customer objects/threads should be created and placed 
into a second ThreadGroup for use in a slow period simulation. Anyone who shows up with the restaurant full 
must wait outside. As customers leave those outside may enter one per person 
leaving. 
