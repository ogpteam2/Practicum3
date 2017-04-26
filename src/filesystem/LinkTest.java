package filesystem;

import filesystem.exception.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LinkTest {
	
	private static Link link1, link2, link3,link4,link5,link6;
	private static Directory dir1, dir2, dir3,dir4;
	private static File file1,file2;
	
	@BeforeClass public static void setUpBeforeClass(){
		dir1 = new Directory("rootDir",true);
		dir2 = new Directory(dir1,"subDir1",true);
		dir3 = new Directory(dir1,"subDir2",true);
		dir4 = new Directory(dir3,"subsubdir",false);
		
		file1 = new File(dir3,"file1",Type.PDF,100,true);
		file2 = new File(dir1,"file2",Type.PDF,100,true);
		
		link1 = new Link(dir1,file1);
		link2 = new Link(dir2,file1);
		link3 = new Link(dir3,file1);
		link4 = new Link(dir1,dir2);
		link5 = new Link(dir1,dir3);
		link6 = new Link(dir1,dir1);
	}
	 
	  
	@Test public final void testlink1(){
		 assertEquals(link1.getLinked(), file1);
	 }
	 
	 @Test 
	 public final void testlink2(){
		 assertEquals(link2.getLinked(),file1);
	 }
	 
	 @Test 
	 public final void testlink3(){
		 assertEquals(link3.getLinked(),file1);
	 }
	 
	 @Test 
	 public final void testlink4(){
		 assertEquals(link4.getLinked(),dir2);
	 }
	 
	 @Test 
	 public final void testlink5(){
		 assertEquals(link5.getLinked(),dir3);
	 }
	 
	 @Test 
	 public final void testlink6(){
		 assertEquals(link6.getLinked(),dir1);
	 }
	 
	 @Test 
	 public final void testNamechangelink1(){
		link1.changeName("blablabla");
		assertEquals(link1.getName(),"blablabla");
		assertEquals(link1.getLinked(),file1);
	 }
	 
	 @Test 
	 public final void testMovelink1(){
		link1.move(dir2);
		assertEquals(link1.getParentDirectory(),dir2);
		assertEquals(link1.getLinked(),file1);
	 }
	 
	 @Test(expected = DiskItemNotWritableException.class) 
	 public final void testMovelink1Two(){
		link1.move(dir4);
		fail("Exception expected");	
	 }
	 
	 @Test(expected = NullPointerException.class) 
	 public final void testlink1Valid(){
		 Link link7 = new Link(dir1,null);
		 fail("Exception expected");
	 }
	 
	 @Test
	 public final void testlink1Changefile1(){
		 file1.changeName("blablabla");
		 System.out.println(file1.getName());
		 System.out.println(link1.getLinked().getName());
		 assertEquals(link1.getLinked().getName(),file1.getName());
	 }
	 
	 
}	