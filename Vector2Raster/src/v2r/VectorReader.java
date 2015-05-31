package v2r;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;

public class VectorReader {

	
	public Vector read(Context context, int resourceId){
		
		//context.getResources().g
		return null; //TODO
	}
	
	public Vector read(InputStream in) throws XmlPullParserException, IOException{
		return read(new InputStreamReader(in));
	}
	
	//can use StringReader for testing (it takes a string in the constructor)
	public Vector read(Reader in) throws XmlPullParserException, IOException{
		
		XmlPullParser xml = XmlPullParserFactory.newInstance().newPullParser();
		xml.setInput(in);
		return read(xml);
		
		
	}
	
	public Vector read(XmlPullParser parser) throws XmlPullParserException, IOException{
		
		parser.nextTag();
		parser.require(XmlPullParser.START_TAG, null, "svg");
		
		//http://developer.android.com/training/basics/network-ops/xml.html
		//http://developer.android.com/reference/org/xmlpull/v1/XmlPullParserException.html
		//http://developer.android.com/reference/org/xmlpull/v1/XmlPullParserFactory.html#setNamespaceAware%28boolean%29
		return null;
	}
}
