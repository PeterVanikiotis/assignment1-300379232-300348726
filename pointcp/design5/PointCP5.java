public abstract class PointCP5 {
	
    public abstract double getX();
    public abstract double getY();
    public abstract double getRho();
    public abstract double getTheta();
	
    public abstract void convertStorageToCartesian();
    public abstract void convertStorageToPolar();
	
	public abstract double getDistance(PointCP5 pointb);
	public abstract PointCP5 rotatePoint(double rotation);
	
    @Override
    public abstract String toString();
}
