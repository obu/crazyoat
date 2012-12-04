
package dev.oat.filesys;
import dev.oat.pattern.content.CompressibleContentGenerator;
import java.io.*;

/**
 *
 * @author obu
 */
public class FileCreator {
    private FileAttributes attr;
    
    public FileCreator(FileAttributes attr) {
        this.attr = attr;
    }
    
    public void create(){
        //To create a file, we need the name and path of the file
        //the size of the file, and the type of the file
        System.out.println(attr);      
        CompressibleContentGenerator ccg = new CompressibleContentGenerator();
        System.out.println(ccg.getContent(attr.getSize()));
    }
    
}
