package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// �Q�[���Ǘ�
	private Game g;
	
	protected void setUp() throws Exception
	{
		this.g = new Game();
	}
	
	// �K�[�^�[�Q�[���̃e�X�g
	public void testGutterGame() throws Exception
	{
		int n = 20;
		int pins = 0;
		
		// �S�ẴQ�[���̃��[���ŃX�R�A0��ݒ�
		rollMany( n, pins );
		
		// �X�R�A��0�ł��邱�Ƃ��m�F
		assertEquals( 0, g.score() );
	}
	
	// �w�肳�ꂽ�s�����ł��ׂă��[���̃X�R�A��ݒ�
	private void rollMany( int n, int pins )
	{
		for( int i = 0; i < n; i++ )
		{
			g.roll( pins );
		}
	}
	
	public void testAllOnes() throws Exception
	{
		// �S�ẴQ�[���̃��[���ŃX�R�A1��ݒ�
		for( int i = 0; i < 20; i++ )
		{
			g.roll( 1 );
		}
		
		// �X�R�A�� 20�ɂȂ邱�Ƃ��m�F
		assertEquals( 20, g.score() );
	}
}
