import axios from 'axios';

import { getAnswers } from './answer.service';

describe('AnswerService', () => {
  jest.mock('axios');

  describe('getAnswers', () => {
    const questionId = 1;
    const mockAnswers = [{
      answer: '관계형 모델은 실제 세계의 데이터를',
      answerOrder: 1,
      wordId: 0,
    },
    {
      answer: '라는 개념을 사용해 구현한 데이터 모델이다.',
      answerOrder: 2,
      wordId: 1,
    }];

    describe('with existing questionId', () => {
      beforeEach(() => {
        axios.get = jest.fn().mockResolvedValue({
          questionId,
          data: mockAnswers,
        });
      });

      it('returns answers', async () => {
        const { questionId: id, answers } = await getAnswers(questionId);

        expect(answers).toEqual(mockAnswers);
        expect(id).toEqual(questionId);
      });
    });

    describe('with not existing questionId', () => {
      beforeEach(() => {
        axios.get = jest.fn().mockResolvedValue({
          questionId,
          data: [],
        });
      });

      it('returns empty array', async () => {
        const { questionId: id, answers } = await getAnswers(questionId);

        expect(answers).toEqual([]);
        expect(id).toEqual(questionId);
      });
    });
  });
});
