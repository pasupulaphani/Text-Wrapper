textwrapper
===========

Wrap text to required width

Objective
---------

Here we implement a method which takes a string of text and a column 
width and outputs the text, each line limited to the column width.

Though this sounds simple there are many edge cases which we ignore. See test cases fro more info.

For example, calling the program with the text:

    That is why with mixed emotions anthropomorphization we are notifying you that in 30 days, anthropomorphizations we will be ending our free hostname program. This change in the business will allow us to invest in our customer support teams.


with column width 20 would result in the following output:

    That is why with
    mixed emotions
    anthropomorphization
    we are notifying
    you that in 30
    days, anthropomorp-
    hizations we will
    be ending our free
    hostname program.
    This change in the
    business will allow
    us to invest in
    our customer
    support teams.


How to run it
-------------

The class is called TextWrapper.java. You can compile it at the command line with:

  javac TextWrapper.java

If the program is run with the command

  java TextWrapper input.txt 20

the program will try to read the text from the file 'input.txt' in the current
directory, and output the text in lines no longer than 20 characters.
