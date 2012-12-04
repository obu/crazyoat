
package dev.oat.pattern.content;

/**
 *
 * @author obu
 */
public interface IContentGenerator {
    
    public final String UNICODE = "unicode";
    public final String ASCII   = "ascii";
    
    /**
     * given a size, the generator should return 
     * a string of that size in byte
     */
    public String getContent(long size);
    
}
