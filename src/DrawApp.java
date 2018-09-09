
public class DrawApp
{
  public static void main(String[] args)
  {
	  Window window = new Window("ゲーム", 500, 500);
	  Game game = new Game();
	  Panel panel = new Panel(game);

	  window.add(panel);
	  window.setVisible(true);

	  game.Loop(); // ゲーム処理
  }
}