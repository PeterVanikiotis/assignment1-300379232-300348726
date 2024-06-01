public abstract class PointCP5 {

    public abstract double getX();
    public abstract double getY();
    public abstract double getRho();
    public abstract double getTheta();
    public abstract void convertStorageToCartesian();
    public abstract void convertStorageToPolar();

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */

   public double getDistance(PointCP5 pointB){
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
   }
   
	public abstract PointCP5 rotatePoint(double rotation);
	
    @Override
    public abstract String toString();
}