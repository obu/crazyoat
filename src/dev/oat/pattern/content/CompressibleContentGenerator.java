
package dev.oat.pattern.content;

/**
 *
 * @author obu
 */
public class CompressibleContentGenerator extends CContentGenerator {
    public final int DEFAULT_BLOCK_SIZE = 256;
    public final int DEFAULT_COMPRESSION_RATIO = 1;
    
    private int blockSize = DEFAULT_BLOCK_SIZE;
    private int compressionRatio = DEFAULT_COMPRESSION_RATIO;
    String encoding = UNICODE;

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(int compressionRatio) {
        this.compressionRatio = compressionRatio;
    }
    
    /*
     * This method works hard to get the stream of characters
     * we want -- to satisfy the compression ratio requirement.
     */
    String getBlock() throws Exception {
        String str="";
        int unCompressibleSize= blockSize/compressionRatio;
        String uc = getUncompressibleContent(unCompressibleSize);
        int leftover = blockSize - compressionRatio * unCompressibleSize;
        for (int i=0; i<compressionRatio; i++) {
            str += uc;
        }
        str += getUncompressibleContent(leftover);
        return str;
    }
    
    String getUncompressibleContent(int size) throws Exception {
        //Randomly lookup a table of symbols
        //e.g. ASCII table or Unicode table
        CContentGenerator cg = null;
        if (encoding == UNICODE) {
            cg = new UnicodeGenerator();
        } 
        else if (encoding == ASCII ) {
            cg = new AsciicodeGenerator();
        }
        else {
            throw new Exception("Unknown encoding:" + encoding);
        }
        return cg.getContent(size);
    }
    
    /*
     * If a string whose size is less than a whole block, 
     * use this method to truncate the tail.
     */
    String getLessBlock(int size) throws Exception {
        if (size >= blockSize) {
            throw new Exception("Trying to create a string that is " +
                    "greater than internal defined block size");
        }
        
        if (size < 0) {
            throw new Exception("string size can not be negative!");
        }
        
        if (size == 0) {
            return "";
        }
        
        return getBlock().substring(0, size-1);
    }
    
    @Override
    public String getContent(long size) {
        String content = "";
        String tail    = "";
        long numBlocks = size%blockSize;
        
        try {
        for (long i = 0; i< size%blockSize; i++) {
            content += getBlock();
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        int leftover = (int) (size - numBlocks * blockSize);
        try {
            tail = getLessBlock(leftover);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return content+tail ;
    }
    
}
