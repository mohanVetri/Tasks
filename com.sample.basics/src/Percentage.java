public class Percentage {
    public static void main(String[] args) {
        int count33=0;
        int countg33=0;
        int count41=0;
        int count51=0;
        int count61=0;
        int count71=0;
        int count81=0;
        int count91=0;
        int[] marks={400,357,376,393,370,362};
        for(int i=0;i<marks.length;i++){
            int mark=(marks[i]*100)/400;
            System.out.println(mark);
            if(mark<33){
                ++count33;
            }
            else if(mark>=33 && mark <=40){
            ++countg33;
            }
            else if(mark>=41 && mark <=50){
            ++count41;
            }
            else if(mark>=51 && mark <=60){
            ++count51;
            }
            else if(mark>=61 && mark <=70){
                ++count61;
            }
            else if(mark>=71 && mark <=80){
                ++count71;
            }
            else if(mark>=81 && mark <=90){
                ++count81;
            }
            else if(mark>=91 && mark <=100){
                ++count91;
            }
        }
        System.out.println("no of students >33 is "+count33);
        System.out.println("no of students <33 is "+countg33);
        System.out.println("no of students 41 is "+count41);
        System.out.println("no of students 51 is "+count51);
        System.out.println("no of students 61 is "+count61);
        System.out.println("no of students 71 is "+count71);
        System.out.println("no of students 81 is "+count81);
        System.out.println("no of students 91 is "+count91);

    }
}
