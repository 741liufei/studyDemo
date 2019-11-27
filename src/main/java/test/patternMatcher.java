package test;

import java.awt.datatransfer.StringSelection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java 正则表达式的匹配
 * Created by feis.liu on 2018/6/11.
 */
public class patternMatcher {

    public static  void main(String[] args){
        String select = "[04 20 00:00:01]>> QueryFRoundwayList:key=2016-04-20 00:00:00.694&cid=C1001&uid=1DE40543-D0B5-4DCB-9012-8F0C3A4B85EA&gid=3899DFF3-CCC5-8BD9-7B93-4BB2FCD06A0E&pid=10010&vid=80011109&msg=&aid=470E61A7-AD1F-4F3B-96D7-4ECF74927F63&ma=02:00:00:00:00:00&model=iPhone5,1&osVersion=9.1&sid=49E01081-2BDF-29AA-783C-F79073ECA6D8&t=f_froundwaylist&ip=117.73.142.187&adid=&iid=1DE40543-D0B5-4DCB-9012-8F0C3A4B85EA&username=jbwpvnq2814&nt=wifi&mno=46001&port=52995&ref=|FSearchInterDoubleCustomVC|FSearchDoubleVC|&brush={\"lt\":0}&latLog=&lgtLog=&catom=&atomId=0&cas=&cat=&begin=北京&end=香港&goDate=2016-10-01&backDate=2016-10-05&start=0&count=15&sort=5&aline=&timeArea=&planeDesc=&retTimeArea=&more=-1&retTransCities=&outTransCities=&transCities=&filterTitle=&filterValue=&foutFlightNo=CA111&fretFlightNo=&statisticLog=&cat=&depAirport=&arrAirport=&priceSortType=2&lowestPrice=0&rate=&times=0&queryId=-1&prequeryId=&searchType=4&isChangeDate=false&isPart=true&foutFlightArrDate=&foutFlightArrTime=&foutSearchId=&firstRequest=true&allFilters=&language=&isSearchDebug=0&flights=[]&interflights=[{type=0&minPrice=1644&tax=191&flightTime=&totalPrice=1644&tag=&goFlightBaseLog=[]&backFlightBaseLog=[]&},{type=0&minPrice=3843&tax=266&flightTime=&totalPrice=3843&tag=&goFlightBaseLog=[]&backFlightBaseLog=[]&},{type=0&minPrice=4008&tax=266&flightTime=&totalPrice=4008&tag=&goFlightBaseLog=[]&backFlightBaseLog=[]&},{type=0&minPrice=4274&tax=225&flightTime=&totalPrice=4274&tag=&goFlightBaseLog=[]&backFlightBaseLog=[]&},{type=0&minPrice=4574&tax=266&flightTime=&totalPrice=4574&tag=&goFlightBaseLog=[]&backFlightBaseLog=[]&}]&isInter=1&refreshTime=2&times=10&rate=98.92;98.59;98.59;87.07&lowestPrice=1644&queryId=10.86.218.210:34f3af7a:1542f1d8ead:-3ad8;10.86.218.210:34f3af7a:1542f1d8ead:-3ad7;10.86.218.210:34f3af7a:1542f1d8ead:-3ad6&recFlightInfo=&isGrab=false&isPart=true&bstatus=0&bstatsDes=查询成功!&hotDogRunTime=1016&hotDogDataSize=12178&traceId=1461081600kaDVpVZG1N7_f_froundwaylist";
         final  String qsearchRegPattern = "\\[(\\d*\\s\\d*\\s\\d*:\\d*:\\d*)\\](\\sQTraceId\\[.*\\]\\s)?>>\\s([^:]*):(.*)";


        String line = "This order was placed for ! OK? QT3000";
        String pattern = "(\\D*)(\\d+)(.*)";
        String match = getGroupValue(line,pattern);
        System.out.println(match);
    }


    public static String getGroupValue(String pramas, String reg) {
        try {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(pramas);
            if (matcher.find()) {
                for(int i =0;i<matcher.groupCount()+1;i++){
                    System.out.println("匹配上的词组为："+matcher.group(i));
                }
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    public static String getGroupValue(String pramas, String reg, int group) {
        try {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(pramas);
            if (matcher.find()) {
                return matcher.group(group);
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
}
