package g.p.v2r.test;

import java.io.StringReader;

import v2r.VectorReader;
import android.test.AndroidTestCase;

public class SimpleTest extends AndroidTestCase {

	
	public void testHappyCase() throws Exception {
		
		
		VectorReader reader = new VectorReader();
		reader.read(this.getContext(), R.raw.test1);
	}
}
