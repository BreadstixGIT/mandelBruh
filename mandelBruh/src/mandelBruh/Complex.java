package mandelBruh;

public class Complex {
	
	private double real;
	private double imag;
	
	public Complex(double realC, double imagC) {
		this.real = realC;
		this.imag = imagC;
	}
	
	public Complex() {
		this.real = 0;
		this.imag = 0;
	}
	
	public double get(int index) {
		if (index == 0) {
			return this.real;
		} else if (index == 1) {
			return this.imag;
		} else {
			return 0;
		}
	}
	
	public double getReal() {
		return this.real;
	}
	
	public double getImag() {
		return this.imag;
	}
	
	public void set(int index, double setVal) {
		if (index == 0) {
			this.real = setVal;
		} else {
			this.imag = setVal;
		}
	}
	
	public void setReal(double setVal) {
		this.real = setVal;
	}
	
	public void setImag(double setVal) {
		this.imag = setVal;
	}
	
	public Complex mult(Complex other) {
		return new Complex(
				this.real * other.getReal() - this.imag * other.getImag(),
				this.real * other.getImag() + this.imag * other.getReal()
				);
	}
	
	public double magnitude() {
		double result = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
		return result;
	}

}
