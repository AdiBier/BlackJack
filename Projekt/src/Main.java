import java.awt.EventQueue;
import java.io.IOException;

public class Main {
public static void main(String args[])
{
	EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {
		
				new Strona_startowa();
		
		}
	});
}
}
