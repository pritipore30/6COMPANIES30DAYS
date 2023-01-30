package solution;

public class GenerateRandomPointinCircle {
	double RAD, XC, YC;

	public GenerateRandomPointinCircle(double radius, double x_center, double y_center) {
        RAD = radius;
        XC = x_center;
        YC = y_center;
    }

	public double[] randPoint() {
		double ang = Math.random() * 2 * Math.PI;
		double hyp = Math.sqrt(Math.random()) * RAD;
		double adj = Math.cos(ang) * hyp;
		double opp = Math.sin(ang) * hyp;
		return new double[] { XC + adj, YC + opp };
	}
}
