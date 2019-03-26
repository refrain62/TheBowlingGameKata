package kata.bowling;

// �{�[�����O�̃Q�[���Ǘ�
public class Game
{
	// �Q�[���X�R�A�ێ��p
	private int score = 0;
	
	// �Q�[�����[���ێ��p�i2�� �~ 10�Q�[�� ����10�Q�[���ڂ�3���[���Ȃ̂� + 1 = 21�j
	private int rolls[] = new int[21];
	
	// ���݂̃��[���ێ��p
	private int currentRoll = 0;
	
	// �Q�[�����[��
	public void roll(int pins)
	{
		score += pins;
		
		// �|�����s���������[���ɕR�Â��ĕێ�
		rolls[ currentRoll++ ] = pins;
	}

	// �X�R�A�̎擾
	public int score()
	{
		return score;
	}

}
