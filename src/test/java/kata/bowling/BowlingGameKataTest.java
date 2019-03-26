package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// ガーターゲームのテスト
	public void testGutterGame() throws Exception
	{
		Game g = new Game();
		
		// 全てのゲームのロールでスコア0を設定
		for( int i = 0; i < 20; i++ )
		{
			g.roll( 0 );
		}
		
		// スコアが0であることを確認
		assertEquals( 0, g.score() );
	}
}
