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
    private static Set<String> globalSet = new ConcurrentSkipListSet<>();
    private static List<Integer> listy = new ArrayList<>();
    private static boolean filled = false;
    private static ReentrantLock lock = new ReentrantLock(true);
    
    public void fill() {
    lock.lock();
    try {
        for (int i = 1; i <= 10; i++) {
            listy.add(i);
        }
        //Collections.shuffle(listy);
        filled = true;
    } finally {
        lock.unlock();
    }
}
    
    
    
    
    
    // Constructor
    public Present(String name )
    {
      this.name = name;
      
      
    }
    // Runs accessMaze
    public void run()
    {
        
    
        lock.lock();
        try {
            if (!filled) 
            {
                fill();
                System.out.println("Filled up" + this.name);
                
            } else 
            {
                System.out.println("Already been filled" + this.name);
            }
            problem1();
        } 
        finally {
            lock.unlock();
        }
    }

    private void problem1()
    {
        if(name.equals("Gon Freecss"))
        {
            listy.remove(1);
            System.out.println("Removed 1" + listy.toString());
        }
        else
        {
            System.out.println("List" + listy.toString());
        }
        
        while(true && globalSet.size() <= 10)
        {
            if(lock.try)
        }
        return;
    }
    

    

    
    
  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Check primes.txt");

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
      System.out.println("The program finished in " +  (end - start) + "ms\n");

    }
  }