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
		this.rollMany( 20, 0 );
		
		// �X�R�A��0�ł��邱�Ƃ��m�F
		assertEquals( 0, g.score() );
	}
	
	// ���ׂẴQ�[�����[���łP�������ꍇ�̃e�X�g
	public void testAllOnes() throws Exception
	{
		// �S�ẴQ�[���̃��[���ŃX�R�A1��ݒ�
		this.rollMany( 20, 1 );
		
		// �X�R�A�� 20�ɂȂ邱�Ƃ��m�F
		assertEquals( 20, g.score() );
	}
	
	// 1��X�y�A�ɂȂ����ꍇ�̃e�X�g
	// ���X�y�A�́u���̂P���������Z���邱�Ƃ��ł���v
	public void testOneSpare() throws Exception
	{
		// �X�y�A��������ꍇ
		this.rollSparea();
		
		g.roll( 3 );

		// �c��̃��[���i�S20�� - ��L3�� = 17��j�͂��ׂăX�R�A��0�������Ƒz��
		this.rollMany( 17, 0 );

		// �X�R�A�� 16(5 + 5 + 3 + 3)�ɂȂ邱�Ƃ��m�F
		assertEquals( 16, g.score() );
	}

	// 1��X�g���C�N�ɂȂ����ꍇ�̃e�X�g
	// ���X�g���C�N�͂P���ڂ�10�{�S���|�����ꍇ�B�X�g���C�N�𑫂����t���[���̓��_�́A���̂Q���������Z����[10�{���{��]
	public void testOneStrike() throws Exception
	{
		// �X�g���C�N��������ꍇ
		this.rollStrike();
		
		g.roll( 3 );
		g.roll( 4 );

		// �c��̃��[���i�S20�� - ��L4��i�X�g���C�N��2���[�����j = 16��j�͂��ׂăX�R�A��0�������Ƒz��
		this.rollMany( 16, 0 );

		// �X�R�A�� 24(10 + (3 + 4) + (3 + 4))�ɂȂ邱�Ƃ��m�F
		assertEquals( 24, g.score() );
	}
	
	// �p�[�t�F�N�g�Q�[���̏ꍇ�̃e�X�g
	public void testPerfectGmae() throws Exception
	{
		// �S�ẴQ�[���ŃX�g���C�N
		this.rollMany( 12, 10 );

		// �X�R�A�� 300�ɂȂ邱�Ƃ��m�F
		assertEquals( 300, g.score() );
	}
	
	// �X�g���C�N��������ꍇ
	private void rollStrike()
	{
		g.roll( 10 );
	}
	
	// �X�y�A��������ꍇ
	private void rollSparea()
	{
		g.roll( 5 );
		g.roll( 5 );
	}
}
