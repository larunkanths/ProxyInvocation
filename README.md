# ProxyInvocation
Java proxy invocation example

A simple example for Java InvocationProxy class.

ProxyContainer - A factory class which has a utility method "createProxy" to create the java InvocationHandler instance for the given interface.

AbstractInvocationHandler - InvocationHandler implementation which intercepts the calls made to teh proxy object and does some pre and post processing.

GreetRequestHandler - Concrete implementation of AbstractInvocationHandler instance, which on preProcess looks for GreetLoginBanner and prints a simple banner message "Hey!!!" and on postProcess prints "Miss You!!!"


Note: The main class is Main.java
Test Output:
Inside preProcess...
Hey!!!
Exiting preProcess...
Method Invocation: Welcome Back Arun
Inside postProcess...
Exiting postProcess...

Inside preProcess...
Exiting preProcess...
Method Invocation: Bye Arun
Inside postProcess...
Miss You!!!
Exiting postProcess...

