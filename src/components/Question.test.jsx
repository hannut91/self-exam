import React from 'react';

import * as ReactRedux from 'react-redux';

import { render, screen } from 'test-util';

import Question from './Question';

describe('Question', () => {
  it('renders title of question', () => {
    ReactRedux.useDispatch = jest.fn().mockReturnValue();

    const question = {
      id: 1,
      question: '관계형 모델이란 무엇인가?',
      answer: '관계형 모델은 실제 세계의 데이터를 관계라는 개념을 사용해서 표현한 데이터 모델',
    };

    render(<Question question={question} />);

    expect(screen.getByText(question.question)).toBeInTheDocument();
  });
});
