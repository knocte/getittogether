/*
 * Created on Jan 10, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.git.client.swing;

import org.git.client.Playlist;

import ca.odell.glazedlists.AbstractFilterList;
import ca.odell.glazedlists.EventList;

/**
 * @author Greg
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PlaylistFilteredList extends AbstractFilterList {

    public Playlist playlist;
    
    protected PlaylistFilteredList(EventList e) {
        super(e);
    }

    public void setPlaylist(Playlist pl) {
        playlist = pl;
        handleFilterChanged();
    }
    
    public boolean filterMatches(Object o) {
        return false;
    }

}
