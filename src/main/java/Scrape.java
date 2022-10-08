import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Scrape
{
    public ScrapeHelp SH = null;
    public String Url = "";
    public ArrayList<String> Buttons = null;
    public String AllButton = "";
    public ArrayList<String> ClassNames = null;
    public ArrayList ImportantButton = null;

    public  Scrape(String Url, ArrayList<String> Buttons , ArrayList<String> ClassNames, ArrayList<String> ImportantButton) throws IOException, InterruptedException
    {
        SH = new ScrapeHelp(Url, Buttons);
        this.Url = Url;
        this.Buttons = Buttons;
        this.ClassNames = ClassNames;
        this.ImportantButton = ImportantButton;
    }
    public  ArrayList<ArrayList<String>> GetData() throws IOException, InterruptedException
    {
        if(ImportantButton.size()>0)
        {
            return IterateThroughOptions(ClassNames, ImportantButton);
        }
        return AggregateData(ClassNames,"");
    }
    public ArrayList<ArrayList<String>> AggregateData(ArrayList<String> ClassNames, String ImportantButtons) throws IOException, InterruptedException
    {
        ArrayList<ArrayList<String>> Out = new ArrayList<>();
        Elements Pages = SH.doc.getElementsByClass("pagination list-unstyled xs-text-center").get(0).getElementsByAttributeValueContaining("href","#");
        int PageCount = 0;
        try {
            PageCount = Integer.valueOf(Pages.get(Pages.size()-1).text());
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> OutArrayList = new ArrayList<>();
        for (int i = 0; i < PageCount; i++)//bug here with length
        {
            if(i>0)
            {
                TimeUnit.SECONDS.sleep(1);
                if(this.ImportantButton.size()>0)
                {
                    SetOptions(ImportantButtons+"&page="+(i+1));
                }
                else
                {
                    SH = new ScrapeHelp(Url + "#page=" + (i+1), Buttons);
                }
                Out = ScrapeHelp.AddEveryRow(Out,ScrapePCPP(SH.doc, ClassNames, ImportantButtons));
            }
            else
            {
                Out.addAll(ScrapePCPP(SH.doc, ClassNames, ImportantButtons));
            }
            System.out.println(Out);
            TimeUnit.SECONDS.sleep(5);
        }

        return Out;
    }
    public ArrayList<ArrayList<String>> ScrapePCPP(Document doc, ArrayList<String> ClassNames, String ImportantButton)
    {
        ArrayList<ArrayList<String>> OutArrayList = new ArrayList<>();
        for (int i = 0; i < ClassNames.size(); i++)
        {
            OutArrayList.add(ScrapeHelp.FindEachClass(doc,ClassNames.get(i)));
        }
        if(ImportantButton.length()>0)
        {
            OutArrayList.add(ScrapeHelp.Fill2dArrayListWithRepeating(OutArrayList.get(0).size(),ImportantButton));
        }
        return OutArrayList;
    }
    public ArrayList<ArrayList<String>> IterateThroughOptions(ArrayList<String> ClassNames,ArrayList<String> ImportantButtons) throws InterruptedException, IOException//dont put a numerical end to the bitton name
    {
        //int OptionNum = SH.doc.getElementById(ButtonGroupId).getElementsByClass("checkbox filteritem").size();
        int OptionNum = ImportantButtons.size();
        ArrayList<ArrayList<String>> Out = new ArrayList<>();
        for (int i = 0; i < OptionNum; i++)
        {
            SetOptions(ImportantButtons.get(i));
            if(i>0)
            {
                Out = ScrapeHelp.AddEveryRow(Out,AggregateData(ClassNames,ImportantButtons.get(i)));
            }
            else
            {
                Out.addAll(AggregateData(ClassNames,ImportantButtons.get(i)));
            }
            TimeUnit.SECONDS.sleep(5);
        }
        return Out;
    }
    public void SetOptions(String OptionID) throws InterruptedException, IOException {

        SH = new ScrapeHelp(Url+OptionID,Buttons);
        TimeUnit.SECONDS.sleep(5);
    }
            /*
        //HtmlCheckBoxInput prev = SH.htmlPage.getHtmlElementById(PreviousOptionID);
        //SH.htmlPage = (HtmlPage) prev.setChecked(false);
        //TimeUnit.MILLISECONDS.sleep(900);

        HtmlCheckBoxInput cur = SH.htmlPage.getHtmlElementById(OptionID);
        SH.htmlPage = (HtmlPage) cur.setChecked(true);
        TimeUnit.MILLISECONDS.sleep(900);

         */
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
