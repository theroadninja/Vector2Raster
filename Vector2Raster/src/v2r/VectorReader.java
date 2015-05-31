package v2r;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import v2r.svg.Coordinate;
import v2r.svg.Length;
import v2r.svg.Number;
import v2r.svg.PreserveAspectRatio;
import v2r.svg.SvgDocument;
import v2r.svg.ViewBox;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;

public class VectorReader {

	/** should be false for normal operation */
	private boolean failOnUnknown = true;
	
	public Vector read(Context context, int resourceId) throws NotFoundException, XmlPullParserException, IOException{
		
		return read(context.getResources().openRawResource(resourceId));

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
		
		SvgDocument svg = parseSvg(parser);
		
		int type = parser.next();
		
		
		
		//http://developer.android.com/training/basics/network-ops/xml.html
		//http://developer.android.com/reference/org/xmlpull/v1/XmlPullParserException.html
		//http://developer.android.com/reference/org/xmlpull/v1/XmlPullParserFactory.html#setNamespaceAware%28boolean%29
		return null;
	}
	
	private SvgDocument parseSvg(XmlPullParser parser) throws XmlPullParserException, IOException{
		parser.require(XmlPullParser.START_TAG, null, "svg");
		SvgDocument svg = new SvgDocument();
		
		int c = parser.getAttributeCount();
		for(int i = 0; i < c; ++i){
			String name = parser.getAttributeName(i);
			boolean b = svg.setAttribute(name, parser.getAttributeValue(i));
			if(failOnUnknown && !b){
				
				if(name == null || name.startsWith("xmlns") || name.startsWith("inkscape:") || name.startsWith("sodipodi:")){
					//dont care
					
					//Note:  inkscape is a derivative of sodipodi...
				}else{
					throw new IOException("unrecognized svg attribute: " + name);
				}
				
				
			}
			
		}
		
		
		while(true){
			
			parser.next();
			if(parser.getEventType() == XmlPullParser.START_TAG){
				
				//http://www.w3.org/TR/SVG/struct.html
				
				String name = parser.getName();
				
				if("g".equals(name)){
					//TODO
				}else if("defs".equals(name)){
					
				}else if("desc".equals(name)){
					
				}else if("title".equals(name)){
					
				}else{
					//TODO
				}
				
				
			}else if(parser.getEventType() == XmlPullParser.TEXT){
				//probably just white space
			}else if(parser.getEventType() == XmlPullParser.END_TAG){
				parser.require(XmlPullParser.END_TAG, null, "svg");
				return svg;
			}else if(parser.getEventType() == XmlPullParser.END_DOCUMENT){
				if(failOnUnknown){
					throw new IOException("reached end of document too soon");
				}
				return svg;
			}else{
				if(failOnUnknown){
					throw new IOException("unrecognized event type: " + parser.getEventType());
				}
				return svg;
			}
			
		} //while(true)
		
		
		
		
		
	}
}
