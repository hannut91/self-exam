import React from 'react';

import QuestoinHead from './QuestionHead';
import QuestionBody from './QuestionBody';

const Question = ({ question }) => (
  <>
    <QuestoinHead question={question} />
    <QuestionBody question={question} />
  </>
);

export default Question;
