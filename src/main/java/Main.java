import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static String Url = "https://pcpartpicker.com/products/cpu/";
    public static String test ="https://www.bazos.sk/";
    public static ArrayList empty = new ArrayList();
    public static ArrayList<String> CPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","s_all","F_all","f_all","k_all","g_all","h_all","e_all"));
    public static ArrayList<String> CPUImportantButtons = new ArrayList<>(Arrays.asList("#k=27","#k=2","#k=3","#k=4","#k=33","#k=32","#k=20","#k=23","#k=26","#k=31","#k=12","#k=13","#k=24","#k=30","#k=14","#k=15","#k=39","#k=37","#k=16","#k=40","#k=21","#k=28","#k=35","#k=36","#k=38"));
    public static ArrayList<String> GPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","c_all","T_all","c0_all","Y_all","s_all","A_all","N_all","Q_all"));//
    public static ArrayList<String> GPUCPURAMStorageCaseMonitorClassNames= new ArrayList<>(Arrays.asList("td__nameWrapper","td__spec td__spec--1","td__spec td__spec--2","td__spec td__spec--3","td__spec td__spec--4","td__spec td__spec--5","td__spec td__spec--6","td__price"));
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Scrape S = new Scrape(Url,CPUSButtons,GPUCPURAMStorageCaseMonitorClassNames,CPUImportantButtons);
        //System.out.println(S.GetData());
        /*
        //S.SetOptions("k_fi4","k_all");
        System.out.println(S.SH.doc);
        System.out.println();
        */
        ArrayList<ArrayList<String>> x = S.ScrapePCPP(S.SH.doc, GPUCPURAMStorageCaseMonitorClassNames, CPUImportantButtons.get(0));
        GPUCPURAMStorageCaseMonitorClassNames.add("Socket");
        x.add(0,GPUCPURAMStorageCaseMonitorClassNames);
        ScrapeHelp.WriteCSV("PCPPTestDump","E:\\SQLCSVS",x);

    }
}
