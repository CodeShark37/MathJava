/*
	* Grupo 5
	* Analise Matematica 2
	* LCC1T
	* Funcao: Calcula a derivada da funcao 2x-6/1-3x e desenha o seu grafico
    * OBS: Antes de compilar importe as libs: iplot-1.5.jar e SymJava-1.1.2.jar ao projecto.
    * O projecto foi feito usando o netbeans
*/
package mathsymjava;

import italo.iplot.gui.plot.Plot2DGUI;
import italo.iplot.plot2d.planocartesiano.PlanoCartesianoPlot2D;
import italo.iplot.plot2d.planocartesiano.PlanoCartesianoPlot2DDriver;
import italo.iplot.plot2d.planocartesiano.g2d.PCFuncObjeto2D;
import java.awt.Color;
import javax.swing.JFrame;
import symjava.symbolic.Derivative;
import symjava.symbolic.Divide;
import symjava.symbolic.Expr;
import symjava.symbolic.Func;
import symjava.symbolic.Multiply;
import symjava.symbolic.Subtract;
import symjava.symbolic.SymInteger;
import static symjava.symbolic.Symbol.x;

public class MathSymJava {

    public static void main(String[] args) {

        Expr numerador = new Subtract(new Multiply(x, new SymInteger(2)), new SymInteger(6));
        Expr denominador = new Subtract(new SymInteger(1), new Multiply(x, new SymInteger(3)));
        Func funcao = new Func("f1", new Divide(numerador, denominador));
        /* Acha a derivada da funcao em relacao a x*/
		Derivative derivada = new Derivative(funcao, x);

        PlanoCartesianoPlot2D plot2D = new PlanoCartesianoPlot2D();

        PlanoCartesianoPlot2DDriver drv = (plot2d, pc) -> {
            double x1 = -Math.PI;
            double x2 = Math.PI;
            double inc = 0.5;
            int nverts = (int) (Math.abs(x2 - x1) / inc);
            double[] vx = new double[nverts];
            double[] vy = new double[nverts];
            double x = x1;
            for (int i = 0; i < nverts; i++) {
                vx[i] = x;
                vy[i] = Math.sin(x);
                x += inc;
            }

            PCFuncObjeto2D derivFuncObj2D = new PCFuncObjeto2D();
            derivFuncObj2D.setXIntervaloCompleto(true);
            derivFuncObj2D.setArestasCor(Color.BLUE);
            derivFuncObj2D.setLegenda("f(x)' = " + derivada);

            PCFuncObjeto2D myFuncObj2D = new PCFuncObjeto2D();
            myFuncObj2D.setXIntervaloCompleto(true);
            myFuncObj2D.setArestasCor(Color.RED);
            myFuncObj2D.setLegenda("f(x) = "+funcao);
            /* funcao a ser plotada */
			myFuncObj2D.setFunc2D((px) -> {
                return ((2 * px) - 6) / (1 - (3 * px));
            });

            pc.getPlotObj2DManager().setXYNumRotulos(20);
            pc.addComponenteObj2D(myFuncObj2D);
            pc.addComponenteObj2D(derivFuncObj2D);

        };

        Plot2DGUI plotGUI = plot2D.novaPlot2DGUI();

        JFrame janela = new JFrame();
        janela.setTitle("Desenho de Funções");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setContentPane(plotGUI);
        janela.setSize(1200, 900);
        janela.setLocationRelativeTo(janela);

        janela.setVisible(true);

        int w = plot2D.getDesenhoComponent().getWidth();
        int h = plot2D.getDesenhoComponent().getHeight();
        plot2D.setGrafico(plot2D.novoAlocaImagemGrafico());
        plot2D.constroi(drv, 1000, 1000);
    }

}
