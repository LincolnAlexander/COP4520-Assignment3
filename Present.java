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

    private static ReentrantLock lock = new ReentrantLock(true);
    
    
    
    // Constructor
    public Present(String name )
    {
      this.name = name;
      
      
    }
    // Runs accessMaze
    public void run()
    {
      
      problem1();
      
    }

    private void problem1()
    {
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
      Present m1 = new Locky("Eren Yeager");
      Thread my1 = new Thread(m1);
      
      // Thread 2
      Present m2 = new Locky("Itachi Uchiha");
      Thread my2 = new Thread(m2);
      

      // Thread 3
      Present m3 = new Locky("Gon Freecss");
      Thread my3 = new Thread(m3);

      // Thread 4
      Present m4 = new Locky("Killua Zoldyck");
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