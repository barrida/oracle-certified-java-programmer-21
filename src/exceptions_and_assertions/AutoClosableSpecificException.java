package exceptions_and_assertions;

import java.io.FileNotFoundException;

public class AutoClosableSpecificException implements AutoCloseable{

	@Override
	public void close() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
