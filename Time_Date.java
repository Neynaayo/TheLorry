 public class Time_Date
{   private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;
    
    public Time_Date(){
        day=0;
        month=0;
        year=0;
        hour=0;
        minutes=0;
    }
    public Time_Date(int d, int m, int y,int h,int mn){
        day=d;
        month=m;
        year=y;
        hour=h;
        minutes=mn;
    }
    
    public void setTime_Date(int d, int m, int y, int h,int mn){
        day=d;
        month=m;
        year=y;
        hour=h;
        minutes=mn;
    }
    
    public int getDay(){return day;}
    public int getMonth(){return month;}
    public int getYear(){return year;}
    public int getHour(){return hour;}
    public int getMinute(){return minutes;}
    
    public String toString(){
        return (day+"/"+month+"/"+year + 
                "\n"+hour +":" + minutes);
    }
}