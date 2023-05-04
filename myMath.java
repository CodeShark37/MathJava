package mathsymjava;

public class myMath {
    private final String equacao = "2x-6/1-3x";
    private double x1 = 1;
    private double x2 = 2;
    private double y1 = ((2*x1)-6) / (1-(3*x1));
    private double y2 = ((2*x2)-6) / (1-(3*x2));

    public myMath() {
        this.x1 = 1;
        this.x2 = 2;
        this.y1 = ((2*this.x1)-6) / (1-(3*this.x1));
        this.y2 = ((2*this.x2)-6) / (1-(3*this.x2));
    }
    public double coef_angular(){
        double m = (this.y2-this.y1)/(this.x2-this.x1);
        return m;
    }
    public double coef_linear(){
        return this.y2-(coef_angular()*this.x2);
    }
    public String eq_reduzida(){
        return "y = "+ coef_angular() + "x + " + coef_linear();
    }
    public String eq_inversa(){
        return "y = (x+6)/(3x+2)";
    }
    public double assintota_v(){
       return 0.3333333333333333;
    }
    public double assintota_h(){
        return -0.6666666666666667;
    }
    public String derivada(){
        return "-16/(1-3x)^2";
    }
    public String getEquacao(){
        return this.equacao;
    }

    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public double getY1() {
        return this.y1;
    }

    public double getY2() {
        return this.y2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
