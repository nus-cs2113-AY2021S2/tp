### [Implementation] : Recording Completed Deliveries

Most deliverymen would want an overall outlook of completed deliveries, so that they would 
be able to see and judge exactly how much they have earned over the course of their delivery spree.

The primary class involved in executing this function is `Deliveryman`. 

Whenever a `Delivery` is marked as completed, the `Ui` class will call
the `completeDelivery()` method which accepts a delivery number (the index of the 
delivery), and a Deliveryman object.

The `completeDelivery()` in Delivery then subsequently calls another `completeDelivery` method, a
instance method of the `Deliveryman` class. This method will add the completed delivery to a
list of completed deliveries (`records`) attributed to the deliveryman.

When the `record` command is given, the `showRecords()` method is called which accepts the
`Deliveryman` object. This method will simply print a formatted list of all the items in `records`

This sequence of program flow was chosen because it would still allow for the proper abstraction of the classes.
In this particular case, the `Ui` class is only handling the User Interface aspect of code execution. Similarly,
the `Delivery` class is not especially involved in the `Deliveryman`'s `records`. The code directly changing the deliveryman's
`records` is present only in the `Deliveryman` class.

The general interaction between the abovementioned classes are briefly illustrated in the sequence diagram
shown below. Note the two different completeDelivery() methods that are called here. Despite having
similar names, their impacts are felt by different classes and maintains the abstraction between classes

![Retrieve Records](RetrieveRecords.png#retrieverecordsSD "Retrieving Records Sequence Diagram")




