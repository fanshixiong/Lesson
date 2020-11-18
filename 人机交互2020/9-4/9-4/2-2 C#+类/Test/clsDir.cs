using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Windows.Forms;

namespace Test
{
    class clsDir
    {
        private String[] Dirs;
        private String[] Files;
        public clsDir(String path)
        {
            Dirs = Directory.GetDirectories(path);
            Files = Directory.GetFiles(path);
        }
        public void  Output(ListBox lstInfo)
        {
            lstInfo.Items.Clear();
            for (int i = 0; i < Dirs.Count(); i++)
                lstInfo.Items.Add(Dirs[i]);
            for (int i = 0; i < Files.Count(); i++)
                lstInfo.Items.Add(Files[i]);
        }
    }
}
