package kata.bowling;

// �{�[�����O�̃Q�[���Ǘ�
public class Game
{
	// �Q�[���X�R�A�ێ��p
	private int score = 0;
	
	// �Q�[�����[��
	public void roll(int pins)
	{
		score += pins;
	}

	// �X�R�A�̎擾
	public int score()
	{
		return score;
	}

}
