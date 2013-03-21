/*
 * Created on Jan 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.git.client.swing;

import org.git.GITProperties;
import org.git.client.Host;
import org.git.client.Song;
import org.git.player.PlayerUtils;

import ca.odell.glazedlists.AbstractFilterList;
import ca.odell.glazedlists.EventList;

/**
 * @author Greg
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VisibleHostFilteredList extends AbstractFilterList {
    
    public VisibleHostFilteredList(EventList source) {
        super(source);
        handleFilterChanged();
    }
    
    public void visibleStatusChanged(boolean visible) {
        System.out.println("yoyo" + visible);
//        this.source.getReadWriteLock().readLock().lock();
        this.source.getReadWriteLock().writeLock().lock();
        if (visible) {
            handleFilterRelaxed();
        }
        else {
            handleFilterConstrained();
        }
//        this.source.getReadWriteLock().readLock().unlock();
        this.source.getReadWriteLock().writeLock().unlock();
    }
    
    public boolean filterMatches(Object o) {
      Song song = (Song)o;
	   if (song.getHost() != null && song.getHost().isVisible())
	       return true;
	   else
	        return false;
	   
    }
}
