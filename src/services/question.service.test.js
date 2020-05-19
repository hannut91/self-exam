import axios from 'axios';

import { getQuestions, getCorrects } from './question.service';

describe('QuestionService', () => {
  jest.mock('axios');

  describe('getQuestions', () => {
    const mockQuestions = [{
      id: 1,
      question: '질문',
    }];

    beforeEach(() => {
      axios.get = jest.fn().mockResolvedValue({ data: mockQuestions });
    });

    it('returns questions', async () => {
      const questions = await getQuestions();

      expect(questions).toEqual(mockQuestions);
    });
  });

  describe('getCorrects', () => {
    const questionId = 1;
    const answers = {
      1: '단어',
      2: '답변',
    };

    beforeEach(() => {
      axios.post = jest.fn().mockResolvedValue({
        data: [{
          wordId: 1,
          isCorrect: true,
        }, {
          wordId: 1,
          isCorrect: true,
        }],
      });
    });

    it('returns corrects', async () => {
      const { corrects } = await getCorrects({ questionId, answers });

      corrects.forEach((it) => expect(it.isCorrect).toBe(true));
    });
  });
});
