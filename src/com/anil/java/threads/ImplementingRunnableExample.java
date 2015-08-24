/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.threads;

/**
 *
 * @author Anil Allewar
 */
public class ImplementingRunnableExample implements Runnable{
	
	private String threadName=null;
	
	private static int threadCount=1;
	
	ImplementingRunnableExample (String threadName){
		this.threadName=threadName;
	}

	public void run(){
		try{
			for (int i=0;i<15;i++){
				System.out.println(Thread.currentThread().getName()+ " : Started the thread: "+threadName+ " :"+i);
				//Thread.sleep(500);
			}
		}catch (Exception ie){
			System.out.println("Interrupted exception");
		}
                //This throws java.lang.IllegalMonitorStateException: current thread not owner
                //if some other thread has monitor of s2 when this method is called
                this.testSynchronization();
		/*
		Thread t = new Thread(new ImplementingRunnableExample(String.valueOf(threadCount++)));
		t.start();
		try{
			t.join();
		}catch (InterruptedException ie){
			System.out.println("Interrupted exception in recursive thread");
		}
		*/
	}
        
        /**
         * This method checks to see if IllegalMonitorStateException is throws.
         * This will happen if s2's lock is not available to the thread while execution
         */
        public void testSynchronization(){
            String s1="Anil";
            String s2="Allewar";
            synchronized(s1){
                s1=s1 + " synchronized";
                try{
                    s1.wait(10);
                }catch(InterruptedException ie){
                    System.out.println(Thread.currentThread().getName() + ":In s1 try block wait exception " + ie.getMessage());
                }
                s2=21 + " synchronized";
                try{
                    s2.wait(10);
                }catch(InterruptedException ie){
                    System.out.println(Thread.currentThread().getName() + ":In s2 try block wait exception " + ie.getMessage());
                }
            }
        }
        
	static public void main(String[] args) {
		//The Runnable class 
		Thread t1 = new Thread(new ImplementingRunnableExample("first"), "firstName");
		//t1.run();
		t1.start();
		Thread t2 = new Thread(new ImplementingRunnableExample("second"));
		t2.setName("second");
		t2.start();
		Thread t3 = new Thread(new ImplementingRunnableExample("third"));
		t3.start();
		
		try{
			t1.join();
			t2.join(); //The current thread waits for 200ms and then becomes runnable again
			t3.join();
		}catch (InterruptedException ie){
			System.out.println("Got exception while waitingn to join");
		}
		
		System.out.println();
		System.out.println("Not having a join() method would mean that this statement will be executed before the previously launched threads run...\n" + 
							"When the join() method is called it will cause the currently executing thread(the main thread) to wait till the thread on which join is called finishes..");	
		System.out.println();
                
                System.out.println("Calling the testSynchronization() method...");
                System.out.println("This might throw a IllegalMonitorStateException if s2 lock is not obtained by the thread prior to synchronized block entry");
                ImplementingRunnableExample imrunExmple = new ImplementingRunnableExample("TestSynchronization");
                System.out.println();
                
		System.out.println("Starting a thread again after it has already finished execution once will give the following runtime exception\n" + 
				"Exception in thread \"main\" java.lang.IllegalThreadStateException");
		//Starting a thread again after it has already finished execution once will give the following runtime exception
		//Exception in thread "main" java.lang.IllegalThreadStateException
		t1.start();
	}
}

