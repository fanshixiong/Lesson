using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace Test
{
    public partial class frmTest : Form
    {
        public frmTest()
        {
            InitializeComponent();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            //lstInfo.Items.Clear();
            //lstInfo.Items.Add("aaaa1");
            //lstInfo.Items.Add("aaaa2");
            //lstInfo.Items.Add("aaaa3");
            String path = "D:\\0000人机交互";
            String[] Dirs = Directory.GetDirectories(path);
            String[] Files = Directory.GetFiles(path);
            lstInfo.Items.Clear();
            for (int i = 0; i < Dirs.Count(); i++)
                lstInfo.Items.Add(Dirs[i]);
            for (int i = 0; i < Files.Count(); i++)
                lstInfo.Items.Add(Files[i]);
        }
    }
}
