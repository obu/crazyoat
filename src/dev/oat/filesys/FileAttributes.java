
package dev.oat.filesys;

/**
 *
 * @author obu
 */
public class FileAttributes {
    public static final String DEFAULT_ROOT = "~/";
    public static final String DEFAULT_NAME = "default-file-name";
    public static final long DEFAULT_SIZE = 1024; 
    public static final int DEFAULT_COMPRESSION_RATIO = 2;  //2:1
    
    //Attributes
    private String name = DEFAULT_NAME;
    private String path = DEFAULT_ROOT;
    private long size   = DEFAULT_SIZE;
    private FileType type = FileType.TEXT;
    private int compressionRatio = DEFAULT_COMPRESSION_RATIO;


    //Constructor
    public FileAttributes() {}
    public FileAttributes(String name) {
        this.name = name;
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public FileType getType() {
        return type;
    }
    
    public String getPath() {
        return path;
    }

    public int getCompressionRatio() {
        return compressionRatio;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSize(long size) {
        this.size = size;
    }

    public void setType(FileType type) {
        this.type = type;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void setCompressionRatio(int compressionRatio) {
        this.compressionRatio = compressionRatio;
    }
        
    @Override
    public String toString() {
        return "Name: " + path + name + "\t" +
               "Type: " + type +        "\t" +
               "Size: " + size +        "\t" +
               "Cmpr: " + compressionRatio;
    }
    
}
