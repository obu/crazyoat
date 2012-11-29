
package dev.oat.filesys;

/**
 *
 * @author obu
 */
public class FileAttributes {
    
    //Attributes
    private long size;
    private String type;
    
    //Constructor
    public FileAttributes() {}
    
    //Getters
    public long getSize() {
        return size;
    }

    public String getType() {
        return type;
    }


    //Setters
    public void setSize(long size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }
}
