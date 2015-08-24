package com.anil.java.threads;

public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create a common item that would be passed to the Producer and Consumer
		Item item = new Item();
		Producer p1 = new Producer(item, "P1");
		Consumer c1 = new Consumer(item, "C1");
		
		//Create thread that would run the target consumer and producer
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		//Start the thread and observe the output. Note we are starting the consumet thread
		//first and then the producer thread
		t2.start();
		t1.start();
	}

}

class Item{
	private int contents=0;
	private boolean available = false;
	
	//synchonize the get and set methods
	/**
	 * Get the data once it becomes available and wait till it is available
	 */
	public synchronized int get(){
		//If the content is not available then wait
		
		while(available == false){
			try{
				this.wait();
			}catch(InterruptedException ie){
				System.out.println("Got interrupted exception while waiting for contents: " + ie.getMessage());
			}
		}
		//Set available to false indicating that the contents have been consumed
		this.available = false;
		//Notify all the waiting threads that are waiting for locks on this object
		//Note that the lock is NOT released till the time the Thread completes execution
		//of this synchronized method
		this.notifyAll();
		//retun contents
		return contents;
	}
	
	public synchronized void put(int contents) {
		//If the content is already available, then wait till the content is consumed
		while (this.available == true){
			try{
				this.wait();
			}catch(InterruptedException ie){
				System.out.println("Got interrupted exception while waiting for contents: " + ie.getMessage());
			}
		}
		//set the content
		this.contents = contents;
		//Set available to true indicating that content will be populated once control
		//moves out of this method
		this.available = true;
		//Notify all waiting thread that need lock on this object
		this.notifyAll();
	}
}

class Producer implements Runnable{
	Item item=null;
	String name = null;
	
	//The constructor initializes the null objects
	Producer(Item item, String name){
		this.item = item;
		this.name = name;
	}
	
	//Implement the run method
	public void run(){
		for(int i =1; i<=10; i++){
			this.item.put(i);
			System.out.println("Producer " + this.name + " put the content: " + i);
			try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            	System.out.println("Got interrupted ");
            }

		}
	}
}

class Consumer implements Runnable{
	Item item=null;
	String name = null;
	
	//The constructor initializes the null objects
	Consumer(Item item, String name){
		this.item = item;
		this.name = name;
	}
	
	//Implement the run method
	public void run(){
		int value;
		for(int i =1; i<=10; i++){
			value = this.item.get();
			System.out.println("Consumer " + this.name + " GOT the content: " + value);
		}
	}
}
