import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class BackgroundTask extends SwingWorker<String, String> 
{
	@Override
	protected String doInBackground()
	{
		System.out.println("in the method");
		try {
			System.out.println("edt:"+SwingUtilities.isEventDispatchThread());
			System.out.println("fetching data");
			
			for(int i=0;i<10;i++)
			{
				System.out.println(i);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return "returned value form doInBackground()";
	}
	
	
	@Override
	protected void done()
	{
		System.out.println("done method invoked");
		try {
			System.out.println("get method: "+get());
			} 
		catch (InterruptedException e) {e.printStackTrace();} 
		catch (ExecutionException e) {e.printStackTrace();}
		
	}
}
