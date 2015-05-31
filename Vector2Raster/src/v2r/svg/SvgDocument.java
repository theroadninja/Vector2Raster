package v2r.svg;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SvgDocument {
	
	//not in the spec, but in an inkscape file
	private String id = null;

	private Number version = null;
	
	private String baseProfile = null;
	
	private Coordinate x = null;
	
	private Coordinate y = null;
	
	private Length width = null;
	
	private Length height = null;
	
	private PreserveAspectRatio preserveAspectRatio = null;
	
	private String contentScriptType = null;
	
	private String contentStyleType = null;
	
	private String zoomAndPan = null; 
		//apparently can either be "disable" or "magnify"
		//see http://www.w3.org/TR/SVG/interact.html#ZoomAndPanAttribute
	
	private ViewBox viewBox = null;
	
	
	public boolean setAttribute(String name, String value){
		
		if("id".equals(name)){
			id = value;
		}else if("version".equals(name)){
			version = new Number(value);
		}else if("baseProfile".equals(name)){
			baseProfile = value;
		}else if("x".equals(name)){
			x = new Coordinate(value);
		}else if("y".equals(name)){
			y = new Coordinate(value);
		}else if("width".equals(name)){
			width = new Length(value);
		}else if("height".equals(name)){
			height = new Length(value);
		}else if("preserveAspectRatio".equals(name)){
			preserveAspectRatio = new PreserveAspectRatio(value);
		}else if("contentScriptType".equals(name)){
			contentScriptType = value;
		}else if("contentStyleType".equals(name)){
			contentStyleType = value;
		}else if("zoomAndPan".equals(name)){
			zoomAndPan = value;
		}else if("viewBox".equals(name)){
			viewBox = new ViewBox(value);
		}else{
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
}
