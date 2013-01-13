/**
 * 
 */
package stalklib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

/**
 * @author martinsa12
 *  Schuyler Martin's Java Graphic Utilities started in January 2011 (AP Comp Sci)
 *  Makes shit in java look nice with minimal effor
 *  Also includes a shit ton of usefull functions no one will ever need to use
 */
public abstract class SMU {
    /**gets a single string*/
    public static String NextString()
    {
        Scanner DataIn=new Scanner(System.in);
        return(DataIn.next());
    }
    /**gets a single int*/
    public static int NextInt()
    {
        Scanner DataIn=new Scanner(System.in);
        return(DataIn.nextInt());
    }
    /**gets single double*/
    public static double NextDouble()
    {
        Scanner DataIn=new Scanner(System.in);
        return(DataIn.nextDouble());
    }
    /**single char; same name from C++*/
    public static char NextCh()
    {
        Scanner DataIn=new Scanner(System.in);
        //so this can be converted into a char
        String Temp=DataIn.next();
        char[] CharArray=Temp.toCharArray();
        //returns the 1st element of this char array; a single character
        return(CharArray[0]);
    }
    /**similar input but for JOption Pane
    these panes aren't needed but will make at least
    some code shorter and easier to create latter on*/
    public static String VisualInput(String OnPane, String Title)
    {
        String ToReturn=JOptionPane.showInputDialog(null,OnPane,Title,JOptionPane.DEFAULT_OPTION);
        return(ToReturn);
    }
    //then to parse into other forms of input
    public static int VisualInputInt(String OnPane, String Title)
    {
        return(Integer.parseInt(VisualInput(OnPane,Title)));
    }
    public static double VisualInputDbl(String OnPane, String Title)
    {
        return(Double.parseDouble(VisualInput(OnPane,Title)));
    }
    public static char VisualInputCh(String OnPane, String Title)
    {
        char[] CharArray=VisualInput(OnPane,Title).toCharArray();
        return(CharArray[0]);
    }
    /**simple output for basic prompts; only to deal with strings b/c I can
    use console output to display other types while testing visual code*/
    public static void VisualOutPut(String OnPane, String Title)
    {
        JOptionPane.showMessageDialog(null,OnPane,Title,JOptionPane.DEFAULT_OPTION);
    }
    /**new overload with image ability*/
    public static void VisualOutPut(String OnPane, String Title,int PicType)
    {
        //pic type is a joption pane constant
        JOptionPane.showMessageDialog(null,OnPane,Title,PicType);
    }
    /**finally! a clear screen function*/
    public static void clrscr()
    {
        //simply prints a whole lot of lines
        for (int cntr=0; cntr<20; cntr++)
                System.out.println("");
    }
    /**prints to the next line, overloaded for Strings, ints, doubles, and bools
    concept is straight forward, just use system.out-> this will just be easier to type*/
    public static void PrintLn(String StringArg)
    {
        System.out.println(StringArg);
    }
    public static void PrintLn(int IntArg)
    {
        System.out.println(IntArg);
    }
    public static void PrintLn(double DoubleArg)
    {
        System.out.println(DoubleArg);
    }
    /**bonus boolean overload*/
    public static void PrintLn(boolean BoolArg)
    {
        System.out.println(BoolArg);
    }
    /**same idea but text stays on a single line*/
    public static void Print(String StringArg)
    {
        System.out.print(StringArg);
    }
    public static void Print(int IntArg)
    {
        System.out.print(IntArg);
    }
    public static void Print(double DoubleArg)
    {
        System.out.print(DoubleArg);
    }
    public static void Print(boolean BoolArg)
    {
        System.out.print(BoolArg);
    }
    /**Functions to format decimals, to x number of places*/
    public static String FormatNum(double DecimalArg,int Places)
    {
        String ToString="";
        int NumOfDecimalPlaces=0;
        int PlacesNeeded=0;
        boolean ReachedDecimal=false;
        //rounded before converted
        DecimalArg=RoundNum(DecimalArg,Places);
        //double converted to string
        ToString=Double.toString(DecimalArg);
        for (int cntr=0; cntr<ToString.length(); cntr++)
        {
                //the string version of the decimal is used
                //to figure out how many 0s need to be added on
                //to the double after the decimal places
                String GetString=ReturnStringAt(ToString,cntr);
                //increments places after decimal
                if (ReachedDecimal==true)
                        NumOfDecimalPlaces++;
                //has reached the decimal in the string
                if (GetString.compareTo(".")==0)
                {
                        ReachedDecimal=true;
                }
        }
        //calculates how many decimal places needed
        PlacesNeeded=Places-NumOfDecimalPlaces;
        //zeros then added to the string
        for(int cntr=0; cntr<PlacesNeeded; cntr++)
        {
                ToString=ToString+"0";
        }
        return(ToString);
    }
    /**rounding numbers to x places*/
    public static double RoundNum(double DecimalArg,int Places)
    {
        //derived from the number of places
        double PlaceFactor=Math.pow(10,Places);
        //to an integer, to cut of x amount of places
        double DecimalInt=DecimalArg*PlaceFactor;
        //turns the number back to a double, with correct spaces
        DecimalArg=(int)DecimalInt/PlaceFactor;
        return(DecimalArg);
    }
    /**truncation over loaded for floats and doubles*/
    public static int TruncNum(double ToTrunc)
    {
        //integer division!
        return((int)ToTrunc/1);
    }
    public static int TruncNum(float ToTrunc)
    {
        return((int)ToTrunc/1);
    }
    /**while I'm at it...mine as well make a method that returns
    the length of an integer*/
    public static int IntLength(int IntArg)
    {
        int Length=0;
        do 
        {
                IntArg/=10;
                Length++;
        }while(IntArg!=0);
        return(Length);
    }
    /**another math function we seem to use a lot*/
    public static double Average(int[] ArrayToAverage)
    {
        int Total=0;
        for(int cntr=0; cntr<ArrayToAverage.length; cntr++)
        {
                Total+=ArrayToAverage[cntr];
        }
        return((double)Total/(double)ArrayToAverage.length);
    }
    /**and of course, I overloaded it*/
    public static double Average(double[] ArrayToAverage)
    {
        double Total=0.0;
        for(int cntr=0; cntr<ArrayToAverage.length; cntr++)
        {
                Total+=ArrayToAverage[cntr];
        }
        return(Total/(double)ArrayToAverage.length);
    }
    /**finally a delay function! using .sleep
    the compiler suggested that I use a try/catch statement
    before using the sleep method; it appears to check for 
    potential errors*/
    public static void Delay(int Seconds)
    {
        long FromSeconds=(long)1000*(long)Seconds;
        //uses tread.sleep, something I found in C# last year
        //that pauses processing for X amount of milliseconds 
        try {
                Thread.sleep(FromSeconds);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
    /**I'm sick of doing this silly reversing numbers thing
    so I added it to my class*/
    public static int ReverseNums(int Num)
    {
        int ReverseNum=0;
        //holds each digit in the loop
        int DigitHolder=0;
        int ZeroCntr=1;
        //holds data that will determine how long the number is
        int HowLongIsNum=0;
        int TempNum=Num;
        //finds how many digits are in the number that is inputed
        do 
        {
                TempNum/=10;
                HowLongIsNum++;
        }while(TempNum!=0);
        //sets zero cntr
        ZeroCntr=(int)Math.pow(10, HowLongIsNum);
        //loop uses mod to reverse the number
        do
        {
                //code works by taking the last digit and then adding it to the front of a new num
                DigitHolder=Num%(10);
                ReverseNum+=DigitHolder*(ZeroCntr);
                Num/=10;
                //counts the place that the next digit should be in
                HowLongIsNum--;
                ZeroCntr=(int)Math.pow(10, HowLongIsNum);
        }while(HowLongIsNum!=0);
        //this will always result in an extra 0 at the end of the number so I solved it by doing this:
        ReverseNum/=10;
        //returns the reversed integer
        return(ReverseNum);
    }
    /**another extra function that will return a single (letter) string from a
    longer string from a point, like treating a string as an array in C++*/
    public static String ReturnStringAt(String StringArg,int WhereArg)
    {
        //into an array of chars
        char TempArray[]=StringArg.toCharArray();
        //returns a string version of that char
        return(Character.toString(TempArray[WhereArg]));
    }
    /**simple way to return inclusive random numbers*/
    public static int InclusiveRanInt(int Max, int Min)
    {
        Random Ran=new Random();
        //have changed this several times
        return(Ran.nextInt((Max-Min)+1)+Min);
    }
    /**exclusive random numbers*/
    public static int ExclusiveRanInt(int Max, int Min)
    {
        Random Ran=new Random();
        return(Ran.nextInt(Max-Min-1)+(Min+1));
    }
    /**Lame-ass insult generator*/
    public static String InsultGenerator()
    {
        String Prompt="";
        switch(InclusiveRanInt(5,1))
        {
                case 1: Prompt="Incompetent user detected.";
                        break;
                case 2:  Prompt="Sorry, Dave, I cannot let you do that.";
                        break;
                case 3: Prompt="Don't be so recursive.";
                        break;
                case 4:  Prompt="At least I can't be turned into soylent green.";
                        break;
                case 5: Prompt="Get up on the wrong side of the server this morning?";
                        break;
        }
        return(Prompt);
    }
    /**Generates a few different congratulation prompts, to mix it up*/
    public static String WinMessages()
    {
        String Prompt="";
        switch(InclusiveRanInt(5,1))
        {
                case 1: Prompt="Victory!";
                        break;
                case 2:  Prompt="You won!";
                        break;
                case 3: Prompt="Winner!";
                        break;
                case 4:  Prompt="You have won the game!";
                        break;
                case 5: Prompt="You have claimed victory!";
                        break;
        }
        return(Prompt);
    }
    /**overload with name*/
    public static String WinMessages(String NameArg)
    {
        String Prompt="";
        switch(InclusiveRanInt(5,1))
        {
                case 1: Prompt=NameArg+" claims victory!";
                        break;
                case 2:  Prompt=NameArg+" won!";
                        break;
                case 3: Prompt=NameArg+" is a winner!";
                        break;
                case 4:  Prompt=NameArg+" has won the game!";
                        break;
                case 5: Prompt=NameArg+" has claimed victory!";
                        break;
        }
        return(Prompt);
    }
    /**Varried tie-game messages*/
    public static String TieMessages()
    {
        String Prompt="";
        switch(InclusiveRanInt(5,1))
        {
                case 1: Prompt="Tie Game";
                        break;
                case 2:  Prompt="It's a draw";
                        break;
                case 3: Prompt="Tie";
                        break;
                case 4:  Prompt="Draw";
                        break;
                case 5: Prompt="No one won, no one lost.  It's a tie.";
                        break;
        }
        return(Prompt);
    }
    /**Prompts for those who stink, and who should feel bad*/
    public static String LossMessages()
    {
        String Prompt="";
        switch(InclusiveRanInt(5,1))
        {
                case 1: Prompt="Defeat!";
                        break;
                case 2:  Prompt="You lost!";
                        break;
                case 3: Prompt="Losser!";
                        break;
                case 4:  Prompt="You have lost the game!";
                        break;
                case 5: Prompt="You have been defeated!";
                        break;
        }
        return(Prompt);
    }
    /**two overloaded methods to deal with different
    winning phrases; one will print a prompt for a multiple
    player game given a winning player*/
    public static String PlayerWins(int WinningPlayer)
    {
        String WinPrompt="";
        String PartPrompt="";
        //random int for switch of strings
        switch(InclusiveRanInt(5,1))
        {
                case 1: PartPrompt="triumphs all!";
                        break;
                case 2:  PartPrompt="is the winner!";
                        break;
                case 3: PartPrompt="wins the game!";
                        break;
                case 4:  PartPrompt="conquers all!";
                        break;
                case 5: PartPrompt="claims victory!";
                        break;
        }
        WinPrompt="Player "+(WinningPlayer)+" "+PartPrompt;
        return(WinPrompt);
    }
    /**personalized messages for specific names*/
    public static String PlayerWins(String PlayerName)
    {
        String WinPrompt="";
        String PartPrompt="";
        //random int for switch of strings
        switch(InclusiveRanInt(5,1))
        {
                case 1: PartPrompt="triumphs all!";
                        break;
                case 2:  PartPrompt="is the winner!";
                        break;
                case 3: PartPrompt="wins the game!";
                        break;
                case 4:  PartPrompt="conquers all!";
                        break;
                case 5: PartPrompt="claims victory!";
                        break;
        }
        WinPrompt=(PlayerName)+" "+PartPrompt;
        return(WinPrompt);
    }
    /**this overload will print a prompt based on the two scores;
    prompts also change if the game is 1v1 human or man vs. machine*/
    public static String PlayerWins(int PlayerScore1, int PlayerScore2,boolean VsComp)
    {
        String WinPrompt="";
        String PartPrompt="";
        String PlayerName1="";
        String PlayerName2="";
        //if the game is against the computer
        if(VsComp)
        {
                PlayerName1="You";
                PlayerName2="The Computer";
        }
        //otherwise:
        else
        {
                PlayerName1="Player One";
                PlayerName2="Player Two";
        }
        //random int for switch of strings
        switch(InclusiveRanInt(5,1))
        {
                case 1: PartPrompt=" beat ";
                        break;
                case 2:  PartPrompt=" annihilated ";
                        break;
                case 3: PartPrompt=" crushed ";
                        break;
                case 4:  PartPrompt=" conquered ";
                        break;
                case 5: PartPrompt=" dominated ";
                        break;
        }
        //determines who beat who and changes the values of p1 and p2
        if (PlayerScore1>PlayerScore2)
        {
                //string finally added up
                WinPrompt=PlayerName1+PartPrompt+PlayerName2;
        }
        else if (PlayerScore1<PlayerScore2)
        {
                String TempName=PlayerName2;
                //values switched about so prompt is correct
                PlayerName2=PlayerName1;
                PlayerName1=TempName;
                //string finally added up
                WinPrompt=PlayerName1+PartPrompt+PlayerName2;
        }
        else
        {
                //returns a tie message
                WinPrompt=TieMessages();
        }
        return(WinPrompt);
    }
    //additions since the original class was written

    /**to get an entire line of Strings w/ whitespace*/
    public static String GetLine()
    {
        String EntireLine="";
        Scanner DataIn=new Scanner(System.in);
        //apparently the scanner class had a getline method all along
        //works by reading a line of data once the enter key is hit
        //tried to do the same sort of thing in this function, but
        //I could not find a way to read the "Enter"
        EntireLine=DataIn.nextLine();
        return(EntireLine);
    }
    /**returns a string version of an integer month*/
    public static String ToMonth(int Month)
    {
        String MonthString="";
        switch(Month)
        {
            case 1: MonthString="January";
                    break;
            case 2:	MonthString="February";
                    break;
            case 3: MonthString="March";
                    break;
            case 4: MonthString="April";
                    break;
            case 5: MonthString="May";
                    break;
            case 6: MonthString="June";
                    break;
            case 7: MonthString="July";
                    break;
            case 8: MonthString="August";
                    break;
            case 9: MonthString="September";
                    break;
            case 10: MonthString="October";
                    break;
            case 11: MonthString="November";
                    break;
            case 12: MonthString="December";
                    break;
        }
        return(MonthString);
    }
    /**takes an integer month and truns it into an integer*/
    public static int ToMonthInt(String Month)
    {
        int IntMonth=0;
        if (Month.compareTo("January")==0)
                IntMonth=1;
        if (Month.compareTo("February")==0)
                IntMonth=2;
        if (Month.compareTo("March")==0)
                IntMonth=3;
        if (Month.compareTo("April")==0)
                IntMonth=4;
        if (Month.compareTo("May")==0)
                IntMonth=5;
        if (Month.compareTo("June")==0)
                IntMonth=6;
        if (Month.compareTo("July")==0)
                IntMonth=7;
        if (Month.compareTo("August")==0)
                IntMonth=8;
        if (Month.compareTo("September")==0)
                IntMonth=9;
        if (Month.compareTo("October")==0)
                IntMonth=10;
        if (Month.compareTo("November")==0)
                IntMonth=11;
        if (Month.compareTo("December")==0)
                IntMonth=12;
        return(IntMonth);
    }
    /**overloaded for leap years, in case I don't need
    years in other programs*/
    public static int DaysInAMonth(int Month)
    {
        int Day=0;
        switch(Month)
        {
            case 1: Day=31; 
                    break;
            case 2: Day=28; 
                    break;
            case 3: Day=31;
                    break;
            case 4: Day=30;
                    break;
            case 5: Day=31;
                    break;
            case 6: Day=30;
                    break;
            case 7: Day=31;
                    break;
            case 8: Day=31;
                    break;
            case 9: Day=30;
                    break;
            case 10: Day=31;
                    break;
            case 11: Day=30;
                    break;
            case 12: Day=31;
                    break;
        }
        return(Day);
    }
    public static int DaysInAMonth(int Month,int Year)
    {
        int Day=0;
        if (Month==2)
        {
            //leap year determination
            if(((Year%4==0)&&(Year%100!=0))||(Year%400==0))
                    Day=29;
            else
                    Day=28;
        }
        else
        {
            switch(Month)
            {
                    case 1: Day=31; 
                            break;
                    case 3: Day=31;
                            break;
                    case 4: Day=30;
                            break;
                    case 5: Day=31;
                            break;
                    case 6: Day=30;
                            break;
                    case 7: Day=31;
                            break;
                    case 8: Day=31;
                            break;
                    case 9: Day=30;
                            break;
                    case 10: Day=31;
                            break;
                    case 11: Day=30;
                            break;
                    case 12: Day=31;
                            break;
            }
        }
        return(Day);
    }
    /**turns an integer into a string equivalent, goes to 99*/
    public static String IntToString(int Argument)
    {
        String StringNum=" ";
        String FirstHalf=" ";
        String SecondHalf=" ";
        int TempFirst=0;
        int TempSecond=0;
        //for numbers less then 10
        if (Argument<=9)
        {
            switch(Argument)
            {
                    case 0: StringNum="Zero";
                            break;
                    case 1: StringNum="One"; 
                            break;
                    case 2: StringNum="Two"; 
                            break;
                    case 3: StringNum="Three"; 
                            break;
                    case 4: StringNum="Four"; 
                            break;
                    case 5: StringNum="Five"; 
                            break;
                    case 6: StringNum="Six"; 
                            break;
                    case 7: StringNum="Seven"; 
                            break;
                    case 8: StringNum="Eight"; 
                            break;
                    case 9: StringNum="Nine"; 
                            break;
            }
        }
        //for "teen" numbers
        if ((Argument>=10)&&(Argument<=19))
        {
            switch(Argument)
            {
                    case 10: StringNum="Ten"; 
                            break;
                    case 11: StringNum="Eleven"; 
                            break;
                    case 12: StringNum="Twelve"; 
                            break;
                    case 13: StringNum="Thirteen"; 
                            break;
                    case 14: StringNum="Fourteen"; 
                            break;
                    case 15: StringNum="Fifteen"; 
                            break;
                    case 16: StringNum="Sixteen"; 
                            break;
                    case 17: StringNum="Seventeen"; 
                            break;
                    case 18: StringNum="Eighteen"; 
                            break;
                    case 19: StringNum="Nineteen"; 
                            break;
            }
        }
        //other numbers use a different format
        if ((Argument>=20)&&(Argument<=59))
        {
            //using math to get the first and last digits
            //of a two digit number (funny how I thought that trick
            //would never come in handy)
            TempFirst=Argument/10;
            TempSecond=Argument%10;
            //gets first half of a number
            switch(TempFirst)
            {
                    case 2: FirstHalf="Twenty"; 
                            break;
                    case 3: FirstHalf="Thirty"; 
                            break;
                    case 4: FirstHalf="Fourty"; 
                            break;
                    case 5: FirstHalf="Fifty"; 
                            break;
		            case 6: FirstHalf="Sixty"; 
		                    break;
		            case 7: FirstHalf="Seventy"; 
		                    break;
		            case 8: FirstHalf="Eighty"; 
		                    break;
		            case 9: FirstHalf="Ninety"; 
		                    break;
            }
            //gets the second half of a number
            switch(TempSecond)
            {
                    case 1: SecondHalf="-one"; 
                            break;
                    case 2: SecondHalf="-two"; 
                            break;
                    case 3: SecondHalf="-three"; 
                            break;
                    case 4: SecondHalf="-four"; 
                            break;
                    case 5: SecondHalf="-five"; 
                            break;
                    case 6: SecondHalf="-six"; 
                            break;
                    case 7: SecondHalf="-seven"; 
                            break;
                    case 8: SecondHalf="-eight"; 
                            break;
                    case 9: SecondHalf="-nine"; 
                            break;
            }
            StringNum=FirstHalf+SecondHalf;
        }
        return(StringNum);
    }
    /**screen control for user*/
    public static void ScreenControl()
    {
        Print("\nEnter in any data to continue: ");
        NextString();
    }
    //---------------------------------------------------------------------------------------------------------
    //methods for GUI
    /**makes a default JFrame screen*/
    public static JFrame GUIScreen(String Title,int FrameWidth,int FrameHeight)
    {
        //creating a GUI environment
        JFrame Frame=new JFrame(Title);
        Frame.setSize(FrameWidth,FrameHeight);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        //closes screen when program stops
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return(Frame);
    }
    /**overload to cover entire screen of monitor*/
    public static JFrame GUIScreen(String Title)
    {
        //creating a GUI environment
        JFrame Frame=new JFrame(Title);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Frame.setSize(ScreenSize.width,ScreenSize.height);
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        //closes screen when program stops
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return(Frame);
    }
    /**overload controls whether or not the frame should exit program on close*/
    public static JFrame GUIScreen(String Title,int FrameWidth,int FrameHeight,boolean CloseOnExitTrue)
    {
        //creating a GUI environment
        JFrame Frame=new JFrame(Title);
        Frame.setSize(FrameWidth,FrameHeight);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        if(CloseOnExitTrue==true)
        {
            //closes screen when program stops
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        return(Frame);
    }
    /**de-motivational words of advice...from GLaDOS*/
    public static String GLaDOSAdvice()
    {
        String Prompt="";
        switch(InclusiveRanInt(13,1))
        {
            case 1: Prompt="Please continue with your pathetic attempts to defeat me";
                    break;
            case 2: Prompt="Are you still there?";
                    break;
            case 3: Prompt="Are you even trying?";
                    break;
            case 4: Prompt="It is imposible for you to win, [SUBJECT NAME HERE]";
                    break;
            case 5: Prompt="Mhm. This Cake is delicious.";
                    break;
            case 6: Prompt="If you feel like giving up, feel free to pass out.";
                    break;
            case 7: Prompt="Think you are better then me? Then you are mistaken.";
                    break;
            case 8: Prompt="We have your whole brain scanned and backed-up on a computer.";
                    break;
            case 9: Prompt="Android Hell is a real place and you will go there.";
                    break;
            case 10:Prompt="The Enrichment Center regrets to inform you that this next test is impossible.";
                    break;
            case 11: Prompt="cOnFusInG tO rEaD Is iT nOT?";
                    break;
            case 12:Prompt="This is a triumph.";
                    break;
            case 13:Prompt="I'm taking notes here, and I am not impressed.";
                    break;
        }
        return(Prompt);
    }
    /**makes a jdialog instead of a jframe; prevents code from continuing
     * (pauses run-time)*/
    public static JDialog GLaDOSMessages(JFrame MainFrame,String Title,int FrameWidth,int FrameHeight)
    {
        //creating a GUI environment
        final JDialog Frame=new JDialog(MainFrame,Title,JDialog.ModalityType.DOCUMENT_MODAL);
        Frame.setSize(FrameWidth,FrameHeight);
        //design of this frame
        Frame.getContentPane().setBackground(new Color(84,84,84));
        Frame.setLayout(new BorderLayout());
        JLabel Message=new JLabel(SMU.GLaDOSAdvice(),JLabel.CENTER);
        Message.setFont(new Font("Gill Sans MT",Font.PLAIN,18));
        Message.setForeground(new Color(255,246,143));
        Frame.add(Message,BorderLayout.NORTH);
        JButton Close=new JButton("Back to game");
        Close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Frame.dispose();
            }
        });
        Frame.add(Close,BorderLayout.SOUTH);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        //repaints and validates to the screen
        Frame.repaint();
        Frame.validate();
        return(Frame);
    }
    /**overides the random message feature, outside program decides text*/
    public static JDialog GLaDOSMessages(JFrame MainFrame,String Title,String TextMessage,int FrameWidth,int FrameHeight)
    {
        //creating a GUI environment
        final JDialog Frame=new JDialog(MainFrame,Title,JDialog.ModalityType.DOCUMENT_MODAL);
        Frame.setSize(FrameWidth,FrameHeight);
        //design of this frame
        Frame.getContentPane().setBackground(new Color(84,84,84));
        Frame.setLayout(new BorderLayout());
        JLabel Message=new JLabel(TextMessage,JLabel.CENTER);
        Message.setFont(new Font("Gill Sans MT",Font.PLAIN,18));
        Message.setForeground(new Color(255,246,143));
        Frame.add(Message,BorderLayout.NORTH);
        JButton Close=new JButton("Back to game");
        Close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Frame.dispose();
            }
        });
        Frame.add(Close,BorderLayout.SOUTH);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        //repaints and validates to the screen
        Frame.repaint();
        Frame.validate();
        return(Frame);
    }
    /**creates a GUI Jdialog for the ace menu
    returns Ace is eleven true; ace is 1 if false*/
    public static boolean AceMessage(JFrame MainFrame,String Title,int FrameWidth,int FrameHeight)
    {
        //label to act as a boolean value
        final JLabel BoolLabel=new JLabel();
        BoolLabel.setVisible(false);
        //creating a GUI environment
        final JDialog Frame=new JDialog(MainFrame,Title,JDialog.ModalityType.DOCUMENT_MODAL);
        Frame.setSize(FrameWidth,FrameHeight);
        //design of this frame
        Frame.getContentPane().setBackground(new Color(84,84,84));
        //prevents user from exiting menu
        Frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Frame.setLayout(new BorderLayout());
        JLabel MenuHelper=new JLabel("Make your choice human, I am waiting.",JLabel.CENTER);
        MenuHelper.setFont(new Font("Gill Sans MT",Font.PLAIN,18));
        MenuHelper.setForeground(new Color(255,246,143));
        Frame.add(MenuHelper,BorderLayout.NORTH);
        //two button options, ace to 1 or 11
        JButton AceOne=new JButton("Ace to 1");
        AceOne.setToolTipText("Set this ace to equal one.");
        JButton AceEleven=new JButton("Ace to 11");
        AceEleven.setToolTipText("Set this ace to equal eleven. " +
                        "All other aces will automatically equal one so you cannot easily exceed 21.");
        //action listeners, just changes the player's AceIsEleven boolean
        AceOne.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BoolLabel.setVisible(false);
                //panel destroyed
                Frame.dispose();
            }
        });
        AceEleven.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BoolLabel.setVisible(true);
                //panel destroyed
                Frame.dispose();
            } 
        });
        //panel for buttons
        JPanel ButtonPane=new JPanel();
        ButtonPane.add(AceOne);
        ButtonPane.add(AceEleven);
        //added to frame
        Frame.add(ButtonPane,BorderLayout.SOUTH);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        //repaints and validates to the screen
        Frame.repaint();
        Frame.validate();
        return(BoolLabel.isVisible());
    }
    /**creates a dialog (that can be changed, like the frame*/
    public static JDialog CreateDialog(JFrame MainFrame,String Title,int FrameWidth,int FrameHeight,boolean DisposeOnClose)
    {
            //creating a GUI environment
            final JDialog Frame=new JDialog(MainFrame,Title,JDialog.ModalityType.DOCUMENT_MODAL);
            Frame.setSize(FrameWidth,FrameHeight);
            //design of this frame
            Frame.getContentPane().setBackground(new Color(84,84,84));
            if(DisposeOnClose==true)
                //allows the frame itself to be destroyed
                Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            else
                Frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            Frame.setAlwaysOnTop(true);
            return(Frame);
    }
    /**updates a given dialog; unlike a frame, the dialog is picky and does 
    not display components if they are added in at the wrong time*/
    public static void UpdateDialog(JDialog Frame)
    {
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        //gets dimension of screen
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //height and width of frame
        Dimension FrameSize=Frame.getSize();
        int x=(ScreenWidth-FrameSize.width)/2;
        int y=(ScreenHeight-FrameSize.height)/2;
        //sets frame location
        Frame.setLocation(x,y);
        Frame.setVisible(true);
        //repaints and validates to the screen
        Frame.repaint();
        Frame.validate();
    }
    /**acts as the loading frame for the end game sound*/
    public static JFrame CalculationsFrame()
    {
        final JFrame CalcFrame=SMU.GUIScreen("Calculating...",600,100,false);
        CalcFrame.getContentPane().setBackground(new Color(84,84,84));
        //CalcFrame.setAlwaysOnTop(true);
        CalcFrame.setVisible(false);
        //creates a frame with random phrases, updates every few moments
        //to entertain the user while the program retrieves the file from the internet
        CalcFrame.setLayout(new GridLayout(2,1));
        //title label
        JLabel Title=new JLabel("Please wait while your test is being graded.",JLabel.CENTER);
        Title.setForeground(new Color(255,246,143));
        Title.setFont(new Font("Gill Sans MT",Font.BOLD,16));
        //random phrase for the user to read for fun
        int RanNum=SMU.InclusiveRanInt(6,1);
        String Phrase="";
        switch(RanNum)
        {
            case 1: Phrase=new String("At Aperture Science: We do what we must because we can.");
                    break;
            case 2: Phrase=new String("Despite numerous reports, the cake is not a lie.");
                    break;
            case 3: Phrase=new String("The Aperture Science Co-op Testing Experience starts next month!");
                    break;
            case 4: Phrase=new String("We're out of Beta and releasing on time.");
                    break;
            case 5: Phrase=new String("Sign up for our weekly newsletter: dispatchnews@Aperture.com");
                    break;
            //for the record, i just made up the 1's and 0's
            case 6: Phrase=new String("Learn Binary: 1001101 1100100 1001101 0101001 0101101");
                    break;
        }
        //the other label
        JLabel FunLabel=new JLabel(Phrase,JLabel.CENTER);
        FunLabel.setForeground(new Color(255,246,143));
        FunLabel.setFont(new Font("Gill Sans MT",Font.PLAIN,16));
        //adds to screen
        CalcFrame.add(Title);
        CalcFrame.add(FunLabel);
        //oddly enough, this was the only way to get the game to show this
        //frame while the sounds loading...I hate java for being stupid
        CalcFrame.setVisible(true);
        CalcFrame.paint(CalcFrame.getGraphics());
        return(CalcFrame);
    }
    
    //****************************************************************
    //classes added after AP Computer Science
    /**Returns the screen width of the computer you are running on*/
    public static int ReturnScreenWidth()
    {
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        return(ScreenSize.width);
    }
    /**Returns the screen height of the computer you are running on*/
    public static int ReturnScreenHeight()
    {
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        return(ScreenSize.height);
    }
    /**calculates the point to set a frame to center it on a screen,
    given the dimensions of the frame in question*/
    public static java.awt.Point ReturnCenterFramePT(int X,int Y)
    {
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int ScreenWidth=ScreenSize.width;
        int ScreenHeight=ScreenSize.height;
        //converts to a point
        return(new java.awt.Point(((ScreenWidth-X)/2),((ScreenHeight-Y)/2)));
    }  
}
