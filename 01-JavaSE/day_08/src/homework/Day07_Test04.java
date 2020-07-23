package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
案例：
声明一个日期类MyDate，包含属性：年、月、日，并在MyDate类中声明几个方法：
1、boolean isLeapYear()：判断当前日期的是闰年吗？
2、void set(int y, int m, int d)：修改年，月，日为新日期
3、void plus(int y, int m, int d)：修改当前日期为加了y年，m月，d天后的日期
 	例如：2019年5月21日，  plus(1,1,1)==>2020年6月22日
 	例如：2019年5月21日，  plus(1,1,20)==>2020年7月11日
*/
class Day07_Test04{
    public static void main(String[] args){
        MyDate my = new MyDate();
        my.year = 2019;
        my.month = 5;
        my.day = 21;

        //my.plus(1,1,1);
        //my.plus(1,1,20);
        //my.plus(1,30,70);
        System.out.println(my.year + "年" + my.month + "月" + my.day);
    }
}
class MyDate{
    int year;
    int month;
    int day;

    boolean isLeapYear(){
        if(year%4==0 && year%100!=0 || year%400==0){
            return true;//如果if条件满足，从这里就把true返回并结束当前方法
        }
        return false;
    }
    //用y,m,d为当前对象的year,month,day属性赋值
    void set(int y, int m, int d){
        year = y;
        month = m;
        day = d;
    }
    //有点难度呢
    //在当前日期的基础上，加上y年，m月，d天
    void plus(int y, int m, int d){
        day += d;
        month += m;
        year += y;

        while(true){
            if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10){
                if(day>31){
                    day -= 31;
                    month++;
                }
            }else if(month==4 || month==6 || month==9 || month==11){
                if(day>30){
                    day -= 30;
                    month++;
                }
            }else if(month==2){
                if(year%4==0 && year%100!=0 || year%400==0){
                    if(day>29){
                        day -= 29;
                        month++;
                    }
                }else{
                    if(day>28){
                        day-=28;
                        month++;
                    }
                }
            }else if(month == 12){
                if(day>31){
                    day-=31;
                    month=1;
                    year++;
                }
            }else if(month>12){
                while(month>12){
                    month -= 12;
                    year++;
                }
            }

            if(month>=1 && month<=12){
                if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                    if(day<=31){
                        break;
                    }
                }else if(month==4 || month==6 || month==9 || month==11){
                    if(day<=30){
                        break;
                    }
                }else if(month==2){
                    if(year%4==0 && year%100!=0 || year%400==0){
                        if(day<=29){
                            break;
                        }
                    }else{
                        if(day<=28){
                            break;
                        }
                    }
                }
            }
        }
    }
}