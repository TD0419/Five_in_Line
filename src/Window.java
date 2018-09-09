import javax.swing.JFrame;

public class Window extends JFrame
{
	public Window(String title, int width, int height)
	{
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		this.setResizable(false);
	}
}
