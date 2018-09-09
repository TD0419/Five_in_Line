
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	Image img_goban = Toolkit.getDefaultToolkit().getImage("goban.jpg");
	Image img_black_stone = Toolkit.getDefaultToolkit().getImage("black_stone.png");
	Image img_white_stone = Toolkit.getDefaultToolkit().getImage("white_stone.png");

	Game game_data;

	Panel(Game game)
	{
		game_data = game;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//画像の表示
		// 碁盤表示
		g.drawImage(img_goban, 0, 0, 400, 400, this);

		Game.Stone[] map = game_data.MapAllData();
		for(int i = 0; i < game_data.finalBoard_Width * game_data.finalBoard_Height; i++)
		{
			if(map[i] == Game.Stone.Black)
			{
				// 碁石(黒)表示
				g.drawImage(
						img_black_stone,
						10 * (i % game_data.finalBoard_Width),
						10 * (i / game_data.finalBoard_Width),
						30, 30, this);
			}
			else if(map[i] == Game.Stone.White)
			{
				// 碁石(白)表示
				g.drawImage(
						img_white_stone,
						10 * (i % game_data.finalBoard_Width),
						10 * (i / game_data.finalBoard_Width),
						30, 30, this);
			}
		}
	}
}
