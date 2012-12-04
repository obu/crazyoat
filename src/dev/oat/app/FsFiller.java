
package dev.oat.app;
import dev.oat.filesys.*;
import dev.oat.distribution.NormalDistribution;

/**
 * An application to generate controllable data to fill up a file system
 * @author obu
 */
public class FsFiller extends OatApp {
    //pattern tools
    RandomPathFinder pathFinder = new RandomPathFinder();
    NormalDistribution normalDist = new NormalDistribution();
    
    //private members
    private long   totalSize;
    private long   fileCount;
    private String dataRoot;

    public FsFiller(String[] args) {
        super(args);
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public void setFileCount(long fileCount) {
        this.fileCount = fileCount;
    }

    public void setDataRoot(String dataRoot) {
        this.dataRoot = dataRoot;
    }

    private void createFile(long id) {
        
        String fileName = "file"+id;
        String path     = pathFinder.getPath(id);
        long   size     = (long)normalDist.getValue(id);
        
        FileAttributes fattr = new FileAttributes();
        fattr.setName(fileName);
        fattr.setSize(size);
        fattr.setPath(path);
        
        new FileCreator(fattr).create();
    }
    
    public void emitData() {
       for (long i = 0; i< fileCount; i++) {
           createFile(i);
       }
    }
    
    
    
    public static void main(String[] args) {
        //Task: I want to fill a file system
        // with 1 Billion files, 
        // and the total size of data is 10TB.
        
        /*
         * For the app to scale, multi-threaded and multi-node programming
         * is needed.  Each node can do a subset of the job, and they can work
         * together in an independent manner.
         * 
         * command lines:  config=conf_file 
         * 
         * dataRoot=xxx
         * fileCount=xxx
         * totalSize=xxxMB|GB|TB
         * 
         * 
         */
        
        FsFiller fsf = new FsFiller(args);
        
        long totalSize = 1024*1024*1024*1024;  //1TB
        //long   fileCount = 1000*1000*500;
        long fileCount = 10;
        String dataRoot  = "Z:\\dataroot";
        
        fsf.setTotalSize(totalSize);
        fsf.setFileCount(fileCount);
        fsf.setDataRoot(dataRoot);
        fsf.emitData();
    }
}
