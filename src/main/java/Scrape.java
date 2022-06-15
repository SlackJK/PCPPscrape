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
    private ScrapeHelp SH = null;
    private String Url = "";
    private ArrayList<String> Buttons = null;
    private String AllButton = "";
    private ArrayList<String> ClassNames = null;
    private ArrayList ImportantButton;

    public  Scrape(String Url, ArrayList<String> Buttons , ArrayList<String> ClassNames, ArrayList ImportantButton) throws IOException, InterruptedException
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
            AllButton = Buttons.get((int)ImportantButton.get(2));
            return IterateThroughOptions(ClassNames,ImportantButton.get(0).toString(),ImportantButton.get(1).toString(),AllButton);
        }
        return AggregateData(ClassNames,"");
    }
    public ArrayList<ArrayList<String>> AggregateData(ArrayList<String> ClassNames, String ImportantButton) throws IOException, InterruptedException
    {
        ArrayList<ArrayList<String>> Out = new ArrayList<>();
        Elements Pages = SH.doc.getElementsByClass("pagination list-unstyled xs-text-center").get(0).getElementsByAttributeValueContaining("href","#");
        int PageCount = Integer.valueOf(Pages.get(Pages.size()-1).text());
        ArrayList<ArrayList<String>> OutArrayList = new ArrayList<>();
        for (int i = 1; i < PageCount; i++)
        {
            if(i>1)
            {
                SH = new ScrapeHelp(Url+"#page="+i,Buttons);
                TimeUnit.SECONDS.sleep(1);
                if(this.ImportantButton.size()>0)
                {
                    SetOptions(ImportantButton,AllButton);
                }
                Out.addAll(ScrapePCPP(SH.doc, ClassNames, ImportantButton));
            }
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
    public ArrayList<ArrayList<String>> IterateThroughOptions(ArrayList<String> ClassNames,String Button,String ButtonGroupId,String AllButton) throws InterruptedException, IOException//dont put a numerical end to the bitton name
    {
        int OptionNum = SH.doc.getElementById(ButtonGroupId).getElementsByClass("checkbox filteritem").size();
        ArrayList<ArrayList<String>> Out = new ArrayList<>();
        for (int i = 1; i < OptionNum; i++)
        {
            if(i == 1)
            {
                SetOptions(Button+i,AllButton);
                Out.addAll(AggregateData(ClassNames,Button+i));
            }
            else
            {
                SetOptions(Button+i,Button+(i-1));
                Out.addAll(AggregateData(ClassNames,Button+i));
            }
            TimeUnit.SECONDS.sleep(5);
        }
        return Out;
    }
    public void SetOptions(String OptionID,String PreviousOptionID) throws InterruptedException
    {
        HtmlCheckBoxInput prev = SH.htmlPage.getHtmlElementById(PreviousOptionID);
        SH.htmlPage = (HtmlPage) prev.setChecked(false);
        TimeUnit.MILLISECONDS.sleep(900);

        HtmlCheckBoxInput cur = SH.htmlPage.getHtmlElementById(OptionID);
        SH.htmlPage = (HtmlPage) cur.setChecked(true);
        TimeUnit.MILLISECONDS.sleep(900);

        SH.doc = Jsoup.parse(SH.htmlPage.asXml());
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
