package kata.bowling;

// ボーリングのゲーム管理
public class Game
{
	// ゲームロール保持用（2回 × 10ゲーム だが10ゲーム目が3ロールなので + 1 = 21）
	private int rolls[] = new int[21];
	
	// 現在のロール保持用
	private int currentRoll = 0;
	
	// ゲームロール
	public void roll(int pins)
	{
		// 倒したピン数をロールに紐づけて保持
		this.rolls[ this.currentRoll++ ] = pins;
	}

	// スコアの取得
	public int score()
	{
		int score = 0;
		int frameIndex = 0;
		
		// 全ロールのピン数を足しあげる
		for( int frame = 0; frame < 10; frame++ )
		{
			// フレーム内の合計が10になる場合（スペアになる場合）
			if(		this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ] == 10
				)
			{
				score += 10 + this.rolls[ frameIndex + 2 ];
				
				frameIndex += 2;
			}
			// それ以外はフレーム内の合計を足しあげる
			else
			{
				score += rolls[ frameIndex ] + rolls[ frameIndex + 1 ];
				
				frameIndex += 2;
			}
		}
		
		return score;
	}

}
