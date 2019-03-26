package kata.bowling;

// ボーリングのゲーム管理
public class Game
{
	// ゲームスコア保持用
	private int score = 0;
	
	// ゲームロール
	public void roll(int pins)
	{
		score += pins;
	}

	// スコアの取得
	public int score()
	{
		return score;
	}

}
