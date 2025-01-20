package day13;

public class UltraSimultaneousEquations {

    int a;
    int b;
    long c;
    int d;
    int e;
    long f;

    public UltraSimultaneousEquations(){

    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(long c) {
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setE(int e) {
        this.e = e;
    }

    public void setF(long f) {
        this.f = f;
    }

    public double  getX(){
        return (((double) c * e) - ((double) b * f)) /(((double) a *e) - ((double) b *d));
    }

    public double getY(double x){
        return (c - a*x)/b;
    }
}
