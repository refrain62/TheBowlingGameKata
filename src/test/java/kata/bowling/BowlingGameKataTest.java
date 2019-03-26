package kata.bowling;

import junit.framework.TestCase;

public class BowlingGameKataTest extends TestCase
{
	// �Q�[���Ǘ�
	private Game g;
	
	// �Q�[���̃C���X�^���X�̐���
	protected void setUp() throws Exception
	{
		this.g = new Game();
	}

	// �w�肳�ꂽ�s�����Ŏw�胍�[�����̃X�R�A��ݒ�
	private void rollMany( int n, int pins )
	{
		for( int i = 0; i < n; i++ )
		{
			g.roll( pins );
		}
	}
	
	// �K�[�^�[�Q�[���̃e�X�g
	public void testGutterGame() throws Exception
	{
		// �S�ẴQ�[���̃��[���ŃX�R�A0��ݒ�
		rollMany( 20, 0 );
		
		// �X�R�A��0�ł��邱�Ƃ��m�F
		assertEquals( 0, g.score() );
	}
	
	// ���ׂẴQ�[�����[���łP�������ꍇ�̃e�X�g
	public void testAllOnes() throws Exception
	{
		// �S�ẴQ�[���̃��[���ŃX�R�A1��ݒ�
		rollMany( 20, 1 );
		
		// �X�R�A�� 20�ɂȂ邱�Ƃ��m�F
		assertEquals( 20, g.score() );
	}
}
