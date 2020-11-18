import java.util.List;
import java.util.Map;

public class Machine {
    public String id;
    public Map<String,Integer> project;
    public List<String> patientlist;

    Machine(String id,Map<String,Integer> project){
       this.id = id;
       this.project = project;
    }

    public void printMachineInfo(){
        System.out.println("机器编号："+this.id);
        for (Map.Entry<String, Integer> entry : project.entrySet()) {
            System.out.println("可做项目:" + entry.getKey() + "  花费时间:" + entry.getValue());
        }
    }
}
