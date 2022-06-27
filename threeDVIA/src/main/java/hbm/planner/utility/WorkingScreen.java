/* Created by U2I 
 * 
 * Last modified by: 
 */

package hbm.planner.utility;


public class WorkingScreen {
//	
//	
//	// more about this is in
//	// http://stackoverflow.com/questions/14431467/how-do-i-determine-the-position-of-the-system-tray-on-the-screen
//	// private static Rectangle bounds;
//	private static Rectangle workAreaBounds;
//	private static Rectangle taskBarBounds;
//	private static int x, y, width, height;
//	private static Region tempRegion = null;
//
//	private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
//			.getDefaultScreenDevice();
//	private static Rectangle bounds = gd.getDefaultConfiguration().getBounds();
//	private static Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(
//			gd.getDefaultConfiguration());
//
//	/**
//	 * It measures the working screen and initialize the values in a static
//	 * variable workAreaBounds
//	 */
//	private static void initialise() {
//		workAreaBounds = new Rectangle(bounds);
//		workAreaBounds.x += insets.left;
//		workAreaBounds.y += insets.top;
//		workAreaBounds.width -= (insets.left + insets.right);
//		workAreaBounds.height -= (insets.top + insets.bottom);
//
//		x = workAreaBounds.x;
//		y = workAreaBounds.y;
//		width = workAreaBounds.width;
//		height = workAreaBounds.height;
//	}
//
//	/**
//	 * Get screen inputs using Initialize method call and then pass working area
//	 * into region object
//	 * 
//	 * @return new region with working screen pattern
//	 */
//	public static Region getWorkRegion() {
//		WorkingScreen.initialise();
//		tempRegion = new Region(workAreaBounds);
//		return tempRegion;
//	}
//
//	public static Region taskBarRegion() {
//		WorkingScreen.initialise();
//		Area area = new Area(bounds);
//		area.subtract(new Area(workAreaBounds));
//		taskBarBounds = area.getBounds();
//		tempRegion = new Region(taskBarBounds);
//		return tempRegion;
//	}
//
//	public static int getCenterX() {
//		WorkingScreen.initialise();
//		return (int) workAreaBounds.getCenterX();
//	}
//
//	public static int getCenterY() {
//		WorkingScreen.initialise();
//		return (int) workAreaBounds.getCenterY() - 2;
//	}
//
//	/**
//	 * Initialize Region, then manipulate width/2 to get left region.
//	 * 
//	 * @return
//	 */
//	public static Region getLeftRegion() {
//		WorkingScreen.initialise();
//		tempRegion = new Region(x, y, (int) (width / 2.5), height);
//		return tempRegion;
//	}
//
//	/**
//	 * Initialize Region, then manipulate (_)to get Upper half region.
//	 * 
//	 * @return
//	 */
//	public static Region getUpperRegion() {
//		WorkingScreen.initialise();
//		tempRegion = new Region(x, y, width, height / 3);
//		return tempRegion;
//	}
//
//	/**
//	 * Initialize Region, then manipulate (_)to get lower half region.
//	 * 
//	 * @return
//	 */
//	public static Region getLowerHalfRegion() {
//		WorkingScreen.initialise();
//		tempRegion = new Region(x, ((height - y) - ((height - y) / 2)), width, (height - y) / 2);
//		return tempRegion;
//	}
//
//	public static int getScreenWidth() {
//		WorkingScreen.initialise();
//		return width;
//	}
//
//	public static int getScreenHeight() {
//		WorkingScreen.initialise();
//		return height;
//	}
//
//	public static Region getAppNameRegion() {
//		WorkingScreen.initialise();
//		tempRegion = new Region(x + 260, y + 22, 350, 40);
//		return tempRegion;
//	}

	
}
