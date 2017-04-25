package filesystem;

public abstract class NonDir extends DiskItem{
	
	public NonDir(Directory parent, String name, boolean writable){
		super(parent,name,writable);
	}
	
	/**********************************************************
	 * delete/termination
	 **********************************************************/
	
	/**
	 * Check whether this disk item can be terminated.
	 * 
	 * @return	True if the disk item is not yet terminated, is writable and it is either a root or
	 * 			its parent directory is writable
	 * 			| if (isTerminated() || !isWritable() || (!isRoot() && !getParentDirectory().isWritable()))
	 * 			| then result == false
	 * @note	This specification can now be closed.
	 */
	
	@Override
    public boolean canBeTerminated(){
    	// no additional implementation required
		return super.canBeTerminated() && getParentDirectory().isWritable();
	}
	
	@Override
	public void terminate() throws IllegalStateException {
		if(!isTerminated()){
			super.terminate();
		}
	}
	
	@Override
	public void deleteRecursive() throws IllegalStateException{
		//no additional code required
		super.deleteRecursive();
	}
	
	/**********************************************************
     * writable
     **********************************************************/
    
    /**
	 * Set the writability of this disk item to the given writability.
	 *
	 * @param isWritable
	 *        The new writability
	 * @post  The given writability is registered as the new writability
	 *        for this disk item.
	 *        | new.isWritable() == isWritable
	 * @note  This specification is now closed
	 */
	
	@Override
	public void setWritable(boolean isWritable){
		super.setWritable(isWritable);
	}
	
}
