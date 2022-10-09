import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static String CPUUrl = "https://pcpartpicker.com/products/cpu/";
    public static String CPUCoolerUrl = "https://pcpartpicker.com/products/cpu-cooler/";
    public static String MotherboardUrl = "https://pcpartpicker.com/products/motherboard/";
    public static String RAMUrl = "https://pcpartpicker.com/products/memory/";
    public static String StorageUrl = "https://pcpartpicker.com/products/internal-hard-drive/";
    public static String GPUUrl = "https://pcpartpicker.com/products/video-card/";
    public static String CaseUrl = "https://pcpartpicker.com/products/case/";
    public static String PSUUrl = "https://pcpartpicker.com/products/power-supply/";
    public static String OSUrl = "https://pcpartpicker.com/products/os/";
    public static String MonitorUrl = "https://pcpartpicker.com/products/monitor/";


    public static String test ="https://www.bazos.sk/";
    public static ArrayList empty = new ArrayList();

    public static ArrayList<String> CPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","s_all","F_all","f_all","k_all","g_all","h_all","e_all"));
    public static ArrayList<String> CPUImportantButtons = new ArrayList<>(Arrays.asList("#k=27","#k=2","#k=3","#k=4","#k=33","#k=32","#k=20","#k=23","#k=26","#k=31","#k=12","#k=13","#k=24","#k=30","#k=14","#k=15","#k=39","#k=37","#k=16","#k=40","#k=21","#k=28","#k=35","#k=36","#k=38"));

    public static ArrayList<String> CPUCoolerButtons = new ArrayList<>(Arrays.asList("m_all","R_all","Y_all","t_all","c_all","W_all","F_all"));
    public static ArrayList<String> CPUCoolerImportantButtons = new ArrayList<>(Arrays.asList("#m=1", "#m=88", "#m=894", "#m=361", "#m=710", "#m=236", "#m=52", "#m=737", "#m=77", "#m=868", "#m=8", "#m=149", "#m=337", "#m=50", "#m=413", "#m=11", "#m=150", "#m=436", "#m=771", "#m=225", "#m=78", "#m=379", "#m=57", "#m=114", "#m=90", "#m=14", "#m=106", "#m=101", "#m=426", "#m=722", "#m=125", "#m=18", "#m=895", "#m=485", "#m=58", "#m=21", "#m=701", "#m=331", "#m=62", "#m=107", "#m=86", "#m=824", "#m=27", "#m=168", "#m=99", "#m=463", "#m=94", "#m=440", "#m=806", "#m=229", "#m=709", "#m=128", "#m=64", "#m=439", "#m=162", "#m=694", "#m=680", "#m=231", "#m=51", "#m=79", "#m=488", "#m=145", "#m=63", "#m=91", "#m=72", "#m=119", "#m=144", "#m=888", "#m=113", "#m=56", "#m=156", "#m=116", "#m=828", "#m=82", "#m=886", "#m=461", "#m=87", "#m=93", "#m=60", "#m=442", "#m=89"));

    public static ArrayList<String> MotherboardButtons = new ArrayList<>(Arrays.asList("m_all","R_all","s_all","f_all","c_all","L_all","Y_all","l_all","c0_all","v_all","A_all","V_all"));
    public static ArrayList<String> MotherboardImportantButtons = new ArrayList<>(Arrays.asList("#f=2", "#f=3", "#f=5", "#f=6", "#f=7", "#f=8", "#f=17", "#f=16", "#f=13", "#f=14", "#f=12"));

    public static ArrayList<String> RAMButtons = new ArrayList<>(Arrays.asList("m_all","R_all","t_all","U_all","Z_all","Y_all","T_all","E_all","h_all"));
    public static ArrayList<String> RAMImportantButtons = new ArrayList<>(Arrays.asList("#t=7", "#t=8", "#t=9", "#t=11", "#t=15", "#t=14", "#t=16"));

    public static ArrayList<String> StorageButtons = new ArrayList<>(Arrays.asList("m_all","R_all","t_all","f_all","c0_all","D_all"));
    public static ArrayList<String> StorageImportantButtons = new ArrayList<>(Arrays.asList("#m=3", "#m=1", "#m=718", "#m=6", "#m=707", "#m=737", "#m=447", "#m=835", "#m=8", "#m=340", "#m=117", "#m=9", "#m=692", "#m=10", "#m=11", "#m=12", "#m=13", "#m=711", "#m=154", "#m=623", "#m=768", "#m=882", "#m=17", "#m=18", "#m=19", "#m=20", "#m=733", "#m=74", "#m=751", "#m=830", "#m=21", "#m=731", "#m=423", "#m=755", "#m=23", "#m=462", "#m=112", "#m=25", "#m=214", "#m=274", "#m=26", "#m=27", "#m=28", "#m=422", "#m=869", "#m=29", "#m=471", "#m=30", "#m=130", "#m=220", "#m=110", "#m=31", "#m=778", "#m=794", "#m=32", "#m=33", "#m=34", "#m=417", "#m=444", "#m=35", "#m=473", "#m=46", "#m=864", "#m=760", "#m=341", "#m=811", "#m=111", "#m=36", "#m=142", "#m=178", "#m=49", "#m=871", "#m=38", "#m=73", "#m=749", "#m=897", "#m=60", "#m=40"));

    public static ArrayList<String> CaseButtons = new ArrayList<>(Arrays.asList("m_all","R_all","t_all","y_all","A_all","B_all","C_all","D_all","f_all"));
    public static ArrayList<String> CaseImportantButtons = new ArrayList<>(Arrays.asList("#m=805", "#m=148", "#m=1", "#m=88", "#m=681", "#m=52", "#m=54", "#m=55", "#m=874", "#m=8", "#m=80", "#m=59", "#m=789", "#m=149", "#m=337", "#m=829", "#m=169", "#m=102", "#m=867", "#m=333", "#m=367", "#m=282", "#m=842", "#m=832", "#m=283", "#m=50", "#m=413", "#m=11", "#m=150", "#m=436", "#m=403", "#m=716", "#m=771", "#m=833", "#m=225", "#m=85", "#m=249", "#m=61", "#m=837", "#m=615", "#m=807", "#m=57", "#m=14", "#m=15", "#m=106", "#m=101", "#m=17", "#m=426", "#m=722", "#m=758", "#m=859", "#m=899", "#m=18", "#m=831", "#m=65", "#m=775", "#m=20", "#m=893", "#m=693", "#m=58", "#m=810", "#m=421", "#m=742", "#m=618", "#m=701", "#m=763", "#m=735", "#m=430", "#m=752", "#m=331", "#m=62", "#m=132", "#m=107", "#m=823", "#m=719", "#m=725", "#m=779", "#m=824", "#m=885", "#m=454", "#m=27", "#m=826", "#m=334", "#m=815", "#m=120", "#m=464", "#m=94", "#m=289", "#m=229", "#m=685", "#m=380", "#m=64", "#m=439", "#m=420", "#m=162", "#m=680", "#m=51", "#m=786", "#m=747", "#m=71", "#m=754", "#m=133", "#m=354", "#m=134", "#m=488", "#m=63", "#m=777", "#m=877", "#m=416", "#m=72", "#m=46", "#m=862", "#m=774", "#m=888", "#m=56", "#m=118", "#m=116", "#m=239", "#m=619", "#m=431", "#m=461", "#m=92", "#m=39", "#m=87", "#m=93", "#m=60", "#m=677"));

    public static ArrayList<String> PSUButtons = new ArrayList<>(Arrays.asList("m_all","R_all","e_all","p_all","Y_all","t_all","F_all","B_all"));
    public static ArrayList<String> PSUImportantButtons = new ArrayList<>(Arrays.asList("#m=148", "#m=1", "#m=88", "#m=780", "#m=52", "#m=54", "#m=55", "#m=868", "#m=8", "#m=80", "#m=149", "#m=337", "#m=76", "#m=169", "#m=102", "#m=282", "#m=50", "#m=66", "#m=11", "#m=150", "#m=611", "#m=225", "#m=85", "#m=61", "#m=216", "#m=57", "#m=802", "#m=14", "#m=448", "#m=106", "#m=101", "#m=17", "#m=426", "#m=722", "#m=18", "#m=65", "#m=58", "#m=445", "#m=97", "#m=763", "#m=741", "#m=430", "#m=331", "#m=62", "#m=132", "#m=107", "#m=719", "#m=787", "#m=824", "#m=27", "#m=28", "#m=168", "#m=464", "#m=94", "#m=29", "#m=95", "#m=229", "#m=793", "#m=64", "#m=714", "#m=680", "#m=455", "#m=51", "#m=71", "#m=754", "#m=133", "#m=354", "#m=488", "#m=63", "#m=370", "#m=48", "#m=91", "#m=72", "#m=441", "#m=776", "#m=56", "#m=155", "#m=118", "#m=116", "#m=239", "#m=49", "#m=619", "#m=92", "#m=39", "#m=87", "#m=670", "#m=93", "#m=60"));

    public static ArrayList<String> MonitorButtons = new ArrayList<>(Arrays.asList("m_all","R_all","r_all","P_all","a_all","Y_all","w_all","C_all","c0_all","A_all","S_all","v_all"));
    public static ArrayList<String> MonitorImportantButtons  = new ArrayList<>(Arrays.asList("#m=189", "#m=3", "#m=418", "#m=404", "#m=143", "#m=848", "#m=161", "#m=8", "#m=298", "#m=825", "#m=139", "#m=141", "#m=50", "#m=11", "#m=410", "#m=330", "#m=833", "#m=13", "#m=186", "#m=140", "#m=863", "#m=852", "#m=138", "#m=18", "#m=153", "#m=20", "#m=896", "#m=475", "#m=176", "#m=365", "#m=801", "#m=112", "#m=25", "#m=129", "#m=803", "#m=366", "#m=27", "#m=131", "#m=492", "#m=166", "#m=696", "#m=135", "#m=808", "#m=402", "#m=162", "#m=32", "#m=137", "#m=585", "#m=164", "#m=35", "#m=795", "#m=111", "#m=142", "#m=163", "#m=136", "#m=723", "#m=449", "#m=827", "#m=887", "#m=857", "#m=376", "#m=60"));

    public static ArrayList<String> GPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","c_all","T_all","c0_all","Y_all","s_all","A_all","N_all","Q_all"));//
    public static ArrayList<String> GPUImportantButtons= new ArrayList<>(Arrays.asList("#m=6", "#m=7", "#m=8", "#m=45", "#m=76", "#m=9", "#m=299", "#m=746", "#m=11", "#m=13", "#m=67", "#m=42", "#m=14", "#m=342", "#m=451", "#m=146", "#m=18", "#m=104", "#m=20", "#m=427", "#m=69", "#m=423", "#m=740", "#m=25", "#m=27", "#m=252", "#m=440", "#m=124", "#m=31", "#m=43", "#m=41", "#m=48", "#m=49", "#m=39", "#m=838", "#m=456", "#m=40"));//


    public static ArrayList<String> OSButtons = new ArrayList<>(Arrays.asList("R_all","b_all"));


    public static ArrayList<String> GPUCPURAMStorageCaseMonitorClassNames= new ArrayList<>(Arrays.asList("td__nameWrapper","td__spec td__spec--1","td__spec td__spec--2","td__spec td__spec--3","td__spec td__spec--4","td__spec td__spec--5","td__spec td__spec--6","td__price"));
    public static ArrayList<String> CPUCoolerClassNames = new ArrayList<>(Arrays.asList("td__nameWrapper","td__spec td__spec--1","td__spec td__spec--2","td__spec td__spec--3","td__spec td__spec--4","td__price"));
    public static ArrayList<String> MotherboardPSUClassNames = new ArrayList<>(Arrays.asList("td__nameWrapper","td__spec td__spec--1","td__spec td__spec--2","td__spec td__spec--3","td__spec td__spec--4","td__spec td__spec--5","td__price"));
    public static ArrayList<String> OSClassNames = new ArrayList<>(Arrays.asList("td__nameWrapper","td__spec td__spec--1","td__spec td__spec--2","td__price"));

    public static void main(String[] args) throws IOException, InterruptedException
    {
        String fileSeparator = System.getProperty("file.separator");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter output file path:" +
                "\nExample Windows:  E:\\SQLCSVS" +
                "\nExamples Linux: E:/SQLCSVS\n");
        

        String path = myObj.nextLine();  // Read user input
        path = path+fileSeparator;
        System.out.println("Path is: " + path);  // Output user input


        boolean changeTimeOuts = false;
        System.out.println("Change default timeouts? \n(In seconds) buttonTimeOut = "+Scrape.buttonTimeOut+", pageTimeOut = "+Scrape.pageTimeOut+". (y/n)");
        if (myObj.nextLine().toLowerCase().contains("y")){
            changeTimeOuts = true;
        }
        if (changeTimeOuts){
            System.out.println("Button time out = ");
            Scrape.buttonTimeOut = Integer.parseInt(myObj.nextLine());
            System.out.println("Button time out set: "+Scrape.buttonTimeOut);
            System.out.println("Page time out = ");
            Scrape.pageTimeOut = Integer.parseInt(myObj.nextLine());
            System.out.println("Page time out set: "+Scrape.pageTimeOut);
        }
        
        String CPU= "CPU";
        Scrape S;
        ArrayList<ArrayList<String>> x = new ArrayList<>();
        if(ScrapeHelp.doesExist(CPU,path)==false)
        {
            S = new Scrape(CPUUrl,CPUSButtons,GPUCPURAMStorageCaseMonitorClassNames,CPUImportantButtons);
            x = S.GetData();
            GPUCPURAMStorageCaseMonitorClassNames.add("Socket");
            x.add(0,GPUCPURAMStorageCaseMonitorClassNames);

            ScrapeHelp.WriteCSV(CPU,path,x);
            GPUCPURAMStorageCaseMonitorClassNames.remove(GPUCPURAMStorageCaseMonitorClassNames.size()-1);
            System.out.println("\nFinished CPU\n");
        }

        String GPU= "GPU";

        if(ScrapeHelp.doesExist(GPU,path)==false)
        {
            S = new Scrape(GPUUrl,GPUSButtons,GPUCPURAMStorageCaseMonitorClassNames,GPUImportantButtons);
            x = S.GetData();
            GPUCPURAMStorageCaseMonitorClassNames.add("Manufacturer");
            x.add(0,GPUCPURAMStorageCaseMonitorClassNames);
            ScrapeHelp.WriteCSV(GPU,path,x);

            GPUCPURAMStorageCaseMonitorClassNames.remove(GPUCPURAMStorageCaseMonitorClassNames.size()-1);
            System.out.println("\nFinished GPU\n");
        }
        String Motherboard= "Motherboard";

        if(ScrapeHelp.doesExist(Motherboard,path)==false)
        {
            S = new Scrape(MotherboardUrl,MotherboardButtons,MotherboardPSUClassNames,MotherboardImportantButtons);
            x = S.GetData();
            MotherboardPSUClassNames.add("FormFactor");
            x.add(0,MotherboardPSUClassNames);
            ScrapeHelp.WriteCSV(Motherboard,path,x);

            MotherboardPSUClassNames.remove(MotherboardPSUClassNames.size()-1);
            System.out.println("\nFinished Motherboard\n");
        }
        String CPUCooler= "CPUCooler";

        if(ScrapeHelp.doesExist(CPUCooler,path)==false)
        {
            S = new Scrape(CPUCoolerUrl,CPUCoolerButtons,CPUCoolerClassNames,CPUCoolerImportantButtons);
            x = S.GetData();
            CPUCoolerClassNames.add("Manufacturer");
            x.add(0,CPUCoolerClassNames);
            ScrapeHelp.WriteCSV(CPUCooler,path,x);

            CPUCoolerClassNames.remove(CPUCoolerClassNames.size()-1);
            System.out.println("\nFinished CPU Cooler\n");
        }
        String RAM= "RAM";

        if(ScrapeHelp.doesExist(RAM,path)==false)
        {
            S = new Scrape(RAMUrl,RAMButtons,GPUCPURAMStorageCaseMonitorClassNames,RAMImportantButtons);
            x = S.GetData();
            GPUCPURAMStorageCaseMonitorClassNames.add("FormFactor");
            x.add(0,GPUCPURAMStorageCaseMonitorClassNames);
            ScrapeHelp.WriteCSV(RAM,path,x);

            GPUCPURAMStorageCaseMonitorClassNames.remove(GPUCPURAMStorageCaseMonitorClassNames.size()-1);
            System.out.println("\nFinished RAM\n");
        }
        String Storage= "Storage";

        if(ScrapeHelp.doesExist(Storage,path)==false)
        {
            S = new Scrape(StorageUrl,StorageButtons,GPUCPURAMStorageCaseMonitorClassNames,StorageImportantButtons);
            x = S.GetData();
            GPUCPURAMStorageCaseMonitorClassNames.add("Manufacturer");
            x.add(0,GPUCPURAMStorageCaseMonitorClassNames);
            ScrapeHelp.WriteCSV(Storage,path,x);

            GPUCPURAMStorageCaseMonitorClassNames.remove(GPUCPURAMStorageCaseMonitorClassNames.size()-1);
            System.out.println("\nFinished Storage\n");
        }
        String Case= "Case";

        if(ScrapeHelp.doesExist(Case,path)==false)
        {
            S = new Scrape(CaseUrl,CaseButtons,GPUCPURAMStorageCaseMonitorClassNames,CaseImportantButtons);
            x = S.GetData();
            GPUCPURAMStorageCaseMonitorClassNames.add("Manufacturer");
            x.add(0,GPUCPURAMStorageCaseMonitorClassNames);
            ScrapeHelp.WriteCSV(Case,path,x);

            GPUCPURAMStorageCaseMonitorClassNames.remove(GPUCPURAMStorageCaseMonitorClassNames.size()-1);
            System.out.println("\nFinished Case\n");
        }
        String PSU= "PSU";

        if(ScrapeHelp.doesExist(PSU,path)==false)
        {
            S = new Scrape(PSUUrl,PSUButtons,MotherboardPSUClassNames,PSUImportantButtons);
            x = S.GetData();
            MotherboardPSUClassNames.add("Manufacturer");
            x.add(0,MotherboardPSUClassNames);
            ScrapeHelp.WriteCSV(PSU,path,x);
            MotherboardPSUClassNames.remove(MotherboardPSUClassNames.size()-1);
            System.out.println("\nFinished PSU\n");
        }


        String OS= "OS";

        if(ScrapeHelp.doesExist(OS,path)==false)
        {
            S = new Scrape(OSUrl,OSButtons,OSClassNames,empty);
            x = S.GetData();
            ScrapeHelp.WriteCSV(OS,path,x);

            System.out.println("\nFinished OS\n");
        }
        String Monitor= "Monitor";

        if(ScrapeHelp.doesExist(Monitor,path)==false)
        {
            S = new Scrape(MonitorUrl,MonitorButtons,GPUCPURAMStorageCaseMonitorClassNames,MonitorImportantButtons);
            x = S.GetData();
            GPUCPURAMStorageCaseMonitorClassNames.add("Manufacturer");
            x.add(0,GPUCPURAMStorageCaseMonitorClassNames);
            ScrapeHelp.WriteCSV(Monitor,path,x);

            GPUCPURAMStorageCaseMonitorClassNames.remove(GPUCPURAMStorageCaseMonitorClassNames.size()-1);
            System.out.println("\nFinished Monitor\n");
        }

        /*
        //S.SetOptions("k_fi4","k_all");
        System.out.println(S.SH.doc);
        System.out.println();

        ArrayList<ArrayList<String>> x = S.ScrapePCPP(S.SH.doc, GPUCPURAMStorageCaseMonitorClassNames, CPUImportantButtons.get(0));
        GPUCPURAMStorageCaseMonitorClassNames.add("Socket");
        x.add(0,GPUCPURAMStorageCaseMonitorClassNames);

         */


    }
}
