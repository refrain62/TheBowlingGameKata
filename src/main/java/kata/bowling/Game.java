package kata.bowling;

// �{�[�����O�̃Q�[���Ǘ�
public class Game
{
	// �Q�[�����[���ێ��p�i2�� �~ 10�Q�[�� ����10�Q�[���ڂ�3���[���Ȃ̂� + 1 = 21�j
	private int rolls[] = new int[21];
	
	// ���݂̃��[���ێ��p
	private int currentRoll = 0;
	
	// �Q�[�����[��
	public void roll(int pins)
	{
		// �|�����s���������[���ɕR�Â��ĕێ�
		this.rolls[ this.currentRoll++ ] = pins;
	}

	// �X�R�A�̎擾
	public int score()
	{
		int score = 0;
		int frameIndex = 0;
		
		// �S���[���̃s�����𑫂�������
		for( int frame = 0; frame < 10; frame++ )
		{
			// �t���[�������X�y�A�ɂȂ�ꍇ
			if(		isSpare( frameIndex ) == true
				)
			{
				score += 10 + this.rolls[ frameIndex + 2 ];
				
				frameIndex += 2;
			}
			// ����ȊO�̓t���[�����̍��v�𑫂�������
			else
			{
				score += this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ];
				
				frameIndex += 2;
			}
		}
		
		return score;
	}
	
	// �X�y�A���ǂ������f
	private boolean isSpare( int frameIndex )
	{
		return this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ] == 10;
	}

}
