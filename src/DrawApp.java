
public class DrawApp
{
  public static void main(String[] args)
  {
	  Window window = new Window("ゲーム", 400, 400);
	  Panel panel = new Panel();
	  window.add(panel);
	  window.setVisible(true);
  }
}