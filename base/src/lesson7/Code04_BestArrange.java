package lesson7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_BestArrange {

    public static class Program {
        public int start;
        public int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end-o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs,new ProgramComparator());
        int rest=0;
        for (int index = 0; index < programs.length; index++) {
            if (start <= programs[index].end){
                rest++;
                start = programs[index].end;
            }
        }
        return rest;
    }

}
