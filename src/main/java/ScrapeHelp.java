import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScrapeHelp//Cpus "m_all","R_all","s_all","F_all","f_all","k_all","g_all","h_all","e_all"
{
    public Document doc = null;
    WebClient webClient = new WebClient(BrowserVersion.CHROME);
    public ScrapeHelp(String URL,ArrayList<String> Buttons) throws IOException, InterruptedException
    {
        webClient.getOptions().setJavaScriptEnabled(true);
        HtmlPage x = webClient.getPage(URL);
        x = InitializePCPartPickerPage(x,Buttons);
        this.doc= Jsoup.parse(x.asXml());
    }
    public HtmlPage InitializePCPartPickerPage(HtmlPage Out, ArrayList<String> Buttons) throws InterruptedException
    {
        System.out.println("Initializing Buttons for PCPP page...");
        for (int i = 0; i <Buttons.size(); i++)
        {
            HtmlCheckBoxInput InitializeSite = Out.getHtmlElementById(Buttons.get(i));
            Out = (HtmlPage) InitializeSite.setChecked(true);
            System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());
            TimeUnit.MILLISECONDS.sleep(900);
        }
        return Out;
    }
    public static void SetProxy(String IP,String Port)
    {
        System.setProperty("https.proxyHost", IP);//specify the proxy host (ip address)
        System.setProperty("https.proxyPort", Port);//specify the proxy port
    }
    public static ArrayList<String> FindEachClass(Document doc, String ClassName)
    {
        ArrayList<String> Out = new ArrayList<>();
        Elements DataSet = doc.getElementsByClass(ClassName);
        for (int i = 0; i < DataSet.size(); i++)
        {
            Out.add(DataSet.get(i).text());
        }
        System.out.println(Out);
        return Out;
    }
    public static ArrayList<String> Fill2dArrayListWithRepeating(int size2d1d,String RepeatME)
    {
        ArrayList<String> OutArrayList = new ArrayList<>();
        for (int i = 0; i < size2d1d; i++)
        {
            OutArrayList.add(RepeatME);
        }
        return OutArrayList;
    }
}
/*Legacy---------------------------------------------------------

        //Manufacturer
        HtmlCheckBoxInput InitializeSite = x.getHtmlElementById("m_all");
        System.out.println(InitializeSite.isChecked());
        HtmlPage Out = (HtmlPage) InitializeSite.setChecked(true);

        TimeUnit.MILLISECONDS.sleep(900);

        //Ratings
        InitializeSite = Out.getHtmlElementById("R_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Series
        InitializeSite = Out.getHtmlElementById("s_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //MicroArchitecture
        InitializeSite = Out.getHtmlElementById("F_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Core Family
        InitializeSite = Out.getHtmlElementById("f_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Socket
        InitializeSite = Out.getHtmlElementById("k_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Integrated Graphics
        InitializeSite = Out.getHtmlElementById("g_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //SMT
        InitializeSite = Out.getHtmlElementById("h_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //ECC Support
        InitializeSite = Out.getHtmlElementById("e_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());
 */
