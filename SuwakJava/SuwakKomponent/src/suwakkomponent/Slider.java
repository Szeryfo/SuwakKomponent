package suwakkomponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.JLabel;


/**
 *
 * @author Sebastian
 */
public class Slider extends Component{
    
    Dimension d = getSize();
    int szer = d.width-1;
    int wys = d.height-1;
    int szerKlik=50;
    int wysKlik=50;
    boolean rotation = false;
    String poczatek = "500";
    String koniec = "1000";
    int wartosc = 0;
    String kolor = "czarny";
    
    public synchronized void paint(Graphics g){
            
        Dimension d = getSize();
        //długość i szerokość komponentu
        szer = d.width-1;
        wys = d.height-1;
        
        if(kolor == "czarny"){
            g.setColor(Color.black);
        }else if(kolor == "czerwony"){
            g.setColor(Color.red);
        }else if(kolor == "niebieski"){
            g.setColor(Color.blue);
        }else if(kolor == "różowy"){
            g.setColor(Color.pink);
        }
        
        
        if(rotation==false)//zależność obrotu
        {
            //slider Poziomy
            //dwie linie pionowe
            g.drawLine((int)(szer/2-0.01*szer), (int)(wys*0.05), (int)(szer/2-0.01*szer), (int)(wys-wys*0.05));
            g.drawLine((int)(szer/2+0.01*szer),(int)(wys*0.05) ,(int)(szer/2+0.01*szer), (int)(wys-wys*0.05));
            // dwie linie poziome
            g.drawLine((int)(szer/2-0.01*szer),(int)(wys*0.05),(int)(szer/2+0.01*szer),(int)(wys*0.05));
            g.drawLine((int)(szer/2-0.01*szer),(int)(wys-wys*0.05),(int)(szer/2+0.01*szer),(int)(wys-wys*0.05));
            // wartości liczb należące do początkowej i końcowej wartości
            g.drawString(koniec,(int)(szer/2+0.1*szer),(int)(wys*0.05) );
            g.drawString(poczatek,(int)(szer/2+0.1*szer),(int)(wys-wys*0.05));
        
            // --- na sliderze
            for(int i=1;i<4;i++){
                int x = (wys-wys/50)-(wys/50);
                x=x/4;
                g.drawLine((int)(szer/2+0.05*szer),wys/50+x*i,(int)(szer/2+0.07*szer),wys/50+x*i);   
            }
            g.drawLine((int)(szer/2+0.05*szer),(int)(wys*0.05),(int)(szer/2+0.07*szer),(int)(wys*0.05));
            g.drawLine((int)(szer/2+0.05*szer),(int)(wys-wys*0.05),(int)(szer/2+0.07*szer),(int)(wys-wys*0.05));      
       
            if(wysKlik>(int)(wys*0.05) && wysKlik<(int)(wys-wys*0.05)){
                // rysuje prostokąt kiedy jest w sliderze   
                g.drawLine((int) (szer/2-0.02*szer),(int)(wysKlik-wys*0.02),(int) (szer/2+0.02*szer),(int)(wysKlik-wys*0.02));
                g.drawLine((int) (szer/2-0.02*szer),(int)(wysKlik+wys*0.02),(int) (szer/2+0.02*szer),(int)(wysKlik+wys*0.02));    
                g.drawLine((int) (szer/2-0.02*szer),(int)(wysKlik-wys*0.02),(int) (szer/2-0.02*szer),(int)(wysKlik+wys*0.02));
                g.drawLine((int) (szer/2+0.02*szer),(int)(wysKlik+wys*0.02),(int) (szer/2+0.02*szer),(int)(wysKlik-wys*0.02));         
            }else if(wysKlik<=(int)(wys*0.05) ){
                // rysuje prostokąt kiedy jest powyżej slidera   
                g.drawLine((int) (szer/2-0.02*szer),(int)(wys*0.05-wys*0.02),(int) (szer/2+0.02*szer),(int)(wys*0.05-wys*0.02));
                g.drawLine((int) (szer/2-0.02*szer),(int)(wys*0.05+wys*0.02),(int) (szer/2+0.02*szer),(int)(wys*0.05+wys*0.02));  
                g.drawLine((int) (szer/2-0.02*szer),(int)(wys*0.05-wys*0.02),(int) (szer/2-0.02*szer),(int)(wys*0.05+wys*0.02));
                g.drawLine((int) (szer/2+0.02*szer),(int)(wys*0.05+wys*0.02),(int) (szer/2+0.02*szer),(int)(wys*0.05-wys*0.02));         
            }else{     
                // rysuje prostokąt kiedy jest poniżej slidera  
                g.drawLine((int) (szer/2-0.02*szer),(int)(wys*0.95-wys*0.02),(int) (szer/2+0.02*szer),(int)(wys*0.95-wys*0.02));
                g.drawLine((int) (szer/2-0.02*szer),(int)(wys*0.95+wys*0.02),(int) (szer/2+0.02*szer),(int)(wys*0.95+wys*0.02));     
                g.drawLine((int) (szer/2-0.02*szer),(int)(wys*0.95-wys*0.02),(int) (szer/2-0.02*szer),(int)(wys*0.95+wys*0.02));
                g.drawLine((int) (szer/2+0.02*szer),(int)(wys*0.95+wys*0.02),(int) (szer/2+0.02*szer),(int)(wys*0.95-wys*0.02));                 
            }
        }else if(rotation == true){
            //slider Pionowy
            //dwie linie poziome
            g.drawLine((int)(szer*0.05), (int)(wys/2-0.01*wys), (int)(szer-szer*0.05), (int)(wys/2-0.01*wys));
            g.drawLine((int)(szer*0.05), (int)(wys/2+0.01*wys), (int)(szer-szer*0.05), (int)(wys/2+0.01*wys));
            //dwie linie pionowe      
            g.drawLine((int)(szer*0.05),(int)(wys/2-0.01*wys),(int)(szer*0.05),(int)(wys/2+0.01*wys));
            g.drawLine((int)(szer-szer*0.05),(int)(wys/2-0.01*wys),(int)(szer-szer*0.05),(int)(wys/2+0.01*wys));
            // wartości liczb należące do początkowej i końcowej wartości
            g.drawString(poczatek,(int)(szer*0.05),(int)(wys/2+0.15*wys));
            g.drawString(koniec,(int)(szer-szer*0.1),(int)(wys/2+0.15*wys));
            // ||| na sliderze
            for(int i=1;i<4;i++){
                int x = (szer-szer/50)-(szer/50);
                x=x/4; 
                g.drawLine(szer/50+x*i,(int)(wys/2+0.05*wys),szer/50+x*i,(int)(wys/2+0.07*wys));   
            }
            g.drawLine((int)(szer*0.05),(int)(wys/2+0.05*wys),(int)(szer*0.05),(int)(wys/2+0.07*wys));
            g.drawLine((int)(szer-szer*0.05),(int)(wys/2+0.05*wys),(int)(szer-szer*0.05),(int)(wys/2+0.07*wys));
         
            if(szerKlik>(int)(szer*0.05) && szerKlik<(int)(szer*0.95)){
                // rysuje prostokąt kiedy jest w sliderze   
                g.drawLine((int)(szerKlik-szer*0.02),(int) (wys/2-0.02*wys),(int)(szerKlik-szer*0.02),(int) (wys/2+0.02*wys));
                g.drawLine((int)(szerKlik+szer*0.02),(int) (wys/2-0.02*wys),(int)(szerKlik+szer*0.02),(int) (wys/2+0.02*wys));
                g.drawLine((int)(szerKlik-szer*0.02),(int) (wys/2-0.02*wys),(int)(szerKlik+szer*0.02),(int) (wys/2-0.02*wys));
                g.drawLine((int)(szerKlik+szer*0.02),(int) (wys/2+0.02*wys),(int)(szerKlik-szer*0.02),(int) (wys/2+0.02*wys));    
            }else if(szerKlik<=(int)(szer*0.05)){
                // rysuje prostokąt kiedy jest w poniżej slidera(lewa strona)   
                g.drawLine((int)(szer*0.05-szer*0.02),(int) (wys/2-0.02*wys),(int)(szer*0.05-szer*0.02),(int) (wys/2+0.02*wys));
                g.drawLine((int)(szer*0.05+szer*0.02),(int) (wys/2-0.02*wys),(int)(szer*0.05+szer*0.02),(int) (wys/2+0.02*wys));
                g.drawLine((int)(szer*0.05-szer*0.02),(int) (wys/2-0.02*wys),(int)(szer*0.05+szer*0.02),(int) (wys/2-0.02*wys));
                g.drawLine((int)(szer*0.05+szer*0.02),(int) (wys/2+0.02*wys),(int)(szer*0.05-szer*0.02),(int) (wys/2+0.02*wys));
            }else{
                // rysuje prostokąt kiedy jest powyżej slidera(prawa strona)        
                g.drawLine((int)(szer*0.95-szer*0.02),(int) (wys/2-0.02*wys),(int)(szer*0.95-szer*0.02),(int) (wys/2+0.02*wys));
                g.drawLine((int)(szer*0.95+szer*0.02),(int) (wys/2-0.02*wys),(int)(szer*0.95+szer*0.02),(int) (wys/2+0.02*wys));
                g.drawLine((int)(szer*0.95-szer*0.02),(int) (wys/2-0.02*wys),(int)(szer*0.95+szer*0.02),(int) (wys/2-0.02*wys));
                g.drawLine((int)(szer*0.95+szer*0.02),(int) (wys/2+0.02*wys),(int)(szer*0.95-szer*0.02),(int) (wys/2+0.02*wys));
            }
        }
    }
    public void setSzer(int szerr){
        this.szerKlik = szerr;
    }
    public int getSzer(){
        return szerKlik;
    }
    public void setWys(int wyss){
        this.wysKlik = wyss;
    }
    public int getWys(){
        return wysKlik;
    }
    
    public void Rotate(){
        if(this.rotation==true){
            this.rotation = false;
        }else  this.rotation = true;
    }
    public void setWartosc(int wartosc){
        if(this.rotation == true){
            if(szerKlik>(int)(szer*0.05) && szerKlik<(int)(szer*0.95)){
                int szerokosc =(int)(this.szer*0.9);
                int roznica = (Integer.parseInt(this.koniec) - Integer.parseInt(this.poczatek));  
                wartosc=(this.szerKlik-(int)(this.szer*0.05))*roznica/szerokosc; 
                wartosc+= Integer.parseInt(this.poczatek); 
            }else if(szerKlik<=(int)(szer*0.05)){
                wartosc=Integer.parseInt(this.poczatek);
            }else{
                wartosc=Integer.parseInt(this.koniec);
            }
            this.wartosc = wartosc;
        }else{
            if(wysKlik>(int)(wys*0.05) && wysKlik<(int)(wys*0.95)){
                int wysokosc =(int)(this.wys*0.9);
                int roznica = (Integer.parseInt(this.koniec) - Integer.parseInt(this.poczatek));  
                wartosc =(this.wysKlik-(int)(this.wys*0.05))*roznica/wysokosc; 
                wartosc+= Integer.parseInt(this.poczatek);
                wartosc=wartosc*-1 + Integer.parseInt(this.koniec) + Integer.parseInt(this.poczatek);
            }else if(wysKlik<=(int)(wys*0.05)){
                wartosc=Integer.parseInt(this.koniec);
            }else{
                wartosc=Integer.parseInt(this.poczatek);
            }
            this.wartosc = wartosc;
        }
    }
    public int getWartosc(){
        return this.wartosc;
    }
    public void setMinimum(String minimum){
        this.poczatek = minimum;
    }
    public String getMinimum(){
        return poczatek;
    }
    public void setMaksimum(String maksimum){
        this.koniec = maksimum;
    }
    public String getMaksimum(){
        return koniec;
    }
    public void setKolor(String kr){
        this.kolor = kr;
    }
    public String getKolor(){
        return kolor;
    }
}

