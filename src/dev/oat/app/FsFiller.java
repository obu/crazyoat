
package dev.oat.app;

/**
 * An application to generate controllable data to fill up a file system
 * @author obu
 */
public class FsFiller extends OatApp {


    public static void main(String[] args) {
        //Task: I want to fill a file system
        // with 1 Billion files, 
        // and the total size of data is 10TB.
        
        /*
         * For the app to scale, multi-threaded and multi-node programming
         * is needed.  Each node can do a subset of the job, and they can work
         * together in an independent manner.
         */
        
        FsFiller fsf = new FsFiller(args);
        
    }
}
