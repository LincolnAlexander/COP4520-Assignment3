// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;
import java.security.IdentityScope;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Condition;

public class Present implements Runnable{

    // Variables for thraeds
    private String name;
    private static Set<Integer> globalSet = new ConcurrentSkipListSet<>();
    private static LinkedList<Integer> listy = new LinkedList<>();
    private static ReentrantLock lock = new ReentrantLock(true);

    
    // Constructor
    public Present(String name )
    {
      this.name = name;
      
      
    }
    
     public void run()
    {
        while (globalSet.size() < 500000) 
        {
            problem1();
        }
    }
    
    // Simulates writing note, and then adds gift to ordered list.
    private void writeThankYouNote(int x)
    {
        globalSet.add(x);
        //System.out.println("" + name + " has tagged gift number: "+x + " and it has been added to the list!");
        
    }

    private void problem1()
    {
        while(globalSet.size() < 500000) {
            if(lock.tryLock())
            {
                try
                {
                    if(globalSet.size() < 500000 && !listy.isEmpty())
                    {
                       // System.out.println("" + name + " has acquired the lock");
                        
                        // Get gift from bag and then write thank you note
                        int randomNumber = listy.pop();
                        writeThankYouNote(randomNumber);
                        
                    }
                    
                }
                
                finally
                {
                    // Release the lock when done
                    //System.out.println("" + name + " has released the lock");
                    lock.unlock();
                    
                }
                // Allow another thread to acquire the lock
                Thread.yield();
            }
            else 
            {
                // The lock is already held by another thread, so wait for a bit before trying again 
                try 
                {
                  Thread.sleep(0);
                } 
                catch (InterruptedException e) 
                {
                  // Handle the exception
                }
            }
        }
    }

  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
    
      System.out.println("Check primes.txt\n");

      // Create eight threads and start them.

      // Thread 1
      Present m1 = new Present("Eren Yeager");
      Thread my1 = new Thread(m1);
      
      // Thread 2
      Present m2 = new Present("Itachi Uchiha");
      Thread my2 = new Thread(m2);
      

      // Thread 3
      Present m3 = new Present("Gon Freecss");
      Thread my3 = new Thread(m3);

      // Thread 4
      Present m4 = new Present("Killua Zoldyck");
      Thread my4 = new Thread(m4);

      
      for (int i = 1; i <= 500000; i++) 
      {
        listy.add(i);
      }
      Collections.shuffle(listy); 
      // Start all threads
      my1.start();
      my2.start();
      my3.start();
      my4.start();
      

      // After all threads finish run the rest of code, so we can time how long the program takes.
      try
      {
        my1.join();
        my2.join();
        my3.join();
        my4.join();
        
      }
      catch(Exception e)
      {
        System.out.println(e);
      }

     
      // Stop timer
      end = System.currentTimeMillis();
      
      // Create primes.txt and write neccessary info ot it.
      //System.out.println(globalSet.toString());
      System.out.println("The program finished in " +  (end - start) + "ms\n");

    }
  }