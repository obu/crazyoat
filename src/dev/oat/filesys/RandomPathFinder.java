
package dev.oat.filesys;

import dev.oat.pattern.tree.RandomPathTree;

/**
 *
 * @author obu
 */
public class RandomPathFinder {
    RandomPathTree tree = new RandomPathTree();
    
    public RandomPathFinder() {
        //do configuration of the tree
    }
    public String getPath(long id) {
        return tree.getPath(id);
    }
}
