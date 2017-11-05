package name.cdd.train.ddd.class_3;

import static name.cdd.train.ddd.class_3.LayoutTool.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import name.cdd.toolkit.swing.util.SwingUtil;

public class TestFrm extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    private Container container;
    
    public TestFrm()
    {
        setTitle("Layout Test");
        setSize(600, 400);
        initWorkspace();
    }

    private void initWorkspace()
    {
        Container pnRoot = getContentPane();
        
        JPanel pnNorth = new JPanel();
        pnNorth.setPreferredSize(new Dimension(0, 20));
        pnNorth.setMaximumSize(new Dimension(0, 20));
        pnNorth.setMinimumSize(new Dimension(0, 20));
        pnRoot.add(pnNorth, BorderLayout.NORTH);
        
        JPanel pnSouth = new JPanel();
        pnSouth.setPreferredSize(new Dimension(0, 20));
        pnSouth.setMaximumSize(new Dimension(0, 20));
        pnSouth.setMinimumSize(new Dimension(0, 20));
        pnRoot.add(pnSouth, BorderLayout.SOUTH);
        
        JPanel pnWest = new JPanel();
        pnWest.setPreferredSize(new Dimension(20, 0));
        pnWest.setMaximumSize(new Dimension(20, 0));
        pnWest.setMinimumSize(new Dimension(20, 0));
        pnRoot.add(pnWest, BorderLayout.WEST);
        
        JPanel pnEast = new JPanel();
        pnEast.setPreferredSize(new Dimension(20, 0));
        pnEast.setMaximumSize(new Dimension(20, 0));
        pnEast.setMinimumSize(new Dimension(20, 0));
        pnRoot.add(pnEast, BorderLayout.EAST);
        
        container = new JPanel();
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(null);
        pnRoot.add(container, BorderLayout.CENTER);
    }
    
    @Override
    protected void processWindowEvent(WindowEvent e)
    {
        if(e.getID() == WindowEvent.WINDOW_CLOSING)
        {
            System.exit(0);
        }
    }
    
    private void centerShow()
    {
        SwingUtil.centerWindow(this);
    }
    
    public static void main(String[] args)
    {
        TestFrm frm = new TestFrm();
        
        //test case
//        frm.test_component();
//        frm.test_beside();
//        frm.test_above();
//        frm.testCombine();
//        frm.testEmpty();
//        frm.testCenter();
//        frm.testHSeq();
//        frm.testVSeq();
//        frm.testBlock();
//        frm.testBlockWithMargin();
        frm.testCalc();
//        frm.testCalcWithMargin();
        
        
        frm.centerShow();
    }



//    private void test_component()
//    {
//        button().title("Button").at(0, 0, 200, 60).in(container);
//    }
//    
//    private void test_beside()
//    {
//        beside(textField(), button(), 0.8f).at(0, 0, 300, 60).in(container);
//    }
//    
//    private void test_above()
//    {
//        above(textField(), button().title("aboveTestButton"), 0.5f).at(0, 0, 300, 60).in(container);
//    }
//    
//    private void testCombine()
//    {
//        above(beside(textField(), 
//                     button().title("up"), 
//                     0.8f), 
//              button().title("down"), 0.5f)
//            .at(0, 0, 300, 60)
//            .in(container);
//    }
//    
//    private void testEmpty()
//    {
//        beside(empty(), button().title("btn"), 0.5f).at(0, 0, 300, 60).in(container); 
//    }
//    private void testCenter()
//    {
//        center(button().title("btn"), 0.2f, 0.1f).at(0, 0, 300, 60).in(container); 
//    }
//    
//    private void testHSeq()
//    {
//        hSeq(button().title("1"), button().title("2"), button().title("3")).at(0, 0, 300, 60).in(container);
//    }
//    
//    private void testVSeq()
//    {
//        vSeq(button().title("1"), button().title("2"), button().title("3")).at(0, 0, 300, 60).in(container);
//    }
//
//    private void testBlock()
//    {
//        Component[] cmps = new Component[] {
//                                        button().title("1"), 
//                                        button().title("2"), 
//                                        button().title("3"), 
//                                        button().title("4"), 
//                                        button().title("5"), 
//                                        button().title("6"), 
//                                        button().title("7"), 
//                                        button().title("8"), 
//                                        button().title("9"), 
//                                        button().title("10"), 
//                                        button().title("11")
//                                        };
//        block(cmps, 4, 3).at(0, 0, 545, 325).in(container);
//    }
//    
//    private void testBlockWithMargin()
//    {
//        Component[] cmps = new Component[] {
//                                            button().title("1"), 
//                                            button().title("2"), 
//                                            button().title("3"), 
//                                            button().title("4"), 
//                                            button().title("5"), 
//                                            button().title("6"), 
//                                            button().title("7"), 
//                                            button().title("8"), 
//                                            button().title("9"), 
//                                            button().title("10"), 
//                                            button().title("11")
//                                            };
//            blockWithMargin(cmps, 4, 3, 0.1f, 0.1f).at(0, 0, 545, 325).in(container);
//    }
    
    private void testCalc()
    {
        Component[] cmps = new Component[] {
                                            button().title("0"), 
                                            button().title("1"), 
                                            button().title("2"), 
                                            button().title("+"), 
                                            button().title("3"), 
                                            button().title("4"), 
                                            button().title("5"), 
                                            button().title("-"), 
                                            button().title("6"), 
                                            button().title("7"), 
                                            button().title("8"), 
                                            button().title("*"), 
                                            button().title("9"), 
                                            button().title("="), 
                                            button().title("%"),
                                            button().title("/")
        };
        
        above(above(textField(), 
                    beside(button().title("Backspace"), button().title("C"), 0.5f), 0.5f), 
              block(cmps, 4, 4), 0.3f)
        .at(0, 0, 545, 325).in(container);
    }
//    
//    private void testCalcWithMargin()
//    {
//        Component[] cmps = new Component[] {
//                                            button().title("0"), 
//                                            button().title("1"), 
//                                            button().title("2"), 
//                                            button().title("+"), 
//                                            button().title("3"), 
//                                            button().title("4"), 
//                                            button().title("5"), 
//                                            button().title("-"), 
//                                            button().title("6"), 
//                                            button().title("7"), 
//                                            button().title("8"), 
//                                            button().title("*"), 
//                                            button().title("9"), 
//                                            button().title("="), 
//                                            button().title("%"),
//                                            button().title("/")
//        };
//        
//        above(above(textField(), 
//                    beside(button().title("Backspace"), button().title("C"), 0.5f), 0.5f), 
//              blockWithMargin(cmps, 4, 4, 0.02f, 0.02f), 0.3f)
//        .at(0, 0, 545, 325).in(container);
//    }
}
