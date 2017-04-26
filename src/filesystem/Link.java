package filesystem;
import filesystem.exception.*;
import be.kuleuven.cs.som.annotate.*;

/**
* A class of links that link to files or directories
*       
* @author 	 Robbe Louage, Elias Storme
* @version	 1.0 - 2016  
*/
public class Link extends NonDir {
	
	/*********************************************************************************
	 *  constructor                                                                  * 
	 *********************************************************************************/
	

	/**
	 * Initialize a new link with given  parent directory and linked item.
	 * 
	 * @param parent
	 * 		  The directory in which the link is stored.
	 * @param linked
	 *        The file or directory to which to link links.
	 * @effect The name of the link is set to the name of the linked item cocatenated with "Link"
	 * 		   |  super(parent, linked.getName() + "Link", true)
	 * @effect the linked item is set to the given linked item
	 * 		   | setLinked(linked)
	 * 
	 */
	public Link(Directory parent, DiskItem linked) {
		super(parent, linked.getName() + "Link", true);
		setLinked(linked);
	}
	
	/*********************************************************************************
	 *  linked                                                                       * 
	 *********************************************************************************/
	
	/**
	 * sets linked to given linked item
	 * 
	 * @param linked
	 *        the item to which to link links
	 * @throws IllegalArgumentException
	 * 		   The parent doesn't exists
	 */
	private void setLinked(DiskItem linked) throws NullPointerException{
		if (linked == null){
			throw new NullPointerException();
		}
		else{
			this.linked = linked;
		}
	}
	
	/**
	 * return the linked item
	 * @return the linked item
	 */
	@Basic
	public DiskItem getLinked(){
		return this.linked;
	}
	
	/**
	 * the item to which the link links
	 */
	private DiskItem linked;
	
	/*********************************************************************************
	 * isValid                                                                       * 
	 *********************************************************************************/
	
	/**
	 * Checks if the links to an existing item.
	 * @return True if it links to an existing item, false otherwise.
	 */
	public boolean IsValid(){
		if (getLinked() == null){
			return false;
		}
		else {
			return true;}
		}
	
	/*************************************************************************************
	 *  useless methods or methods that need override                                    *
	 ************************************************************************************/
	/**
	 * Because a link is always writable, this always return true
	 * @return true
	 */
	@Override
	public boolean isWritable() {
		return true;
	}
	
	
    /**
     * Generates the full name of the link assembled 
     * 
     * @return The full name of the link
     */
	@Override
	public String getAbsolutePath(){
	    	String path = "";
	    	path += this.getParentDirectory().getAbsolutePath();
	    	path += "/" + this.getName();
			return path;
		}
	
	/**
	 * A link doesn't has a size
	 * 
	 * @return 0
	 */
	@Override
	public int getTotalDiskUsage(){
		return 0;
	}
	
	
}
