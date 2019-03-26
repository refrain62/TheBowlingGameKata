package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// ゲーム管理
	private Game game;
	
	// ゲームのインスタンスの生成
	protected void setUp() throws Exception
	{
		this.game = new Game();
	}

	// 指定されたピン数で指定ロール数のスコアを設定
	private void rollMany( int rollCnt, int pins )
	{
		for( int i = 0; i < rollCnt; i++ )
		{
			this.game.roll( pins );
		}
	}
	
	// ガーターゲームのテスト
	public void testGutterGame() throws Exception
	{
		// 全てのゲームのロールでスコア0を設定
		this.rollMany( 20, 0 );
		
		// スコアが0であることを確認
		assertEquals( 0, this.game.score() );
	}
	
	// すべてのゲームロールで１だった場合のテスト
	public void testAllOnes() throws Exception
	{
		// 全てのゲームのロールでスコア1を設定
		this.rollMany( 20, 1 );
		
		// スコアが 20になることを確認
		assertEquals( 20, this.game.score() );
	}
	
	// 1回スペアになった場合のテスト
	// ※スペアは「次の１投分を加算することができる」
	public void testOneSpare() throws Exception
	{
		// スペアを取った場合
		this.rollSparea();
		
		this.game.roll( 3 );

		// 残りのロール（全20回 - 上記3回 = 17回）はすべてスコアが0だったと想定
		this.rollMany( 17, 0 );

		// スコアが 16(5 + 5 + 3 + 3)になることを確認
		assertEquals( 16, this.game.score() );
	}

	// 1回ストライクになった場合のテスト
	// ※ストライクは１投目で10本全部倒した場合。ストライクを足したフレームの得点は、次の２投分を加算する[10＋○＋○]
	public void testOneStrike() throws Exception
	{
		// ストライクを取った場合
		this.rollStrike();
		
		this.game.roll( 3 );
		this.game.roll( 4 );

		// 残りのロール（全20回 - 上記4回（ストライクは2ロール分） = 16回）はすべてスコアが0だったと想定
		this.rollMany( 16, 0 );

		// スコアが 24(10 + (3 + 4) + (3 + 4))になることを確認
		assertEquals( 24, this.game.score() );
	}
	
	// パーフェクトゲームの場合のテスト
	public void testPerfectGmae() throws Exception
	{
		// 全てのゲームでストライク（10フレーム＋10フレーム２投目＋10フレーム3投目＝12回）
		this.rollMany( 12, 10 );

		// スコアが 300になることを確認
		assertEquals( 300, this.game.score() );
	}
	
	// ストライクを取った場合
	private void rollStrike()
	{
		this.game.roll( 10 );
	}
	
	// スペアを取った場合
	private void rollSparea()
	{
		game.roll( 5 );
		game.roll( 5 );
	}
}
