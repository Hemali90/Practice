package general;class MyRunnable implements Runnable{
	String name;
	MyRunnable(){
		
	}
	MyRunnable(String n){
		name=n;
	}
	public synchronized void starttest(){
		//this.start();
		
		Thread t=new Thread(this);
		t.start();
	}
	public synchronized void run(){
		System.out.println("Inside child()");
		synchronized(this){
			try{
		for(int i=0;i<15;i++){
			System.out.println(name+" "+i);
			Thread.sleep(1000);
		    
		}
		}catch(Exception e){
			System.out.println(e);
		}
		}	
	}
}
class MyThread extends Thread{
	String name;
	MyThread(String n){
		name=n;
	}
	public void starttest(){
		start();
	}
	public void run(){
		try{
			for(int i=0;i<15;i++){
				System.out.println(name+" "+i);
				Thread.sleep(1000);
			    
			}
			}catch(Exception e){
				System.out.println(e);
			}
	}
}
public class ThreadEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyRunnable ex=new MyRunnable("Hare");
MyRunnable ex2=new MyRunnable("Tortoise");
MyThread ex3=new MyThread("Anonymous");

ex.starttest();
ex2.starttest();
ex3.starttest();

/*try{
	System.out.println("Inside main");
	for(int i=0;i<15;i++){
		System.out.println("main"+i);
		Thread.sleep(1000);
	}
	}catch(Exception e){
		System.out.println(e);
	}*/

	}

}
