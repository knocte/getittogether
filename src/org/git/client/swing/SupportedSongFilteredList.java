/*
 * Created on Mar 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.git.client.swing;

import org.git.GITProperties;

import ca.odell.glazedlists.AbstractFilterList;
import ca.odell.glazedlists.EventList;

import org.git.client.Song;

/**
 * @author Greg
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SupportedSongFilteredList extends AbstractFilterList{

    public SupportedSongFilteredList(EventList source) {
        super(source);
        handleFilterChanged();
    }
    
    public boolean filterMatches(Object element) {
        Song s = (Song)element;
        if (!GITProperties.hideUnsupportedSongs || GetItTogether.player.supportsSong(s))
            return true;
        else
            return false;
    }

}
