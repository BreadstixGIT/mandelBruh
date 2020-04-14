package mandelBruh;

public class Complex {
	
	private double u;
	private double v;
	
	public Complex(double uC, double vC) {
		this.u = uC;
		this.v = vC;
	}
	
	public Complex() {
		this.u = 0;
		this.v = 0;
	}
	
	public String toString() {
		return "(" + this.u + ", " + this.v + ")";
	}
	
	public double get(int index) {
		if (index == 0) {
			return this.u;
		} else if (index == 1) {
			return this.v;
		} else {
			return 0;
		}
	}
	
	public double getU() {
		return this.u;
	}
	
	public double getV() {
		return this.v;
	}
	
	public void set(int index, double setVal) {
		if (index == 0) {
			this.u = setVal;
		} else {
			this.v = setVal;
		}
	}
	
	public void setU(double setVal) {
		this.u = setVal;
	}
	
	public void setV(double setVal) {
		this.v = setVal;
	}
	
	public void zero() {
		this.u = 0;
		this.v = 0;
	}
	
	public Complex add(Complex other) {
		return new Complex(
				this.u + other.getU(),
				this.v + other.getV()
				);
	}
	
	public Complex mult(Complex other) {
		return new Complex(
				this.u * other.getU() - this.v * other.getV(),
				this.u * other.getV() + this.v * other.getU()
				);
	}
	
	public double magnitude() {
		double result = Math.sqrt(Math.pow(this.u, 2) + Math.pow(this.v, 2));
		return result;
	}
	
	public Complex squared() {
		return this.mult(this);
	}

}
