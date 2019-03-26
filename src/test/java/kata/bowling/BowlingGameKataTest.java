package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// �K�[�^�[�Q�[���̃e�X�g
	public void testGutterGame() throws Exception
	{
		Game g = new Game();
		
		// �S�ẴQ�[���̃��[���ŃX�R�A0��ݒ�
		for( int i = 0; i < 20; i++ )
		{
			g.roll( 0 );
		}
		
		// �X�R�A��0�ł��邱�Ƃ��m�F
		assertEquals( 0, g.score() );
	}
}
