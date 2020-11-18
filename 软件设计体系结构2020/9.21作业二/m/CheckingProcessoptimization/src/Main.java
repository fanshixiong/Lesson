import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Machine> machines = new ArrayList<>();
        MachineInit(machines);
        for(int i=0;i<machines.size();i++)
            machines.get(i).printMachineInfo();

    }
    public static void  MachineInit(List<Machine> machines){
        Map<String,Integer> m1_map = new HashMap<>();
        m1_map.put("p1",7);m1_map.put("p2",5);m1_map.put("p3",4);
        Machine m1 = new Machine("GTX2000",m1_map);
        machines.add(m1);

        Map<String,Integer> m2_map = new HashMap<>();
        m2_map.put("p1",10);m2_map.put("p3",7);
        Machine m2 = new Machine("FLT5700",m2_map);
        machines.add(m2);

        Map<String,Integer> m3_map = new HashMap<>();
        m3_map.put("p2",9);m3_map.put("p3",3);m3_map.put("p4",8);
        Machine m3 = new Machine("VEA5700",m3_map);
        machines.add(m3);
    }
}
