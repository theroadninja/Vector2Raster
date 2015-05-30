package v2r;

import android.graphics.Bitmap;

public class Vector {

	//formats:
	//start with SVG format
	
	//source use cases:
	//1. whole thing
	//2. region
	
	//dest use cases:
	//1. new bitmap, auto scale y dimension
	//2. new bitmap, image view scale type
	//3. square region in existing bitmap, image view scale type
	//4. polygon region ... ?
	
	
	//use size of svg; no scaling
	public Bitmap toBitmap(){
		return null;
	}
	
	
	//auto scales y based on aspect ratio
	//public Bitmap toBitmapDp(int xDp){
	//	return null;
	//}
	
	//scale type is from image view scale type - TODO
	//public Bitmap toBitmapDp(int xDp, int yDp, int imageViewScaleType){
	//	return null;
	//}
}
