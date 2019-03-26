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
			// 1�t���[���ŃX�g���C�N�ɂȂ����ꍇ
			if(		this.isStrike( frameIndex ) == true
				)
			{
				score += 10 + this.strikeBonus( frameIndex );
						
				// ���̃t���[����
				frameIndex++;
			}
			// �t���[�������X�y�A�ɂȂ�ꍇ
			else if(	this.isSpare( frameIndex ) == true
					)
			{
				score += 10 + this.spareBonus( frameIndex );
				
				frameIndex += 2;
			}
			// ����ȊO�̓t���[�����̍��v�𑫂�������
			else
			{
				score += this.sumOfBallsInFrame( frameIndex );
				
				frameIndex += 2;
			}
		}
		
		return score;
	}
	
	// �t���[�����̃s�����̍��v
	private int sumOfBallsInFrame( int frameIndex )
	{
		return this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ];
	}

	// �X�y�A�̏ꍇ�̃{�[�i�X��
	private int spareBonus( int frameIndex )
	{
		return this.rolls[ frameIndex + 2 ];
	}

	// �X�g���C�N�̏ꍇ�̃{�[�i�X��
	private int strikeBonus( int frameIndex )
	{
		return this.rolls[ frameIndex + 1 ] + this.rolls[ frameIndex + 2 ];
	}
	
	// �X�y�A���ǂ������f
	private boolean isSpare( int frameIndex )
	{
		return this.rolls[ frameIndex ] + this.rolls[ frameIndex + 1 ] == 10;
	}
	
	// �X�g���C�N���ǂ������f
	private boolean isStrike( int frameIndex )
	{
		return this.rolls[ frameIndex ] == 10;
	}

}
