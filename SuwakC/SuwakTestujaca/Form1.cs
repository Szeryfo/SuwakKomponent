using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SuwakTestujaca
{
    public partial class Form1 : Form
    {


        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            suwak1.setRotate();
            suwak1.Refresh();
            label2.ResetText();
        }

        private void suwak1_Load(object sender, EventArgs e)
        {
            suwak1.MouseDown += new MouseEventHandler(suwak1_MouseDown);
            suwak1.MouseMove += new MouseEventHandler(suwak1_MouseMove);
        }

        private void suwak1_MouseClick(object sender, MouseEventArgs e)
        {
            suwak1.setKlik(e.X, e.Y);
            suwak1.Refresh();
            suwak1.setWartosc();
            label2.Text = Convert.ToString(suwak1.getWartosc());
        }

        private void suwak1_MouseMove(object sender, MouseEventArgs e)
        {
            if(suwak1.getFlag() == true)
            {
                suwak1.setKlik(e.X, e.Y);
                suwak1.Refresh();
                suwak1.setWartosc();
                label2.Text = Convert.ToString(suwak1.getWartosc());
            }
            
        }

        private void suwak1_MouseDown(object sender, MouseEventArgs e)
        {
            suwak1.setFlagTrue();
        }

        private void suwak1_MouseUp(object sender, MouseEventArgs e)
        {
            suwak1.setFlagFlase();
        }
    }
}
