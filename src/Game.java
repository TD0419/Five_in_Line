import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Arrays;

// ゲームを管理するクラス
public class Game
{
	// 石の種類
	public enum Stone
	{
		None,
		White,
		Black
	};

	public final int finalBoard_Width = 19;
	public final int finalBoard_Height = 19;

	Stone[] m_board = new Stone[finalBoard_Width * finalBoard_Height] ;
	Stone m_turn;
	Point m_mouse_input_point;
	boolean m_input; // マウス入力されたかを管理する true 入力された false されていない

	public Game()
	{
		// 初期化
		Arrays.fill(m_board, Stone.None);
		m_turn = Stone.Black;
		m_input = false;
	}

	public void Loop()
	{
		boolean input_check = false;
		// 入力処理
		if(m_input == true)
		{
			// 入力判定
			input_check = Input_Check(m_mouse_input_point, m_turn);

			m_input = false;
		}


		if(input_check)
		{
			// 勝利したかどうか判定(した場合はループ終了)

			// ターン入れ替え
			m_turn = Turn_Change(m_turn);
		}
	}

	// マウスの入力をチェックする関数
	// 戻り値 成功ならtrue 失敗ならfalse
	private boolean Input_Check(Point mouse_input, Stone turn)
	{
		int map_input_position_x, map_input_position_y;
		map_input_position_x = mouse_input.x / 10;
		map_input_position_y = mouse_input.y / 10;

		// 範囲外チェック
		if(Map_Out_Of_Range_Check(map_input_position_x, map_input_position_y))
		{
			return false;
		}

		// 盤に石を置く
		m_board[map_input_position_y * finalBoard_Width + map_input_position_x] = turn;

		return true;
	}

	// マップ配列の範囲内かを調べる関数
	// 戻り値 範囲内ならtrue 外ならfalse
	private boolean Map_Out_Of_Range_Check(int map_x, int map_y)
	{
		if(map_x >= finalBoard_Width) return false;
		if(map_y >= finalBoard_Height) return false;
		if(map_x < 0) return false;
		if(map_y < 0) return false;

		return true;
	}

	// ターンを入れ替える関数
	// 戻り値に現在のターンを返す
	private Stone Turn_Change(Stone turn)
	{
		if(turn == Stone.White)
		{
			return Stone.Black;
		}
		else
		{
			return Stone.White;
		}
	}

	public void mouseClicked(MouseEvent e)
	{
		m_mouse_input_point = e.getPoint();
		m_input = true;
	}

	public Stone[] MapAllData()
	{
		return m_board;
	}
}
