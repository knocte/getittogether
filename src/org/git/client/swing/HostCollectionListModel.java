/*
 * Created on Mar 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.git.client.swing;

import java.util.List;

import org.git.client.Host;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.CollectionListModel;
import ca.odell.glazedlists.EventList;

/**
 * @author Greg
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HostCollectionListModel implements CollectionListModel{

    /* (non-Javadoc)
     * @see ca.odell.glazedlists.CollectionListModel#getChildren(java.lang.Object)
     */
    public List getChildren(Object arg0) {
        Host h = (Host)arg0;
        return (List)h.getSongs();
    }

}
