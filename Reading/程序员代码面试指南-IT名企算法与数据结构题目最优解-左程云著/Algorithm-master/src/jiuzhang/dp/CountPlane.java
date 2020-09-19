package jiuzhang.dp;

import java.util.*;

/**
 * 数飞机
 * Created by Dell on 2017-08-20.
 */
public class CountPlane {

      public class Interval {
          int start, end;
          Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }
        public int countOfAirplanes(List<Interval> airplanes) {
            // write your code here
            ArrayList<Event> list=new ArrayList<>();
            for (Interval plane:airplanes){
                list.add(new Event(plane.start,1));
                list.add(new Event(plane.end,0));
            }
            Collections.sort(list,Event.getComparator());
            int cur=0;int max=0;
            Event curEvent;
            for(int i=0;i<list.size();i++){
                curEvent=list.get(i);
                if(curEvent.flag==1){
                    cur++;
                }else{
                    cur--;
                }
                max=Math.max(max,cur);
            }
            return max;
        }

        public static class Event{
          int time;
          int flag;

            public Event(int time, int flag) {
                this.time = time;
                this.flag = flag;
            }
            public static Comparator<Event> getComparator(){
                return new Comparator<Event>() {
                    @Override
                    public int compare(Event o1, Event o2) {
                        if(o1.time!=o2.time){
                            return o1.time-o2.time;
                        }
                        return o1.flag-o2.flag;
                    }
                };
            }
        }
}
