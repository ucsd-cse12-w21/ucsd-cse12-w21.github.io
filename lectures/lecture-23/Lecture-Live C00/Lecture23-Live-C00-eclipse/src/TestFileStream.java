import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
import java.io.*;

public class TestFileStream {

	@Test
	public void testFileStreamBigBuffer() throws IOException {
		
		String filename = "test1.txt";
		
		OutputDataStream<Integer> fileStream = 
				new FileOutputIntegerStream(filename, 10);
		
		fileStream.write(1);
		fileStream.write(2);
		fileStream.write(3);
		
		fileStream.close();
		
		Scanner sc = new Scanner(new File(filename));
		assertEquals("1", sc.next());
		assertEquals("2", sc.next());
		assertEquals("3", sc.next());
		sc.close();
	}
	
	@Test
	public void testFileStreamSmallBuffer() throws IOException {
		
		String filename = "test2.txt";
		
		OutputDataStream<Integer> fileStream = 
				new FileOutputIntegerStream(filename, 2);
		
		fileStream.write(1);
		fileStream.write(2);
		fileStream.write(3);
		
		fileStream.close();
		
		Scanner sc = new Scanner(new File(filename));
		assertEquals("1", sc.next());
		assertEquals("2", sc.next());
		assertEquals("3", sc.next());
		sc.close();
	}
	
	@Test
	public void testFileInputSmall() throws IOException {
		String filename = "test3.txt";
		
		OutputDataStream<Integer> outputStream = 
				new FileOutputIntegerStream(filename, 10);
		
		for (int i = 0; i < 3; i++) {
			outputStream.write(i);
		}
		
		//must close file
		outputStream.close();
		
		InputDataStream<Integer> inputStream = 
				new FileInputIntegerStream(filename, 2);
		
		assertEquals(new Integer(0), inputStream.next());
		assertEquals(new Integer(1), inputStream.next());
		assertEquals(new Integer(2), inputStream.next());
		assertEquals(null, inputStream.next());
	}
	
	@Test
	public void testFileInputComplete() throws IOException {
		String filename = "test4.txt";
		
		OutputDataStream<Integer> outputStream = 
				new FileOutputIntegerStream(filename, 100);
		
		for (int i = 0; i < 100; i++) {
			outputStream.write(i);
		}
		
		//must close file
		outputStream.close();
		
		InputDataStream<Integer> inputStream = 
				new FileInputIntegerStream(filename, 2);
		
		int i = 0;
		while (inputStream.hasNext()) {
			assertEquals(new Integer(i++), inputStream.next());
		}
		
		assertEquals(100, i);
	
		inputStream.close();
	}
	
	@Test
	public void testFileInputWriteStream() throws IOException {
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(100);

		for (int i = 0; i < 20; i++) {
			memoryStream.write(i);
		}

		assertEquals(20, memoryStream.size());
		
		OutputDataStream<Integer> out2 = 
				new FileOutputIntegerStream("test6.txt", 20);
		
		out2.write(memoryStream);
		out2.close();
		memoryStream.close();
	}
	
	@Test
	public void testFileStream2Stream() throws IOException {
		String filename = "test7.txt";
		
		OutputDataStream<Integer> outputStream = 
				new FileOutputIntegerStream(filename, 100);
		
		for (int i = 0; i < 100; i++) {
			outputStream.write(i);
		}
		
		//must close file
		outputStream.close();
		
		InputDataStream<Integer> inputStream = 
				new FileInputIntegerStream(filename, 2);
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(100);

		inputStream.next(memoryStream);
		assertEquals(100, memoryStream.size);
		System.out.print("MemoryStream = ");
		System.out.print(memoryStream);
	
		inputStream.close();	
	}
}
