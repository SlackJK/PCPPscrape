import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Scrape
{
    public static ArrayList<ArrayList<String>> GetData(String Url, ArrayList<String> Buttons , ArrayList<String> ImportantButtons) throws IOException, InterruptedException
    {
        ScrapeHelp SH = new ScrapeHelp(Url,Buttons);
        Elements Pages = SH.doc.getElementsByClass("pagination list-unstyled xs-text-center").get(0).getElementsByAttributeValueContaining("href","#");
        int PageCount = Integer.valueOf(Pages.get(Pages.size()-1).text());
        ArrayList<ArrayList<String>> OutArrayList = new ArrayList<>();
        for (int i = 0; i < PageCount; i++) {

        }
        return null;
    }
    private static ArrayList<ArrayList<String>> ScrapePCPP(Document doc, ArrayList<String> ClassNames, ArrayList<String> ImportantButtons, int index)
    {
        ArrayList<ArrayList<String>> OutArrayList = new ArrayList<>();
        for (int i = 0; i < ClassNames.size(); i++)
        {
            OutArrayList.add(ScrapeHelp.FindEachClass(doc,ClassNames.get(i)));
        }
        if(ImportantButtons.size()>0)
        {
            OutArrayList.add(ScrapeHelp.Fill2dArrayListWithRepeating(OutArrayList.get(0).size(),ImportantButtons.get(index)));
        }
        return OutArrayList;
    }
    /*
    public static ArrayList<ArrayList<String>> GetCpuData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetCpuCoolerData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetMoboData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetRamData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetStorageData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetGpuData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetCaseData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetPsuData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetOSData(String Url, ArrayList<String> Buttons)
    {

    }
    public static ArrayList<ArrayList<String>> GetMonitorData(String Url, ArrayList<String> Buttons)
    {

    }

     */
}
