
package dev.oat.pattern.content;

/**
 *
 * @author obu
 */
public interface IContentGenerator {
    
    /**
     * given a size, the generator should return 
     * a string of that size in byte
     */
    public String getContent(long size);
    
}
