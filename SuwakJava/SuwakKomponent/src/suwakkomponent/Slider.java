package suwakkomponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.JLabel;


/**
 * Suwak
 * @author Sebastian
 */
public class Slider extends Component{
    /**
     * Przechowuje rozmiar suwaka
     */
    Dimension d = getSize();
    /**
     * Przechowuje szerokosc suwaka
     */
    int szer = d.width-1;
    /**
     * Przechowuje wysokosc suwaka
     */
    int wys = d.height-1;
    /**
     * Przechowuje szerokosc w miejscu główki suwaka
     */
    int szerKlik=50;
    /**
     * Przechowuje wysokosc w miejscu główki suwaka
     */
    int wysKlik=50;
    /**
     * Przechowuje informacje o obrocie
     */
    boolean rotation = false;
    /**
     * Przechowuje najniższą możliwą wartość suwaka
     */
    String poczatek = "500";
    /**
     * Przechowuje najwyższą możliwą wartość suwaka
     */
    String koniec = "1000";
    /**
     * Przechowuje aktualną wartość suwaka
     */
    int wartosc = 0;
    /**
     * Przechowuje aktualny kolor suwaka
     */
    String kolor = "czarny";
    /**
     * Przechowuje aktualny rodzaj główki suwaka
     */
    int glowka = 1;
    
    /**
     * Rysuje suwak 
     * @param g  maksymalna wartość
    */
    public synchronized void paint(Graphics g){
            
        Dimension d = getSize();
        //długość i szerokość komponentu
        szer = d.width-1;
        wys = d.height-1;
        
        if("czarny".equals(kolor)){
            g.setColor(Color.black);
        }else if("czerwony".equals(kolor)){
            g.setColor(Color.red);
        }else if("niebieski".equals(kolor)){
            g.setColor(Color.blue);
        }else if("różowy".equals(kolor)){
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
 
            if(glowka == 1){
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
            }else if(glowka == 2){
                 if(wysKlik>(int)(wys*0.05) && wysKlik<(int)(wys-wys*0.05)){
                    // rysuje trojkat kiedy jest w sliderze   
                    g.drawPolygon(new int[] {(int) (szer/2-0.02*szer),(int) (szer/2+0.02*szer),(int)(((szer/2+0.02*szer)+(szer/2-0.02*szer))/2)},new int[] {(int)(wysKlik+wys*0.02),(int)(wysKlik+wys*0.02),(int) (wysKlik-wys*0.02)},3);
        
                }else if(wysKlik<=(int)(wys*0.05)){
                    // rysuje trojkat kiedy jest w powyzej slidera 
                    g.drawPolygon(new int[] {(int) (szer/2-0.02*szer),(int) (szer/2+0.02*szer),(int)(((szer/2+0.02*szer)+(szer/2-0.02*szer))/2)},new int[] {(int)(wys*0.05+wys*0.02),(int)(wys*0.05+wys*0.02),(int) (wys*0.05-wys*0.02)},3);
        
                }else{
                    // rysuje trojkat kiedy jest ponizej slidera   
                    g.drawPolygon(new int[] {(int) (szer/2-0.02*szer),(int) (szer/2+0.02*szer),(int)(((szer/2+0.02*szer)+(szer/2-0.02*szer))/2)},new int[] {(int)(wys*0.95+wys*0.02),(int)(wys*0.95+wys*0.02),(int) (wys*0.95-wys*0.02)},3);
        
               }   
            }else if(glowka == 3){
                if(wysKlik>(int)(wys*0.05) && wysKlik<(int)(wys-wys*0.05)){
                    // rysuje trojkat kiedy jest w sliderze   
                    g.drawOval((int) (szer/2-0.02*szer), (int)(wysKlik - 0.02*wys), (int) (0.04*szer),  (int) (0.04*wys));
                    
                }else if(wysKlik<=(int)(wys*0.05)){
                    // rysuje trojkat kiedy jest w powyzej slidera 
                    g.drawOval((int) (szer/2-0.02*szer), (int)(wys*0.05-0.02*wys), (int) (0.04*szer),  (int) (0.04*wys));
                }else{
                    // rysuje trojkat kiedy jest ponizej slidera   
                   g.drawOval((int) (szer/2-0.02*szer), (int)(wys*0.95-0.02*wys), (int) (0.04*szer),  (int) (0.04*wys));
               }  
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
         
            if(glowka == 1){
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
            }else if(glowka == 2){
                if(szerKlik>(int)(szer*0.05) && szerKlik<(int)(szer*0.95)){
                    // rysuje trojkat kiedy jest w sliderze   
                    g.drawPolygon(new int[] {(int)(szerKlik-szer*0.02),(int)(szerKlik-szer*0.02),(int)((szerKlik+szer*0.02))},new int[] {(int) (wys/2+0.02*wys),(int) (wys/2-0.02*wys),(int) (((wys/2-0.02*wys)+(wys/2+0.02*wys))/2)},3);
        
                }else if(szerKlik<=(int)(szer*0.05)){
                    // rysuje trojkat kiedy jest w poniżej slidera(lewa strona)   
                    g.drawPolygon(new int[] {(int)(szer*0.05-szer*0.02),(int)(szer*0.05-szer*0.02),(int)((szer*0.05+szer*0.02))},new int[] {(int) (wys/2+0.02*wys),(int) (wys/2-0.02*wys),(int) (((wys/2-0.02*wys)+(wys/2+0.02*wys))/2)},3);
        
                }else{
                    // rysuje trojkat kiedy jest powyżej slidera(prawa strona)        
                    g.drawPolygon(new int[] {(int)(szer*0.95-szer*0.02),(int)(szer*0.95-szer*0.02),(int)((szer*0.95+szer*0.02))},new int[] {(int) (wys/2+0.02*wys),(int) (wys/2-0.02*wys),(int) (((wys/2-0.02*wys)+(wys/2+0.02*wys))/2)},3);
                }   
            }else if(glowka == 3){
                if(szerKlik>(int)(szer*0.05) && szerKlik<(int)(szer-szer*0.05)){
                    // rysuje trojkat kiedy jest w sliderze   
                    g.drawOval((int) (szerKlik-0.02*szer), (int)(wys/2 - 0.02*wys), (int) (0.04*szer),  (int) (0.04*wys));
                    
                }else if(szerKlik<=(int)(szer*0.05)){
                    // rysuje trojkat kiedy jest w powyzej slidera 
                    g.drawOval((int) (szer*0.05-0.02*szer), (int)(wys/2-0.02*wys), (int) (0.04*szer),  (int) (0.04*wys));
                }else{
                    // rysuje trojkat kiedy jest ponizej slidera   
                   g.drawOval((int) (szer*0.95-0.02*szer), (int)(wys/2-0.02*wys), (int) (0.04*szer),  (int) (0.04*wys));
               }  
            }
        }
    }
    /**
     * Przypisuje szerokosc, jaką chcemy przypisać dla położenia suwaka. 
     * @param szer  szerokosc suwaka
    */
    public void setSzer(int szer){
        this.szerKlik = szer;
    }
    /**
     * Zwraca  szerokosc na jaką aktualnie wskazuje suwak.
     * @return      szerokosc suwaka
    */
    public int getSzer(){
        return szerKlik;
    }
    /**
     * Przypisuje wysokosc, jaką chcemy przypisać dla położenia suwaka. 
     * @param wys  wysokosc suwaka
    */
    public void setWys(int wys){
        this.wysKlik = wys;
    }
    /**
     * Zwraca  wysokość na jaką aktualnie wskazuje suwak.
     * @return      wysokość suwaka
    */
    public int getWys(){
        return wysKlik;
    }
    /**
     * Obraca suwak w zależności od jego położenia
    */
    public void Rotate(){
        if(this.rotation==true){
            this.rotation = false;
        }else  this.rotation = true;
    }
    /**
     * Przypisuje  wartość, jaką chcemy przypisać suwakowi. 
     * @param wartosc  wartość
    */
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
    /**
     * Zwraca  wartość na jaką aktualnie wskazuje suwak.
     * @return      wartość
    */
    public int getWartosc(){
        return this.wartosc;
    }
    /**
     * Przypisuje minimalną wartość, jaką chcemy przypisać suwakowi. 
     * @param minimum  minimalna wartość
    */
    public void setMinimum(String minimum){
        this.poczatek = minimum;
    }
    /**
     * Zwraca minimalną możliwą wartość jaką możemy otrzymać na suwaku.
     * @return      minimalna wartość
    */
    public String getMinimum(){
        return poczatek;
    }
    /**
     * Przypisuje maksymalną wartość, jaką chcemy przypisać suwakowi. 
     * @param maksimum  maksymalna wartość
    */
    public void setMaksimum(String maksimum){
        this.koniec = maksimum;
    }
    /**
     * Zwraca maksymalną możliwą wartość jaką możemy otrzymać na suwaku.
     * @return      maksymalna wartość
    */
    public String getMaksimum(){
        return koniec;
    }
    /**
     * Przypisuje kolor, jaki chcemy przypisać suwakowi. 
     * @param kolor  numer główki.
    */
    public void setKolor(String kolor){
        this.kolor = kolor;
    }
    /**
     * Zwraca kolor suwaka, który jest w danej chwili wykorzystany.
     * @return      nazwa koloru
    */
    public String getKolor(){
        return kolor;
    }
    /**
     * Przypisuje numer główki, który chcemy wykorzystać na suwaku. 
     * @param glowka  numer główki
    */
    public void setGlowka(int glowka){
        this.glowka = glowka;
    }
    /**
     * Zwraca numer główki, który jest w danej chwili wykorzystany do suwaka.
     * @return      numer główki
    */
    public int getGlowka(){
        return glowka;
    }
}

