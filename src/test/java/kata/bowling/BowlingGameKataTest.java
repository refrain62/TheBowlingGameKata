package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// ゲーム管理
	private Game g;
	
	// ゲームのインスタンスの生成
	protected void setUp() throws Exception
	{
		this.g = new Game();
	}

	// 指定されたピン数で指定ロール数のスコアを設定
	private void rollMany( int n, int pins )
	{
		for( int i = 0; i < n; i++ )
		{
			g.roll( pins );
		}
	}
	
	// ガーターゲームのテスト
	public void testGutterGame() throws Exception
	{
		// 全てのゲームのロールでスコア0を設定
		rollMany( 20, 0 );
		
		// スコアが0であることを確認
		assertEquals( 0, g.score() );
	}
	
	// すべてのゲームロールで１だった場合のテスト
	public void testAllOnes() throws Exception
	{
		// 全てのゲームのロールでスコア1を設定
		rollMany( 20, 1 );
		
		// スコアが 20になることを確認
		assertEquals( 20, g.score() );
	}
}
