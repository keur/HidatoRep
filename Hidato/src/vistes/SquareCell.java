/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistes;


import domini.Tauler.Type;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author David
 */
public class SquareCell extends JPanel{
    
    private final int a;
    private final int b;
    private int val;
    private Type type;
    private final Color color_normal, color_highlight, color_given, color_void;
    private final JLabel label;
    private final String font_nom = "Tahoma";
    private boolean light;
    private boolean modificable;
    
    
    public SquareCell (int a, int b, int val, Type type, Color cn, Color ch, Color cg, Color cv, int font_num, boolean mod) {
        this.a = a;
        this.b = b;
        this.val = val;
        this.type = type;
        color_normal = cn;
        color_highlight = ch;
        color_given = cg;
        color_void = cv;
        modificable = mod;
        light = false;
        
        setLayout(new GridBagLayout());
        label = new JLabel();
        add(label);
        if (val == 0) label.setText("");
        else label.setText(Integer.toString(val));
        label.setFont(new Font(font_nom, Font.PLAIN, font_num));
        setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        setBackground(color_normal);
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                setLight(false);
            }
        });
    }
    
    public void changeVal(int val) {
        this.val = val;
        if (val <= 0) label.setText("");
        else label.setText(Integer.toString(val));
    }
    
    public void changeType(Type type) {
        this.type = type;
        if (type == Type.VOID) {
            setBackground(color_void);
        }
        else if (type == Type.GIVEN) {
            label.setFont(new Font("Tahoma", Font.BOLD, label.getFont().getSize()));
            setBackground(color_given);
        }
        else {
            setBackground(color_normal);
            label.setFont(new Font("Tahoma", Font.PLAIN, label.getFont().getSize()));
        }
    }
    
    public void setLight(boolean light) {
        if (modificable) {
            this.light = light;
            if (light) {
                setBackground(color_highlight);
            }
            else {
                changeType(type);
            }
        }
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }
    
    public int getVal() {
        return val;
    }
    
    public boolean getLight() {
        return light;
    }
    
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    
}
