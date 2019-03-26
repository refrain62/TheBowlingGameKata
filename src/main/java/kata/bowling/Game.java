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
			// 1フレームでストライクになった場合
			if(		this.isStrike( frameIndex ) == true
				)
			{
				score += 10 + this.strikeBonus( frameIndex );
						
				// 次のフレームへ
				frameIndex++;
			}
			// フレーム内がスペアになる場合
			else if(	this.isSpare( frameIndex ) == true
					)
			{
				score += 10 + this.spareBonus( frameIndex );
				
				frameIndex += 2;
			}
			// それ以外はフレーム内の合計を足しあげる
			else
			{
				score += this.sumOfBallsInFrame( frameIndex );
				
				frameIndex += 2;
			}
		}
		
		return score;
	}
	
	// フレーム内のピン数の合計
	private int sumOfBallsInFrame( int frameIndex )
	{
		return this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ];
	}

	// スペアの場合のボーナス数
	private int spareBonus( int frameIndex )
	{
		return this.rolls[ frameIndex + 2 ];
	}

	// ストライクの場合のボーナス数
	private int strikeBonus( int frameIndex )
	{
		return this.rolls[ frameIndex + 1 ] + this.rolls[ frameIndex + 2 ];
	}
	
	// スペアかどうか判断
	private boolean isSpare( int frameIndex )
	{
		return this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ] == 10;
	}
	
	// ストライクかどうか判断
	private boolean isStrike( int frameIndex )
	{
		return this.rolls[ frameIndex ] == 10;
	}

}
