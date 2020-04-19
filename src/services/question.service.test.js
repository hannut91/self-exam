import { getQuestions, addQuestion, removeQuestion } from './question.service';

describe('QuestionService', () => {
  beforeEach(() => {
    localStorage.setItem('questions', '');
    localStorage.setItem('nextId', '');
  });

  afterEach(() => {
    localStorage.setItem('questions', '');
    localStorage.setItem('nextId', '');
  });

  describe('getQuestions', () => {
    const mockQuestions = [{
      id: 1,
      question: '질문',
      answer: '답변',
    }];

    beforeEach(() => {
      localStorage.setItem('questions', JSON.stringify(mockQuestions));
    });

    it('returns questions', () => {
      const questions = getQuestions();

      expect(questions).toEqual(mockQuestions);
    });
  });

  describe('addQuestion', () => {
    const question = {
      question: '질문',
      answer: '대답',
    };

    it('appends question', () => {
      addQuestion(question);
      addQuestion(question);

      const questions = getQuestions();

      expect(questions[0].id).toBe(1);
      expect(questions[1].id).toBe(2);
    });
  });

  describe('deleteQuestion', () => {
    const question = {
      question: '질문',
      answer: '대답',
    };

    beforeEach(() => {
      addQuestion(question);
    });

    it('deletes question by id', () => {
      removeQuestion(1);

      const questions = getQuestions();

      expect(questions.length).toBe(0);
    });
  });
});
