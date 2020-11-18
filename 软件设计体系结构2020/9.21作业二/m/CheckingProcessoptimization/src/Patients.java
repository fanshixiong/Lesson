import java.util.ArrayList;
import java.util.List;

public class Patients {
    public String id;
    public List<String> project = new ArrayList<>();;

    Patients(String id,List<String>project){
        this.project=project;
        this.id=id;
    }
    void getPatientsinform()
    {
         System.out.print("患者："+id+" 项目：");
         for(int i=0;i<project.size();i++)
                System.out.print(project.get(i)+" ");
    }
    void sortPatientsprojects()
    {
        
    }
}
