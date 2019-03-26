package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// ゲーム管理
	private Game g;
	
	protected void setUp() throws Exception
	{
		this.g = new Game();
	}
	
	// ガーターゲームのテスト
	public void testGutterGame() throws Exception
	{
		int n = 20;
		int pins = 0;
		
		// 全てのゲームのロールでスコア0を設定
		rollMany( n, pins );
		
		// スコアが0であることを確認
		assertEquals( 0, g.score() );
	}
	
	// 指定されたピン数ですべてロールのスコアを設定
	private void rollMany( int n, int pins )
	{
		for( int i = 0; i < n; i++ )
		{
			g.roll( pins );
		}
	}
	
	public void testAllOnes() throws Exception
	{
		// 全てのゲームのロールでスコア1を設定
		for( int i = 0; i < 20; i++ )
		{
			g.roll( 1 );
		}
		
		// スコアが 20になることを確認
		assertEquals( 20, g.score() );
	}
}
