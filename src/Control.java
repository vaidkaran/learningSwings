import javax.swing.SwingUtilities;


public class Control 
{

	public static void main(String[] args) 
	{
		System.out.println("im in");
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {		
				Gui gui = new Gui("first swing application");
				//gui.boxLayoutDemo();
				gui.JListExample();
				
			}
		});
		

	}

}
