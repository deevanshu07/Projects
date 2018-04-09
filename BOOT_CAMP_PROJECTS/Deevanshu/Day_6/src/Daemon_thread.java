public class Daemon_thread extends Thread{
     
    public Daemon_thread(){
      setDaemon(true);
    }
    public void run(){
    	
    	System.out.println("inside run method");
        System.out.println("Is this  thread Daemon? - "+isDaemon());
    }
    public static void main(String a[]){
        Daemon_thread dt = new Daemon_thread();
        // even you can set daemon constrain here also
        // it is like dt.setDeamon(true)
        dt.start();
    }
}
