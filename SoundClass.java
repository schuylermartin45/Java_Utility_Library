/**
 * 
 */
package javacasino;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;


import javax.swing.JApplet;
/**
 * @author martinsa12
 *
 */
public class SoundClass extends JApplet
{
	//stream that is used later to assign what sound to play;
	//value given when sound played
	private AudioInputStream MyInputStream;
	static SMU MyFormat=new SMU();
	//Holds the main path of the file 
	private String MainPath;
	//constructors
	public SoundClass()
	{
		this.MainPath="Resources/Sound/";
	}
	public SoundClass(String Path)
	{
		//sets a "Main Path"
		this.MainPath=Path;
	}
	//gathers the
	public String TotalPath(boolean HappyTrue,String FileName)
	{
		String FinalPath="";
		//a happy sound or not
		if(HappyTrue==true)
		{
			FinalPath=this.MainPath+"Positive/"+FileName+".wav";
		}
		else
		{
			FinalPath=this.MainPath+"Negative/"+FileName+".wav";
		}
		return(FinalPath);
	}
	//plays a "happy" sound; randomly
	private String PlayHappy()
	{
		String Path="";
		int RanNum=MyFormat.InclusiveRanInt(5,1);
		switch(RanNum)
		{
			case 1:Path=this.TotalPath(true,"welcome");
				break;
			case 2:Path=this.TotalPath(true,"welcome");
				break;
			case 3:Path=this.TotalPath(true,"welcome");
				break;
			case 4:Path=this.TotalPath(true,"welcome");
				break;
			case 5:Path=this.TotalPath(true,"welcome");
				break;
		}
		return(Path);
	}
	//plays an "angry/sad sound"
	private String PlaySad()
	{
		String Path="";
		int RanNum=MyFormat.InclusiveRanInt(5,1);
		switch(RanNum)
		{
			case 1:Path=this.TotalPath(false,"");
				break;
			case 2:Path=this.TotalPath(false,"");
				break;
			case 3:Path=this.TotalPath(false,"");
				break;
			case 4:Path=this.TotalPath(false,"");
				break;
			case 5:Path=this.TotalPath(false,"");
				break;
		}
		//returns string path
		return(Path);
	}
	//plays specified file
	public void PlayStartUp()throws MalformedURLException 
	{
		//to add to my frustrations with java, I had to upload a sound to my google site,
		//and use the applet classes to access an online file just to play a stupid sound
		//why can't I just run a local file? grrrr.... this is why I like C#
		URL MyUrl=new URL("http://sites.google.com/site/" +
				"nitramproductionsonline/games/portal-crazy-eights/" +
				"StartUp.wav?attredirects=0&d=1");
		//URL TestUrl=new URL("Resources/Sound/Start Up.wav");
		//AudioClip Sound=Applet.newAudioClip(MyUrl);
		AudioClip Sound=Applet.newAudioClip(MyUrl);
		Sound.play();
	}
	//decides what type of sound to play
	public void PlayDecidedSound(int SoundNum) throws MalformedURLException 
	{
		//three different sounds to be played for different winning scenarios
		if(SoundNum==1)
		{
			AudioClip Sound=Applet.newAudioClip(new URL("https://sites.google.com/site/nitramproductionsonline/games" +
				"/portal-crazy-eights/brokenheart.wav?attredirects=0&d=1"));
			Sound.play();
		}
		if(SoundNum==2)
		{
			AudioClip Sound=Applet.newAudioClip(new URL("https://sites.google.com/site/nitramproductionsonline/games" +
					"/portal-crazy-eights/RadioLoop2.wav?attredirects=0&d=1"));
			Sound.play();
		}
		if(SoundNum==3)
		{
			AudioClip Sound=Applet.newAudioClip(new URL("https://sites.google.com/site/nitramproductionsonline/games" +
					"/portal-crazy-eights/BrainScan2.wav?attredirects=0&d=1"));
			Sound.play();
		}
	}
}
