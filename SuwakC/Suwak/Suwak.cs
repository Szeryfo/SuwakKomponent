using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;

namespace Suwak
{
    public partial class Suwak : UserControl
    {
        Boolean rotation = true;
        String poczatek = "0";
        String koniec = "100";
        int wartosc;
        int szerKlik = 50;
        int wysKlik = 50;
        int szer;
        int wys;
        Font font = new Font("Arial", 12);
        Boolean flag = false;

        protected override void OnPaint(PaintEventArgs e){

            Pen pen = new Pen(Color.Black);
            
            if(rotation == false)
                //Pion
            {
                //Linie pionowe
                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer / 2 - 0.01 * szer),
                    Convert.ToInt32(wys * 0.05),
                    Convert.ToInt32(szer / 2 - 0.01 * szer),
                    Convert.ToInt32(wys - wys * 0.05));

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer / 2 + 0.01 * szer),
                    Convert.ToInt32(wys * 0.05),
                    Convert.ToInt32(szer / 2 + 0.01 * szer),
                    Convert.ToInt32(wys - wys * 0.05));
                //Linie poziome
                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer / 2 - 0.01 * szer),
                    Convert.ToInt32(wys * 0.05),
                    Convert.ToInt32(szer / 2 + 0.01 * szer),
                    Convert.ToInt32(wys * 0.05));

                e.Graphics.DrawLine(pen,
                   Convert.ToInt32(szer / 2 - 0.01 * szer),
                   Convert.ToInt32(wys - wys * 0.05),
                   Convert.ToInt32(szer / 2 + 0.01 * szer),
                   Convert.ToInt32(wys - wys * 0.05));
                //Wartośći liczb należące do początkowej i końcowej wartości
                e.Graphics.DrawString(koniec, this.Font, Brushes.Black,
                    Convert.ToInt32(szer / 2 + 0.1 * szer), Convert.ToInt32(wys * 0.05));

                e.Graphics.DrawString(poczatek, this.Font, Brushes.Black,
                    Convert.ToInt32(szer / 2 + 0.1 * szer), Convert.ToInt32(wys * 0.90));
                // - na suwaku
                for (int i = 1; i < 4; i++)
                {
                    int x = (wys - wys / 50) - (wys / 50);
                    x = x / 4;
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 + 0.05 * szer),
                        Convert.ToInt32(wys / 50 + x * i),
                        Convert.ToInt32(szer / 2 + 0.07 * szer),
                        Convert.ToInt32(wys / 50 + x * i));
                }

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer / 2 + 0.05 * szer),
                    Convert.ToInt32(wys * 0.05),
                    Convert.ToInt32(szer / 2 + 0.07 * szer),
                    Convert.ToInt32(wys * 0.05));

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer / 2 + 0.05 * szer),
                    Convert.ToInt32(wys - wys * 0.05),
                    Convert.ToInt32(szer / 2 + 0.07 * szer),
                    Convert.ToInt32(wys - wys * 0.05));

                if (wysKlik > Convert.ToInt32(wys * 0.05) && wysKlik < Convert.ToInt32(wys - wys * 0.05))
                {
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wysKlik - wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wysKlik - wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wysKlik + wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wysKlik + wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wysKlik - wys * 0.02),
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wysKlik + wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wysKlik + wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wysKlik - wys * 0.02));
                }
                else if (wysKlik <= Convert.ToInt32(wys * 0.05))
                {
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 - wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 - wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 + wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 + wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 - wys * 0.02),
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 + wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 + wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.05 - wys * 0.02));
                }
                else
                {
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 - wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 - wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 + wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 + wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 - wys * 0.02),
                        Convert.ToInt32(szer / 2 - 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 + wys * 0.02));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 + wys * 0.02),
                        Convert.ToInt32(szer / 2 + 0.02 * szer),
                        Convert.ToInt32(wys * 0.95 - wys * 0.02));
                }
            } else if(rotation == true)
            {
                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer * 0.05),
                    Convert.ToInt32(wys / 2 - 0.01 * wys),
                    Convert.ToInt32(szer - szer * 0.05),
                    Convert.ToInt32(wys / 2 - 0.01 * wys));

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.01 * wys),
                    Convert.ToInt32(szer - szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.01 * wys));

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer * 0.05),
                    Convert.ToInt32(wys / 2 - 0.01 * wys),
                    Convert.ToInt32(szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.01 * wys));

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer - szer * 0.05),
                    Convert.ToInt32(wys / 2 - 0.01 * wys),
                    Convert.ToInt32(szer - szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.01 * wys));

                e.Graphics.DrawString(poczatek, this.Font, Brushes.Black,
                    Convert.ToInt32(szer * 0.05), Convert.ToInt32(wys / 2 + 0.15 * wys));

                e.Graphics.DrawString(koniec, this.Font, Brushes.Black,
                    Convert.ToInt32(szer - szer * 0.1), Convert.ToInt32(wys / 2 + 0.15 * wys));

                for(int i = 1; i < 4; i++)
                {
                    int x = (szer - szer / 50) - (szer / 50);
                    x = x / 4;
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer / 50 + x * i),
                        Convert.ToInt32(wys / 2 + 0.05 * wys),
                        szer / 50 + x * i,
                        Convert.ToInt32(wys / 2 + 0.07 * wys));
                }

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.05 * wys),
                    Convert.ToInt32(szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.07 * wys));

                e.Graphics.DrawLine(pen,
                    Convert.ToInt32(szer - szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.05 * wys),
                    Convert.ToInt32(szer - szer * 0.05),
                    Convert.ToInt32(wys / 2 + 0.07 * wys));

                if (szerKlik > Convert.ToInt32(szer * 0.05) && szerKlik < Convert.ToInt32(szer * 0.95))
                {
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szerKlik - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szerKlik - szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szerKlik + szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szerKlik + szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szerKlik - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szerKlik + szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szerKlik + szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys),
                        Convert.ToInt32(szerKlik - szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));
                }
                else if (szerKlik <= Convert.ToInt32(szer * 0.05))
                {
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.05 - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szer * 0.05 - szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.05 - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szer * 0.05 + szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.05 - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szer * 0.05 + szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.05 + szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys),
                        Convert.ToInt32(szer * 0.05 - szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));
                }
                else
                {
                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.95 - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szer * 0.95 - szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.95 - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szer * 0.95 + szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.95 - szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys),
                        Convert.ToInt32(szer * 0.95 + szer * 0.02),
                        Convert.ToInt32(wys / 2 - 0.02 * wys));

                    e.Graphics.DrawLine(pen,
                        Convert.ToInt32(szer * 0.95 + szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys),
                        Convert.ToInt32(szer * 0.95 - szer * 0.02),
                        Convert.ToInt32(wys / 2 + 0.02 * wys));
                }
            }

            
            
           
        }

        public void setKlik(int szer, int wys)
        {
            this.wysKlik = wys;
            this.szerKlik = szer;
        }

        public void setRotate()
        {
            if(this.rotation == true)
            {
                this.rotation = false;
            } else
            {
                this.rotation = true;
            }
        }

        public void setWartosc()
        {
            if(this.rotation == true)
            {
                if(szerKlik > Convert.ToInt32(szer * 0.05) && szerKlik < Convert.ToInt32(szer * 0.95))
                {
                    int szerokosc = Convert.ToInt32(this.szer * 0.95);
                    int roznica = Convert.ToInt32(this.koniec) - Convert.ToInt32(this.poczatek);
                    this.wartosc = (this.szerKlik - Convert.ToInt32(this.szer * 0.05)) * roznica / szerokosc;
                    this.wartosc += Convert.ToInt32(this.poczatek);
                } else if(szerKlik <= Convert.ToInt32(szer * 0.05))
                {
                    this.wartosc = Convert.ToInt32(this.poczatek);
                } else
                {
                    this.wartosc = Convert.ToInt32(this.koniec);
                }
            } else
            {
                if (wysKlik > Convert.ToInt32(wys * 0.05) && wysKlik < Convert.ToInt32(wys * 0.95))
                {
                    int wysokosc = Convert.ToInt32(this.wys * 0.95);
                    int roznica = Convert.ToInt32(this.koniec) - Convert.ToInt32(this.poczatek);
                    this.wartosc = (this.wysKlik - Convert.ToInt32(this.wys * 0.05)) * roznica / wysokosc;
                    this.wartosc += Convert.ToInt32(this.poczatek);
                    this.wartosc = this.wartosc * -1 + Convert.ToInt32(this.koniec) + Convert.ToInt32(this.poczatek);
                } else if(wysKlik <= Convert.ToInt32(wys * 0.05))
                {
                    this.wartosc = Convert.ToInt32(this.koniec);
                } else
                {
                    this.wartosc = Convert.ToInt32(this.poczatek);
                }
            }
        }

        public int getWartosc()
        {
            return this.wartosc;
        }

        public void setFlagTrue()
        {
            flag = true;
        }

        public void setFlagFlase()
        {
            flag = false;
        }

        public Boolean getFlag()
        {
            return this.flag;
        }

        public Suwak()
        {
            InitializeComponent();
        }

        public Suwak(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        private void Suwak_Resize(object sender, EventArgs e)
        {
            this.wys = this.Height;
            this.szer = this.Width;

        }
    }
}
