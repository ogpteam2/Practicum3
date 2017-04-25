package filesystem;

public class Link extends NonDir{

	private Link(Directory parent, DiskItem linked, boolean writable) {
		super(parent, linked.getName(), writable);
		// TODO Auto-generated constructor stub
	}
	
	public Link(Directory parent, File file, boolean writable) {
		this(parent, (DiskItem) file, writable);
	}
	
	public Link(Directory parent, Directory dir, boolean writable){
		this(parent, (DiskItem) dir, writable);
	}

	@Override
	public String getAbsolutePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalDiskUsage() {
		return 0;
	}

}
