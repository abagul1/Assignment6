Changes to Assignment 5 Model:

    We changed our model to better fit the parameters of the animation builder that
    was provided in the starter code. Instead of having separate classes for different
    operations, the model now only requires one operation which takes all the parameters
    of the given shape, and adjusts each one within the tick time frame.

    The abstract class for an operation was removed since there is only one operation
    that is needed. The verbose output of our model was changed to support the required
    format based on the spec of the assignment.

    The insert element method was changed to support a type of shape and its id, rather
    than passing the shape itself. The model will create a new instance of the shape based
    on the parameters given in the first motion of the shape.


