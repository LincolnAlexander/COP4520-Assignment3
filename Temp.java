// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;
import java.security.IdentityScope;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Condition;

public class Temp implements Runnable
{

    // Variables for thraeds
    private String name;
    private static ConcurrentSkipListSet<Integer> globalSet = new ConcurrentSkipListSet<>();
    private static ReentrantLock lock = new ReentrantLock(true);
    private static ArrayList<Integer> diffTemps = new ArrayList<>();

    // Constructor
    public Temp(String name )
    {
      this.name = name;
      
      
    }
    // Runs accessMaze
    public void run()
    {
        while(globalSet.size() < 60)
        {
            problem2();
        }
    }
    private void addTemp()
    {
        Random r = new Random();
        int randomNum = r.nextInt(171) - 100;
        //System.out.println(randomNum);
        globalSet.add(randomNum);

    }
    private void problem2()
    {
        while(globalSet.size() <= 60)
        {
            if(lock.tryLock())
            {
                try
                {
                    System.out.println("" + name + " has acquired the lock");
                    if(globalSet.size() % 10 == 0 && globalSet.size() >= 10)
                    {
                        int x = globalSet.first();
                        int y = globalSet.last();
                        System.out.println("It has been 10 minutes, largest difference is: " + (y-x) + " y: " + y + " x: " +x);
                        diffTemps.add(y-x);

                    }
                    addTemp();
                    
                    
                    
                }
                finally
                {
                    // Release the lock when done
                    System.out.println("" + name + " has released the lock");
                    lock.unlock();
                    
                }
                
            }
            else 
            {
            // The lock is already held by another thread, so wait for a bit before trying again 
                try 
                {
                  // Make sure other threads have a chance
                  Thread.sleep(0);
                    
                } 
                catch (InterruptedException e) 
                {
                  // Handle the exception
                }
            }
        }
        return;
    }
    

    

    
    
  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Check primes.txt\n");

      // Create eight threads and start them.

      // Thread 1
      Temp m1 = new Temp("Eren Yeager");
      Thread my1 = new Thread(m1);
      
      // Thread 2
      Temp m2 = new Temp("Itachi Uchiha");
      Thread my2 = new Thread(m2);
      

      // Thread 3
      Temp m3 = new Temp("Gon Freecss");
      Thread my3 = new Thread(m3);

      // Thread 4
      Temp m4 = new Temp("Killua Zoldyck");
      Thread my4 = new Thread(m4);

      Temp m5 = new Temp("Miyamoto Musashi");
      Thread my5 = new Thread(m5);
      // Thread 6
      Temp m6 = new Temp("Thorfinn Karlsefni");
      Thread my6 = new Thread(m6);

      // Thread 7
      Temp m7 = new Temp("Ken Kaneki");
      Thread my7 = new Thread(m7);
      
      // Thread 8
      Temp m8 = new Temp("Yuji Itadori");
      Thread my8 = new Thread(m8);
      

      // Start all threads
      my1.start();
      my2.start();
      my3.start();
      my4.start();
      my5.start();
      my6.start();
      my7.start();
      my8.start();

      // After all threads finish run the rest of code, so we can time how long the program takes.
      try
      {
        my1.join();
        my2.join();
        my3.join();
        my4.join();
        my5.join();
        my6.join();
        my7.join();
        my8.join();
        
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