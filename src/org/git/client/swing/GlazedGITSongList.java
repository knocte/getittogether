/*
 * Created on Sep 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.git.client.swing;

import java.util.Collection;

import org.git.client.Song;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.EventSelectionModel;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TextFilterList;

/**
 * @author Greg
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GlazedGITSongList implements ListEventListener{
        
    
    
    // Base list:
    public EventList songList;
    
    
    // Browser EventLists:
    protected VisibleHostFilteredList visibleHostList;
    protected SortedList songSortedList;
    protected TextFilterList songSearchedList;

    // JTable stuff?
    protected EventTableModel songTableModel;
    protected EventSelectionModel songSelectionModel;
    
    public GlazedGITSongList(String s) {
        songList = new BasicEventList();
        initialize();
    }
    
    public void initialize() {
        
        // EventLists for the main, browser view:
        visibleHostList = new VisibleHostFilteredList(songList);
        songSortedList = new SortedList(visibleHostList);
        songSearchedList = new TextFilterList(songSortedList);
    
        songSearchedList.addListEventListener(this);
    }
    
    public void addSongs(Collection c) {
        songList.addAll(c);
    }
    
    public void removeSongs(Collection c) {
        songList.removeAll(c);
    }
    
    public void removeAll() {
        songList.clear();
    }
    
    public void searchText(String text) {
//		try {
//			search_field.setText(text);
//			model.search(text);
//			model.fireTableDataChanged();
//			sorter.fireTableDataChanged();
//			totalsLabel.setText(model.getTotals());
//			last_search = text;
//		} catch (Exception f) {
//			f.printStackTrace();
//		}

	}    

    public int indexOf(Song s) {
        return songSearchedList.indexOf(s);
    }
    
    public Song getSongAt(int row) {
        return (Song)songSearchedList.get(row);
    }

    public Collection getSongs() {
        return songSearchedList;
    }
    
    public void hostVisibleStatusChanged(boolean visible) {
        visibleHostList.visibleStatusChanged(visible);
    }
    
	public void listChanged(ListEvent arg0) {
	}
     
    public class GlazedSongTableFormat implements TableFormat {

        
        public int getColumnCount() {
            return 6;
        }

        
        public String getColumnName(int col) {
            switch (col) {
            	case 0:
            	    return "Tr.";
            	case 1:
            	    return "Artist";
            	case 2:
            	    return "Album";
            	case 3:
            	    return "Title";
            	case 4:
            	    return "Length";
            	case 5:
            	    return "Size";
            }
            return "";
        }

       
        public Object getColumnValue(Object o, int col) {
            if (o == null) return null;
            Song s = (Song)o;
            switch (col) {
            	case 0:
            	    return new Integer(s.getTrack());
            	case 1:
            	    return s.getArtist();
            	case 2:
            	    return s.getAlbum();
            	case 3:
            	    return s.getName();
            	case 4:
            	    return new Integer(s.getTime());
            	case 5:
            	    return new Integer(s.getSize());
            }
            return null;
        }
        
        
    }

    
}
