# Cash Register
This program allows the user to input the price and quantity of the items they want to buy then gives them discount
options to apply to their order. After a calculation of one type of item the user is then asked if the have more items
and can continue while running up a total like a real cash register.

The program follows SOLID principles and implements the design pattern Strategy and Singleton.

## Other details
* Allows incorrect input
    * The program will pass the scanner to i.e setUnitPrice() method and if the input is incorrect the method will
    issue a recursive call and ask for input again. It will continue to do this until the user has entered correct
    input. To me this allows the 'cashier' to mistype and not have the cash register crash.
    
* Virtual user testing
    * Since the program's set methods take in a scanner this allows us to send in a scanner mimicking a user. To do
    this we send 'new Scanner("input")' which constructs a scanner object with a string already in its buffer. This
    may be over the top and other designs will work just as well but I thought this was an interesting functionality of
    the Java Scanner.