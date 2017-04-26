package filesystem;

public class testjes {
	
	public static void main(String[] args){
		
		
		Directory dir1 = new Directory("dir1",true);
		File file1 = new File(dir1,"file1",Type.PDF,100,true);
		Link link1 = new Link(dir1,file1);
		
		if(file1.getClass().getName()=="filesystem.File"){
			System.out.println("JA");
			System.out.println(link1.getLinked().equals(file1));
			System.out.println(link1.getLinked().getAbsolutePath());
		}
		
		String test = "test";
		String test2 = test;
		test2 = "hallo";
		System.out.println(test);
		System.out.println(test2);
		
		
	}
}


