# COP4520-Assignment3

## Welcome Non-Technical Manager!

## How to run program

To run my program you will need to open your command prompt and download files: Present.java & Temp.java
Navigate to the to the folder where you downloaded that file.
Compile the file by typing: javac Present.java or javac Temp.java
Execute the file by typing: java Present or java Temp

## Summary

// Problem 1
I decided to use Reentrant Locks for the first problem. The Lock makes sure no other threads can enter the function where you can pick a present. This makes sure once you enter pick a present you will be the only one choosing a present. I have a list of 500,000 integers to represent presents. Each thread will pick a present, then write a thank you note and proceed to put the present in its rightful place. This is the most efficent way, since all servants have a chance to pick a present. Instead of all servants picking up present my strategy insures that each servant has a specific present that no else can write a note for. This makes sure that the present amount is equal to the present amount.

// Problem 2
I decided to use Reentrant Locks for the second problem also. I used a concurrent skiplist to keep track of all temps. Each thread would be able to read and add a random temp to the list until we had 60 total. 60 total is to simulate 60 readings and temps which happened every minute to total for an hour. Each 10 minutes, or every 10 readings I checked for the coldest temp and hottest temp to find the largest diffence in temp as the prompt described. Each thread has a chance to read/add temp to the list and every operation is done efficiently and fairly.
