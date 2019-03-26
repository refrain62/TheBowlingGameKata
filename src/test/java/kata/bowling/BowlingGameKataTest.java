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
		this.rollMany( 20, 0 );
		
		// スコアが0であることを確認
		assertEquals( 0, g.score() );
	}
	
	// すべてのゲームロールで１だった場合のテスト
	public void testAllOnes() throws Exception
	{
		// 全てのゲームのロールでスコア1を設定
		this.rollMany( 20, 1 );
		
		// スコアが 20になることを確認
		assertEquals( 20, g.score() );
	}
	
	// 1回スペアになった場合のテスト
	// ※スペアは「次の１投分を加算することができる」
	public void testOneSpare() throws Exception
	{
		// スペアを取った場合
		this.rollSparea();
		
		g.roll( 3 );

		// 残りのロール（全20回 - 上記3回 = 17回）はすべてスコアが0だったと想定
		this.rollMany( 17, 0 );

		// スコアが 16(5 + 5 + 3 + 3)になることを確認
		assertEquals( 16, g.score() );
	}

	// スペアを取った場合
	private void rollSparea()
	{
		g.roll( 5 );
		g.roll( 5 );
	}
}
