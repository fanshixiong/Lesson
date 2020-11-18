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
        private List<clsDir> Dirs;
        private String[] Files;
        public clsDir(String path)
        {
            String []folders= Directory.GetDirectories(path);
            Dirs=new  List<clsDir>();
            for (int i = 0; i < folders.Count(); i++)
                Dirs.Add(new clsDir(folders[i]));
            Files = Directory.GetFiles(path);
        }
        public void  Output(ListBox lstInfo)
        {
            for (int i = 0; i < Dirs.Count(); i++)
                Dirs[i].Output(lstInfo) ;
            for (int i = 0; i < Files.Count(); i++)
                lstInfo.Items.Add(Files[i]);
        }
        public int Depth()
        {
            return 0;
        }
        public int Count()
        {
            return 0;
        }
        public List<String> Search(String patter)
        {
            List<String> res = new List<String>();
            return res;
        }
    }
}
